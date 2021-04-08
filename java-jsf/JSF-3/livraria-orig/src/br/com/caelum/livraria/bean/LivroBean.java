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
import java.util.Locale;

@ViewScoped
@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();
	private Integer autorId;
	private Integer livroId;
	private List<Livro> livros;

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
		DAO<Livro> livroDAO = new DAO<>(Livro.class);
		if(this.livros == null) {
			this.livros = livroDAO.listaTodos();
		}
		return livros;
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
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
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um autor!"));
			return;
		}

		DAO<Livro> livroDAO = new DAO<>(Livro.class);
		if(livro.getId() == null) {
			livroDAO.adiciona(this.livro);
			this.livros = livroDAO.listaTodos();
		} else {
			livroDAO.atualiza(this.livro);
			this.livros = livroDAO.listaTodos();
		}

		this.livro = new Livro();
	}

	public void carregar(Livro livro) {
		this.livro = livro;
	}

	public void remover(Livro livro) {
		System.out.println("Removendo livro");
		DAO<Livro> livroDAO = new DAO<>(Livro.class);
		livroDAO.remove(livro);
		this.livros = livroDAO.listaTodos();
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
		this.livro = new DAO<Livro>(Livro.class).buscaPorId(livroId);
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
