package manegedBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Model.UsuarioPessoa;
import dao.DaoGeneric;

@ManagedBean(name="usuarioPessoaManagedBean")
@ViewScoped
public class UsuarioPessoaManagedBean {
	
	private UsuarioPessoa usuarioPessoa = new UsuarioPessoa();
	private DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
	private List<UsuarioPessoa> listUsuarioPessoa = new ArrayList<UsuarioPessoa>();
	
	
	public UsuarioPessoa getUsuarioPessoa() {
		return usuarioPessoa;
	}
	
	public void setUsuarioPessoa(UsuarioPessoa usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}
	
	
	public String salvar() {
		
		daoGeneric.salvar(usuarioPessoa);
		
		return "";
	}
	
	public String novo() {
		
		usuarioPessoa = new UsuarioPessoa();
		
		return"";
	}
	
	public List<UsuarioPessoa> getListUsuarioPessoa() {
		
		listUsuarioPessoa = daoGeneric.listar(UsuarioPessoa.class);
		
		return listUsuarioPessoa;
	}
	

}
