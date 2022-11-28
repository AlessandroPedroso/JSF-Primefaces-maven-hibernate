package posjavamavenhibernate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.TelefoneUser;
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
		
		UsuarioPessoa pessoa = daoGeneric.pesquisar4(6L, UsuarioPessoa.class);
		
		try {
			daoGeneric.deletarPoId(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testeConsultarLista() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> listPessoa = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : listPessoa) {
			
				System.out.println(usuarioPessoa);
				System.out.println("-------------------------------------------------");
		}

	}
	
	@Test
	public void testeQueryList() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		//List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa").getResultList();
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa where nome = 'Alessandro'").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQueryListMaxResult() {
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		//List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery("from UsuarioPessoa").getResultList();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().
				createQuery("from UsuarioPessoa order by id")
				.setMaxResults(2)
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.
				getEntityManager().createQuery("from UsuarioPessoa where nome = :nome or sobrenome = :sobrenome")
				.setParameter("nome", "Alessandro")
				.setParameter("sobrenome", "schuquel")
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}
		
		
	}
	
	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		//Long somaIdade = (Long) daoGeneric.getEntityManager().createQuery("select sum(u.idade) from UsuarioPessoa u").getSingleResult();
		Double media = (Double) daoGeneric.getEntityManager().createQuery("select avg(u.idade) from UsuarioPessoa u").getSingleResult();
		System.out.println("Soma de todas as idades é --> " + media);
		
	}
	
	
	@Test
	public void testeBuscaQuery() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		//UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.getEntityManager().createQuery("from UsuarioPessoa where nome = 'Alessandro'").getSingleResult();
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.getEntityManager().createQuery("from UsuarioPessoa where nome = :nome")
				.setParameter("nome", "Alessandro")
				.getSingleResult();
		//Double media = (Double) daoGeneric.getEntityManager().createQuery("select avg(u.idade) from UsuarioPessoa u").getSingleResult();
		System.out.println(pessoa);
		
	}
	
	@Test
	public void testeNameQuery1() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.todos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}
	}
	
	
	@Test
	public void testeNameQuery2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.buscaPorNome")
		.setParameter("nome", "Alessandro")
		.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
		}
	}
	
	
	@Test
	public void testeGravaTelefone() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa =  (UsuarioPessoa) daoGeneric.pesquisar4(4L, UsuarioPessoa.class);
		
		TelefoneUser telefoneUser = new TelefoneUser();
		telefoneUser.setTipo("Telefone");
		telefoneUser.setNumero("51 789564231");
		telefoneUser.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefoneUser);
	}
	
	
	@Test
	public void testeConsultaTelefones() {
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa =  (UsuarioPessoa) daoGeneric.pesquisar4(3L, UsuarioPessoa.class);
		
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			
			System.out.println("Usuário: " + fone.getUsuarioPessoa().getNome());
			System.out.println("Numero: " + fone.getNumero());
			System.out.println("Tipo: " + fone.getTipo());
			System.out.println("----------------------------------------------------");
		}
	}
	
	
	
	

}
