
package com.example.dao;

import com.example.entities.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class UsuarioDAO {
    private SessionFactory sessionFactory;

    public UsuarioDAO() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();
    }

    public void insertarUsuario(String nombre, String correo) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Usuario usuario = new Usuario(nombre, correo);
            session.save(usuario);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public List<Usuario> obtenerUsuarios() {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Usuario> usuarios = session.createQuery("from Usuario", Usuario.class).getResultList();
            session.getTransaction().commit();
            return usuarios;
        } finally {
            session.close();
        }
    }
}
