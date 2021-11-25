package AListaDuplaEncadeada;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ListaDupla < T extends Comparable<T>>{
    No<T> primeiro;
    No<T> ultimo;
    int qtdElementos;

    public ListaDupla(){

    }

    public ListaDupla(No<T>primeiro, No<T> ultimo){
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    public void inserirComeco(T elemento){
        No<T> novoNo = new No<T>(elemento);
        if (this.primeiro == null) {
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
        if (this.primeiro == null) {
                this.primeiro = novoNo;
                this.ultimo = novoNo;
                this.qtdElementos++;
        }else{
            No aux = primeiro;
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

        if (this.primeiro == null) {
            inserirComeco(elemento);
        }else{
            while((aux.getProximo() != null) && (aux.getElemento().compareTo(novoNo.getElemento() )== -1))
            {aux = aux.getProximo();}

            if(aux == this.primeiro) {
                if(this.primeiro.getElemento().compareTo( novoNo.getElemento() ) == -1 ) {
                    this.primeiro.setProximo(novoNo);
                    novoNo.setAnterior(this.primeiro);
                }else {
                    novoNo.setProximo(this.primeiro);
                    this.primeiro.setAnterior(novoNo);
                    this.primeiro = novoNo;
                }
            }else {
                if(aux.getProximo() == null) {
                    novoNo.setAnterior(aux);
                    aux.setProximo(novoNo);
                }else {
                    novoNo.setProximo(aux);
                    novoNo.setAnterior(aux.getAnterior());
                    aux.getAnterior().setProximo(novoNo);
                    aux.setAnterior(novoNo);
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
        if (this.primeiro == null) {
            System.out.println("Lista vazia");
        } else {
            No aux = primeiro;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.getAnterior().setProximo(null);
            aux.setAnterior(null);
            this.qtdElementos--;
        }
    }

    public void removerElemento(T elemento) {
        No<T> aux = primeiro; //aux serve para percorrer a lista
        No<T> no = null; //no que será removido

        while((aux != null) && (aux.getElemento().compareTo(elemento) != 0))
        {   no = aux;
            aux = aux.getProximo(); }

        if(no == null) {
            System.out.println("Elemento não existe na lista");
        } else if(no == this.primeiro) {
            removerComeco();
        }else if(no == this.ultimo){
            removerFinal();
        } else{ //remover elemento do meio
            no.getAnterior().setProximo(no.getProximo());
            no.getProximo().setAnterior(no.getAnterior());
            no.setAnterior(null);
            no.setProximo(null);
            this.qtdElementos--;
        }

    }

    public No<T> buscar(T elemento) {
      /*
        if(no_atual== null)
            no_atual = primeiro;

        while((no_atual != null) && (no_atual.obterValor().compareTo( elemento )) != 0  )
        {
            if (no_atual.obterValor().compareTo(elemento)==-1){
                no_atual = no_atual.obterProximo();
            }
            else
                no_atual=no_atual.obterAnterior();


        }
        return no_atual;*/
        return primeiro;
    }

    public String buscarCount(T elemento) {
        /*
        int count = 0;

        if(no_atual== null)
            no_atual = primeiro;

        while((no_atual != null) && (no_atual.obterValor().compareTo( elemento )) != 0  )
        {
            count++;
            if (no_atual.obterValor().compareTo(elemento)==-1){
                no_atual = no_atual.obterProximo();
            }
            else
                no_atual=no_atual.obterAnterior();
        }


        return "Achou "+no_atual.obterValor()+" com "+count + " passos";

         */
        return "achou";
    }

    public String [] lerArquivo() {
        String dados = "";
        try {
            FileInputStream arquivo = new FileInputStream("C:\\Users\\Regiana\\OneDrive\\Documentos\\IFMA - S.I\\Disciplinas 2021.2\\Algoritmos e Estrutura de Dados II\\atividades\\dadosLista.txt"); //referência para o arquivo que deseja ler.
            InputStreamReader input = new InputStreamReader(arquivo); //FileReader - para iniciar um leitor de arquivo
            BufferedReader br = new BufferedReader(input); //BufferedReader - para poder ler linha por linha do arquivo e jogar em uma lista.

            String linha;

            do {
                linha = br.readLine();
                if (linha != null) {
                    String[] palavra = linha.split(";");
                    for (int i = 0; i < palavra.length; i++) {
                        inserirFinal((T) palavra[i]);
                        dados += palavra[i];
                    }
                }
            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
        return dados.split(";");
    }

    public String toString() {
        String s = "";
        No<T> auxiliar = primeiro;

        while(auxiliar != null)
        {
            s+= auxiliar.getElemento().toString() + " ; ";
            auxiliar = auxiliar.getProximo();
        }
        return s;
    }

}