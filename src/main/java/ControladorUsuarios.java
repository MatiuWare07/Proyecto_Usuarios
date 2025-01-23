public class ControladorUsuarios {
    private UsuarioDAO usuarioDAO;

    public ControladorUsuarios(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean registrarUsuario(String email, String password){
        Usuario usuario = new Usuario(email, password);
        return usuarioDAO.guardarUsuario(usuario);// Devuelve true o false dependiendo de si se pudo registrar o no el usuario
    }
}
