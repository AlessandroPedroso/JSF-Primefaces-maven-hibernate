package dao;

import Model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	
	
	
	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		
		 getEntityManager().getTransaction().begin();
		 String sqlDeleteFone = "delete from telefoneuser where usuariopessoa_id = " + pessoa.getId();
		 getEntityManager().createNativeQuery(sqlDeleteFone).executeUpdate();
		 getEntityManager().getTransaction().commit();
		 
		 super.deletarPoId(pessoa);
		
	}
}
