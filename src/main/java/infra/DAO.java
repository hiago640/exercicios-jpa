package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public List<E> consultar(String nomeConsulta, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for(int i = 0; i < params.length; i += 2)
			query.setParameter(params[i].toString(), params[i + 1]);
		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object... params){
		List<E> list = consultar(nomeConsulta, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public E findById(Object id){
		return em.find(classe, id);
	}
	
	public void close() {
		em.close();
	}
}
