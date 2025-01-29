import java.util.ArrayList;

public class Usuario {

    private String email;
    private String password;
    private ArrayList<Tarea> tareas;

    public Usuario(String email, String password){
        this.email = email;
        this.password = password;
        this.tareas = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void addTarea(Tarea tarea) {
        this.tareas.add(tarea);
    }

    public Tarea getTarea(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}
