package br.com.caelum.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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
import java.util.Locale;

@Named
@ViewScoped
public class LivroBean implements Serializable {

	private Livro livro = new Livro();
	private Integer autorId;
	private Integer livroId;
	private List<Livro> livros;
	@Inject
	LivroDao livroDao;
	@Inject
	AutorDao autorDao;

	public Livro getLivro() {
		return livro;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Livro> getLivros() {
		if(this.livros == null) {
			this.livros = livroDao.listaTodos();
		}
		return livros;
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public List<Autor> getAutores() {
		return autorDao.listaTodos();
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public void gravarAutor() {
		Autor autor = autorDao.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	@Transacional
	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um autor!"));
			return;
		}

		if(livro.getId() == null) {
			livroDao.adiciona(this.livro);
			this.livros = livroDao.listaTodos();
		} else {
			livroDao.atualiza(this.livro);
			this.livros = livroDao.listaTodos();
		}

		this.livro = new Livro();
	}

	public void carregar(Livro livro) {
		this.livro = livro;
	}

	@Transacional
	public void remover(Livro livro) {
		System.out.println("Removendo livro");
		livroDao.remove(livro);
		this.livros = livroDao.listaTodos();
	}

	public void removerAutorDoLivro(Autor autor) {
		this.livro.removeAutor(autor);
	}

	public RedirectView formAutor(){
		return new RedirectView("autor");
	}

	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("ISBN deveria começar com 1"));
		}
	}

	public void carregaLivroPelaId() {
		this.livro = livroDao.buscaPorId(livroId);
	}

	public boolean precoEhMenor(Object valorColuna, Object filtroDigitado, Locale locale) {

		String textoDigitado = (filtroDigitado == null) ? null : filtroDigitado.toString().trim();

		if (textoDigitado == null || textoDigitado.equals("")) {
			return true;
		}

		if (valorColuna == null) {
			return false;
		}

		try {
			Double precoDigitado = Double.valueOf(textoDigitado);
			Double precoColuna = (Double) valorColuna;
			return precoColuna.compareTo(precoDigitado) < 0;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
