package Pilha;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
//Last In, Firt Out : LIFO
public class Pilha < T extends Comparable<T>>{

    private NoPilha<T> first;
    private int topo; //armazenar índice do topo da pilha

    public boolean pilhaVazia(){
        if(this.topo == -1 || this.first == null){
            return true;
        } //indica que a pilha é nula, pois o topo é -1 ou o primeiro nó não existe.
        return false;
    }

    public void push(T elemento){ //inserir na pilha
        NoPilha <T> no = new NoPilha();
        no = first;
        first = new NoPilha();
        this.first.setProximo(no);
        this.first.setElemento(elemento);
    }

    public T pop(){ //remover pilha
        if(pilhaVazia()){
            return null;
        }
        T elemento = this.first.getElemento();
        NoPilha <T> aux = new NoPilha<T>();
        aux = this.first.getProximo();
        this.first = aux;
        return elemento;
    }

    //MÉTODO para verificar qual o tamanho da pilha atual
    public int size(){
        if(this.pilhaVazia()){ // caso pilha vazia, retorna 0
            return 0;
        }
        return this.topo + 1;
    }

    public void imprimirPilha(){
        if(pilhaVazia()){
            System.out.println("Pilha vazia");
        }
        NoPilha no = new NoPilha();
        no = this.first;
        for(int i=0;i<=this.topo;i++){
            System.out.println(no.getElemento()+" ");
            no = no.getProximo();
        }
    }

    public String [] lerArquivo() {
        String dados = "";
        try {
            FileInputStream arquivo = new FileInputStream("C:\\Users\\Regiana\\IdeaProjects\\Luis_GitHub\\Entradas\\dadosLista.txt"); //referência para o arquivo que deseja ler.
            InputStreamReader input = new InputStreamReader(arquivo); //FileReader - para iniciar um leitor de arquivo
            BufferedReader br = new BufferedReader(input); //BufferedReader - para poder ler linha por linha do arquivo e jogar em uma lista.

            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    String[] palavra = linha.split(";");
                    for (int i = 0; i < palavra.length; i++) {
                        push((T) palavra[i]);
                        dados.concat(palavra[i]);
                    }
                }
            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
        return dados.split(" ");
    }

}
