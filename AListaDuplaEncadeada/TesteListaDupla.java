package AListaDuplaEncadeada;

public class TesteListaDupla {
    public static void main(String[] args) {

        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.lerArquivo();

        System.out.println(lista);
    }

}
 /*
    public void inserirComeco(T elemento){}

    public void inserirFinal(T elemento){}

    public void inserirOrdenado(T  elemento) {}

    public void removerComeco(){}

    public void removerFinal() {}

    public No<T> buscar(T elemento) {}

    public String buscarCount(T elemento) {}

    public void lerArquivo() {}*/