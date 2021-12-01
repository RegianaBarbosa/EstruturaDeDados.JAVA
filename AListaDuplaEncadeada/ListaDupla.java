package AListaDuplaEncadeada;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ListaDupla < T extends Comparable<T>>{
    No<T> primeiro;
    No<T> ultimo;
    int qtdElementos;

    public ListaDupla(){//Criar lista vazia
        this.primeiro = null;
        this.ultimo = primeiro;
        this.qtdElementos = 0;
    }


    public void inserirComeco(T elemento){
        No<T> novoNo = new No<T>(elemento);
        if (this.listaVazia()) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
            this.qtdElementos++;
        }
        novoNo.setProximo(primeiro);
        this.primeiro.setAnterior(novoNo);
        this.primeiro = novoNo;
        this.qtdElementos++;
    }

    public void inserirFinal(T elemento){
        No<T> novoNo = new No<T>(elemento);
          if(this.listaVazia()) {
                inserirComeco(elemento);
          }else{
            No<T> aux = primeiro;
            while( aux.getProximo() != null){ aux = aux.getProximo();}
            novoNo.setAnterior(aux);
            aux.setProximo(novoNo);
            this.qtdElementos++;
        }

    }

    public void inserirOrdenado(T  elemento) {
        No<T> novoNo = new No<T>(elemento);
        No<T> aux = primeiro;
        No<T> aux2 = null;

        if (this.listaVazia()) {
            this.primeiro = novoNo;
        }else{
            while(aux.getProximo() != null){
                if(aux.getElemento().compareTo(novoNo.getElemento())==-1){
                    aux2 = aux;
                    aux = aux.getProximo();
                }
            }

            if(aux2 == this.primeiro) {
                if(this.primeiro.getElemento()!=novoNo.getElemento()) {
                    this.primeiro.setProximo(novoNo);
                    novoNo.setAnterior(this.primeiro);
                }else {
                    novoNo.setProximo(this.primeiro);
                    this.primeiro.setAnterior(novoNo);
                    this.primeiro = novoNo;
                }
            }else {
                if(aux2.getProximo() == null) {
                    novoNo.setAnterior(aux2);
                    aux2.setProximo(novoNo);
                }else {
                    novoNo.setProximo(aux2);
                    novoNo.setAnterior(aux2.getAnterior());
                    aux2.getAnterior().setProximo(novoNo);
                    aux2.setAnterior(novoNo);
                }
            }
        }
    }

    public void removerComeco(){
        if(this.primeiro == null || this.qtdElementos == 0){
            System.out.println("Lista vazia");
        }
        No<T> aux = this.primeiro;
        this.primeiro = this.primeiro.getProximo();
        aux.setProximo(null);
        this.qtdElementos--;
    }

    public void removerFinal() {
        if (this.ultimo != null) {
            No<T> aux = ultimo;
            this.ultimo = this.ultimo.getAnterior();
            if(this.ultimo!=null){
                this.ultimo.setProximo(null);
            } else{
                primeiro = new No<>(null);
            }
            this.qtdElementos--;
        }
    }

    public void removerElemento(int posicao) {
        if(posicao == 0){
            removerComeco();
        } else if(posicao == this.qtdElementos - 1 ){
            removerFinal();
        } else{
            No<T> noRemover = primeiro;

            for(int i=0; i<posicao; i++){
                noRemover = noRemover.getProximo();
            }
            if(noRemover.getAnterior() != null && noRemover.getProximo() != null){
                noRemover.getAnterior().setProximo(noRemover.getProximo());
                noRemover.getProximo().setAnterior(noRemover.getAnterior());
            }
            this.qtdElementos--;
        }
    }

    public No<T> buscar(T elemento) {
        if(this.listaVazia() || elemento == null) return null;
        No<T> auxBusca = this.primeiro;
        while(auxBusca.getProximo() != null){
            if(auxBusca.getProximo().getElemento().equals(elemento)) return (No<T>) auxBusca.getProximo().getElemento();
            auxBusca = auxBusca.getProximo();
        }
        return null;
    }

    public boolean listaVazia(){
        return (this.primeiro == null && this.ultimo == null);
    }

    public String [] lerArquivo() {
        String dados = "";
        try {
            FileInputStream arquivo = new FileInputStream("C:\\Users\\Regiana\\IdeaProjects\\Luis_GitHub\\Entradas\\dadosLista.txt"); //referência para o arquivo que deseja ler.
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    String[] palavra = linha.split(";");
                    for (int i = 0; i < palavra.length; i++) {
                        inserirFinal((T) palavra[i]);
                        dados.concat(palavra[i]);
                    }
                }
            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
        return dados.split(" ");
    }

    public String toString() {
        String infoLista;
        No<T> atual = primeiro;

        infoLista="Tamanho: "+this.qtdElementos+"\n";
        while(atual != null){
            infoLista+= atual.getElemento()+"; ";
            atual = atual.getProximo();
        }
        return infoLista;
    }

}