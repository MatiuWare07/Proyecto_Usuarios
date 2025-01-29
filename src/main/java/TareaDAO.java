import java.sql.*;
import java.util.ArrayList;

public class TareaDAO {
    private Connection conexion;

    public TareaDAO(Connection bd) {
        this.conexion = conexion;
    }

    public ArrayList<Tarea> recuperarTareasDeUsuario(Usuario usuario){
        ArrayList<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tarea WHERE usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarea tarea = new Tarea(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getBoolean("estado"),
                        usuario
                );
                tareas.add(tarea);
            }

            usuario.getTareas().clear();
            usuario.getTareas().addAll(tareas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }
}

