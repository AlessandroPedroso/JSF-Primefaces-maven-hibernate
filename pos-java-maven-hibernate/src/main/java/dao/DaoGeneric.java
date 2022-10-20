package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Model.UsuarioPessoa;
import posjavamavenhibernate.HibernateUtil;

public class DaoGeneric<E>{
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		entityManager.persist(entidade);
		transaction.commit();
	}
	
	public E updateMerge(E entidade) { //salva ou atualiza
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		E entidadeSalva = entityManager.merge(entidade);
		transaction.commit();
		
		return entidadeSalva;
	}
	
	public void deletarPoId(E entidade) {
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin(); // da o start
		
		entityManager.createNativeQuery("delete from " + entidade.getClass().getSimpleName().toLowerCase() + " where id =" + id).executeUpdate();// faz o delete
		entityTransaction.commit();// grava alteração no banco
		
		
		
	}
	
	public UsuarioPessoa pesquisar1(UsuarioPessoa entidade) { // sem o metodo de getPrimaryKey
		
		//Object id = HibernateUtil.getPrimaryKey(entidade);
		
		UsuarioPessoa usuario = entityManager.find(entidade.getClass(), entidade.getId());
		
		return usuario;
		
	}
	
	public UsuarioPessoa pesquisar2(UsuarioPessoa entidade) { // com o metodo de getPrimaryKey
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		UsuarioPessoa usuario = entityManager.find(entidade.getClass(), entidade.getId());
		
		return usuario;
		
	}
	
	public E pesquisar3(E entidade) { // 
		
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		E usuario = (E) entityManager.find(entidade.getClass(), id);
		
		return usuario;
		
	}
	
	public E pesquisar4(Long id, Class<E> entidade) {

		E usuario = (E) entityManager.find(entidade, id);
		
		return usuario;
		
	}
	
	public UsuarioPessoa pesquisar5(Long id, Class<UsuarioPessoa> entidade) {

		UsuarioPessoa usuario = entityManager.find(entidade, id);
		
		return usuario;
		
	}


}
