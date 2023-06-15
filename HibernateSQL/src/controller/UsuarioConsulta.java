package controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Usuario;

public class UsuarioConsulta {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Usuario resultado = session.get(Usuario.class, 4);
			System.out.println("Registro obtenido" + resultado);

			List<Usuario> resultados = session.createQuery("from Usuario").list();
			System.out.println("/nConsulta general");

			for (Usuario u : resultados) {
				System.out.println(u);
			}

			session.getTransaction().commit();

			System.out.println("Proceso Exitoso");
		} finally {

			factory.close();
		}
	}
}
