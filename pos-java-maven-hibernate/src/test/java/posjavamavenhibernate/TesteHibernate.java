package posjavamavenhibernate;

import org.junit.Test;

import Model.UsuarioPessoa;
import dao.DaoGeneric;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		
		HibernateUtil.getEntityManager();
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setIdade(27);
		pessoa.setLogin("adminEduardo");
		pessoa.setSenha("teste");
		pessoa.setEmail("eduardopedroso@gmail.com");
		pessoa.setNome("Eduardo froner");
		pessoa.setSobrenome("pedroso");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test
	public void testeBuscar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(1L);
		
		 pessoa = daoGeneric.pesquisar1(pessoa);
		 //pessoa = daoGeneric.pesquisar2(pessoa);
		 //pessoa = daoGeneric.pesquisar3(pessoa);
		//UsuarioPessoa pessoa1 = daoGeneric.pesquisar4(1L, UsuarioPessoa.class);
		//UsuarioPessoa pessoa1 = daoGeneric.pesquisar5(1L, UsuarioPessoa.class);
		 
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeUpdate() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(1L);
		
		 pessoa = daoGeneric.pesquisar1(pessoa);
		 pessoa.setIdade(99);;
		 pessoa.setNome("Nome Atualizado Hibernate");
		 pessoa = daoGeneric.updateMerge(pessoa);
		 //pessoa = daoGeneric.pesquisar2(pessoa);
		 //pessoa = daoGeneric.pesquisar3(pessoa);
		//UsuarioPessoa pessoa1 = daoGeneric.pesquisar4(1L, UsuarioPessoa.class);
		//UsuarioPessoa pessoa1 = daoGeneric.pesquisar5(1L, UsuarioPessoa.class);
		 
		
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeDeletar() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar4(2L, UsuarioPessoa.class);
		
		daoGeneric.deletarPoId(pessoa);
		
	}

}
