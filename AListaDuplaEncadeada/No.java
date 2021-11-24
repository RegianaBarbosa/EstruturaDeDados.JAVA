package AListaDuplaEncadeada;

public class No<T extends Comparable<T>> {

    private T elemento;
    private No proximo;
    private No anterior;

    public No(T valor) {
        this.elemento = valor;
        proximo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    //método toString para exibir o nó
    public String toString() {
        return this.elemento.toString();
    }

}