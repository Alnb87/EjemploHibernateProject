
package com.example;

import com.example.dao.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Insertar usuarios
        usuarioDAO.insertarUsuario("Juan Perez", "juan@example.com");
        usuarioDAO.insertarUsuario("Maria Lopez", "maria@example.com");

        // Obtener y mostrar usuarios
        usuarioDAO.obtenerUsuarios().forEach(usuario -> {
            System.out.println("ID: " + usuario.getId() + ", Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo());
        });
    }
}
