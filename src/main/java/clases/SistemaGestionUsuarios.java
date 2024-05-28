package clases;

import java.util.HashMap;
import java.util.Map;

// La clase SistemaGestionUsuarios se encarga de gestionar los usuarios en el sistema.
// Esta clase contiene un mapa para almacenar los usuarios, donde la clave es el nombre de usuario y el valor es el objeto User.
public class SistemaGestionUsuarios {
    // Mapa para almacenar los usuarios
    private final Map<String, User> users;

    // Constructor de la clase SistemaGestionUsuarios
    // Inicializa el mapa de usuarios
    public SistemaGestionUsuarios() {
        this.users = new HashMap<>();
    }

    // Método para registrar un nuevo usuario
    // Si el nombre de usuario ya existe en el mapa, retorna false
    // Si el nombre de usuario no existe, crea un nuevo usuario, lo agrega al mapa y retorna true
    public boolean registrarUsuario(String userName, String password) {
        if (users.containsKey(userName)) {
            return false;
        }
        users.put(userName, new User(userName, password));
        System.out.println("Usuario registrado con éxito");
        return true;
    }

    // Método para iniciar sesión
    // Si el nombre de usuario existe en el mapa y la contraseña es correcta, retorna el objeto User
    // Si el nombre de usuario no existe o la contraseña es incorrecta, retorna null
    public User iniciarSesion(String nombreUsuario, String password) {
        User user = users.get(nombreUsuario);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
