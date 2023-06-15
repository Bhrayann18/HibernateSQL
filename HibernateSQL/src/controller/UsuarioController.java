package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Usuario;

public class UsuarioController {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Usuario user = new Usuario("Brayann", "Cortes", "cpucortes@outlook.com", "eltcccc");

			session.save(user);

			session.getTransaction().commit();

			System.out.println("Usuario almacenado");
		} finally {

			factory.close();
		}
	}

}
