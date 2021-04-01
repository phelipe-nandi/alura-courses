package br.com.caelum.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.util.RedirectView;

import java.util.List;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	private Integer autorId;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}

	public Autor getAutor() {
		return autor;
	}

	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (autor.getId() == null) {

			new DAO<Autor>(Autor.class).adiciona(this.autor);
		} else {
			new DAO<Autor>(Autor.class).atualiza(this.autor);
		}

		this.autor = new Autor();

		return new RedirectView("livro");
	}

	public void carregar(Autor autor) {
		this.autor = autor;
	}

	public void remover(Autor autor) {
		if(!verificaSeExisteAlgumLivroComEsteAutor(autor)) {
			new DAO<Autor>(Autor.class).remove(autor);
		}
	}

	private boolean verificaSeExisteAlgumLivroComEsteAutor(Autor autor) {
		List<Livro> livros = new DAO<Livro>(Livro.class).listaTodos();
		for (Livro livro: livros) {
			if(livro.getAutores().contains(autor)) {
				System.out.println("Existe um livro com esse Autor");
				return true;
			}
		}
		return false;
	}
}
