package br.com.caelum.livraria.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.tx.Transacional;
import br.com.caelum.livraria.util.RedirectView;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class AutorBean implements Serializable {

	private Autor autor = new Autor();
	private Integer autorId;
	@Inject
	AutorDao autorDao;
	@Inject
	LivroDao livroDao;

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Autor getAutor() {
		return autor;
	}

	public List<Autor> getAutores(){
		return this.autorDao.listaTodos();
	}

	public void carregarAutorPelaId() {
		this.autor = this.autorDao.buscaPorId(autorId);
	}

	@Transacional
	public RedirectView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		if (autor.getId() == null) {

			this.autorDao.adiciona(this.autor);
		} else {
			this.autorDao.atualiza(this.autor);
		}

		this.autor = new Autor();

		return new RedirectView("livro");
	}

	public void carregar(Autor autor) {
		this.autor = autor;
	}

	@Transacional
	public void remover(Autor autor) {
		if(!verificaSeExisteAlgumLivroComEsteAutor(autor)) {
			this.autorDao.remove(autor);
		}
	}

	private boolean verificaSeExisteAlgumLivroComEsteAutor(Autor autor) {
		List<Livro> livros = livroDao.listaTodos();
		for (Livro livro: livros) {
			if(livro.getAutores().contains(autor)) {
				System.out.println("Existe um livro com esse Autor");
				return true;
			}
		}
		return false;
	}
}
