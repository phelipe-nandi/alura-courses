package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Venda;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class VendaDao implements Serializable {

    @Inject
    EntityManager manager;
    private DAO<Venda> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Venda>(this.manager, Venda.class);
    }

    public List<Venda> getVendas() {
        return this.dao.listaTodos();
    }
}
