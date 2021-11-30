package Pilha;

public class TestePilha {
    public static void main(String args[]) {
        Pilha p = new Pilha();

        p.push(3);
        System.out.println("Topo");
        p.imprimirPilha(); // 3 -> topo
        p.push(2);
        System.out.println("1 + Topo");
        p.imprimirPilha(); // 2 -> 3
        p.push(1); //
        System.out.println("2 + 1 + Topo");
        p.imprimirPilha(); // 1 -> 2 -> 3 (topo)
        p.pop(); //
        int tamanho = p.size();
        System.out.println("\nPilha final:");
        for(int i=0;i<tamanho;i++){
            p.imprimirPilha();
        }
    }

}
