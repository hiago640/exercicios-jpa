package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Entidade;

public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			System.err.println("Não foi possível criar EntityManeger");
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
 		em = emf.createEntityManager();
	}
	
	public DAO<E> openTX() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> closeTX() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> save(E entity) {
		em.persist(entity);
		return this;
	}
	
	public List<E> findAll() {
		return findAll(10, 10);
	}
	
	public List<E> findAll(int limit, int offSet) {
		if (classe == null)
			throw new UnsupportedOperationException("Classe nula.");

		String jpql = String.format("from %s", classe.getName());
		return em.createQuery(jpql, classe)
				.setMaxResults(limit)
				.setMaxResults(offSet).getResultList();
	}
	
	public void close() {
		em.close();
	}
}
