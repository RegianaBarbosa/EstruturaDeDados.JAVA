package Pilha;

public class NoPilha<T extends Comparable<T>> {

    private T elemento;
    private NoPilha proximo;

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoPilha getProximo() {
        return proximo;
    }

    public void setProximo(NoPilha proximo) {
        this.proximo = proximo;
    }
}
