package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.dao.VendaDao;
import br.com.caelum.livraria.modelo.Venda;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class VendaBean implements Serializable {

    @Inject
    VendaDao vendaDao;

    public BarChartModel getVendasModel() {
        BarChartModel model = new BarChartModel();
        model.setAnimate(true);

        ChartSeries vendaSerie = new ChartSeries();
        vendaSerie.setLabel("Vendas 2016");

        List<Venda> vendas = vendaDao.getVendas();

        for (Venda venda : vendas) {
            vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
        }

        model.addSeries(vendaSerie);

        return model;
    }
}