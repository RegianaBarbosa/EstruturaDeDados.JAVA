package AListaDuplaEncadeada;

public class TesteListaDupla {
    public static void main(String[] args) {
        ListaDupla<Integer> l = new ListaDupla<Integer>();

        l.lerArquivo(); // insere os dados: 1 2 3 4 5
        System.out.println(l); //imprime a lista
        l.removerComeco(); // remove o elemento 1 | lista atual: 2 3 4 5
        System.out.println(l); //imprime a lista
        l.removerElemento(2);  // remove o elemento na posição 3 | lista atual: 2 3 4 5
        System.out.println(l); //imprime a lista
        l.removerFinal(); // 2 3
        System.out.println(l); //imprime a lista
    }

}
