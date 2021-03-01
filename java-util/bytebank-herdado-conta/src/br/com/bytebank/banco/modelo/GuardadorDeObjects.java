package br.com.bytebank.banco.modelo;

public class GuardadorDeObjects {

    private Object[] referencias;
    private int posicaoLivre;

    public GuardadorDeObjects() {
        this.referencias = new Object[10];
        this.posicaoLivre = 0;
    }

    public void adiciona(Object ref) {
        this.referencias[this.posicaoLivre] = ref;
        this.posicaoLivre++;
    }

    public int getQuantidadeDeElementos() {
        return this.posicaoLivre;
    }

    public Object getReferencia(int i) {
        return this.referencias[i];
    }
}
