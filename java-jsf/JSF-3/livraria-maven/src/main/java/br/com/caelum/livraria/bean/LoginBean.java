package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class LoginBean implements Serializable {

	private Usuario usuario = new Usuario();
	@Inject
	UsuarioDao usuarioDao;
	@Inject
	FacesContext context;

	public Usuario getUsuario() {
		return usuario;
	}

	public RedirectView efetuaLogin() {
		boolean usuarioExiste = usuarioDao.existe(this.usuario);
		if(usuarioExiste) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			return new RedirectView("livro");
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado"));
		return new RedirectView("login");
	}

	public RedirectView deslogar() {
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return new RedirectView("login");
	}
}