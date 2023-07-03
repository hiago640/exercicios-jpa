package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT U FROM Usuario U";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> usuarios = query.getResultList();
		
		usuarios.forEach(System.out::println);
		
		em.close();
		emf.close();
	}
}
