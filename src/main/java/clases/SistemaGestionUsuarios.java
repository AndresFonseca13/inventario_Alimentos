package clases;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class SistemaGestionUsuarios {
    private Map<String, User> users;

    public SistemaGestionUsuarios() {
        this.users = new HashMap<>();
    }

    public boolean registrarUsuario(String userName, String password) {
        if (users.containsKey(userName)) {
            return false;
        }
        users.put(userName, new User(userName, password));
        System.out.println("Usuario registrado con éxito");
        return true;
    }

    public User iniciarSesion(String nombreUsuario, String password) {
        User user = users.get(nombreUsuario);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
