package clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// La anotación @Getter de Lombok genera automáticamente los métodos getter para cada campo.
// La anotación @Setter de Lombok genera automáticamente los métodos setter para cada campo.
// La anotación @AllArgsConstructor de Lombok genera automáticamente un constructor con todos los campos como argumentos.
// La anotación @NoArgsConstructor de Lombok genera automáticamente un constructor sin argumentos.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// La clase User representa a un usuario en el sistema.
// Esta clase contiene dos campos: email y password.
public class User {

    // Email del usuario
    private String email;

    // Contraseña del usuario
    private String password;
}
