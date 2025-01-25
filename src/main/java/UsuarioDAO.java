import java.sql.*;
// Esta clase incluye el método para guardar usuarios (guardarUsuario) y prevenir duplicados.
public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(){
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/RegistroUsuarios", "root", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean guardarUsuario(Usuario usuario){
        try{
            String query = "INSERT INTO Usuario (email, password) VALUES (?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getPassword());
            stmt.executeUpdate();
            return true;
        }catch (Exception e){
            if(e.getMessage().contains("Duplicate entry")){
                System.out.println("Este usuario ya esta registrado");
            }else{
                e.printStackTrace();
            }
            return false;
        }
    }

    public boolean validarUsuario(String email, String password) {
        try {
            String query = "SELECT * FROM Usuario WHERE email = ? AND password = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Si hay resultados, las credenciales son válidas
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
