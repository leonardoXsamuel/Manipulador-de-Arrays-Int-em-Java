package secao14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//versão com escolha de operação feita pelo usuário

public class escolhaManipulacaoArrays {

    public static void main(String[] args) {
        
        Scanner lerEnt = new Scanner(System.in);

        //escolha do tamanho da lista
        System.out.print("Digite o tamanho do seu array: ");
        int tamanhoArray = lerEnt.nextInt();

        int[] listaInteiros = new int[tamanhoArray];
        System.out.println("Preencha esse Array com "+ tamanhoArray +" inteiros e realizaremos alguns processos nele");
        for (int i = 0; i < tamanhoArray; i++) {
            listaInteiros[i] = lerEnt.nextInt();
        }
        
        int opcao;

        do {
            System.out.println("\nDigite a operação que deseja realizar com o array inserido: ");
            System.out.println("(1) retornar o último valor inserido: ");
            System.out.println("(2) retornar o primeiro valor inserido: ");
            System.out.println("(3) retornar o primeiro maior inserido: ");
            System.out.println("(4) retornar o primeiro menor inserido: ");
            System.out.println("(5) retornar a soma de todos os valores inseridos: ");
            System.out.println("(6) retornar o array invertido: ");
            System.out.println("(7) retornar os valores em ordem crescente: ");
            System.out.println("(8) retornar os valores em ordem decrescente: ");
            System.out.println("(9) retornar os impares: ");
            System.out.println("(10) retornar os pares: ");
            System.out.println("(11) retornar todo o array multiplicado por um valor escolhido pelo usuário: ");
            System.out.println("(12) mudar o array: ");
            System.out.println("(13) SAIR: ");
            
            opcao = lerEnt.nextInt();

            if (opcao == 1) {
                System.out.println(ultimoCaractere(listaInteiros));
                break;
            } else if (opcao==2){
                System.out.println(primeiroCaractere(listaInteiros));
                break;
            } else if (opcao==3) {
                System.out.println(maiorValor(listaInteiros));
                break;
            } else if (opcao==4) {
                System.out.println(menorValor(listaInteiros));
                break;
            } else if (opcao==5){
                System.out.println(somaValores(listaInteiros));
                break;
            } else if (opcao==6) {
                inverteArray(listaInteiros);
                break;
            } else if (opcao==7) {
                ordemCresc(listaInteiros);
                break;
            } else if (opcao==8){
                ordemDecresc(listaInteiros);
                break;
            } else if (opcao==9) {
                removePares(listaInteiros);
                break;
            } else if (opcao==10){
                removeImpares(listaInteiros);
                break;
            } else if (opcao==11){
                multiplicaArray(listaInteiros);
                break;
            } else if (opcao == 12) {

                //redefinição do array
                System.out.print("Digite o tamanho do seu array: ");
                tamanhoArray = lerEnt.nextInt();
                listaInteiros = new int[tamanhoArray];
                System.out.println("Preencha esse Array com "+ tamanhoArray +" inteiros e realizaremos alguns processos nele");
                for (int i = 0; i < tamanhoArray; i++) {
                    listaInteiros[i] = lerEnt.nextInt();
                }
            } else if (opcao == 13){
                System.out.println("PROGRAMA ENCERRADO!");
            } else {
                System.out.println("Opção inválida.");
            }

        } while (opcao != 13);

        lerEnt.close();
    }

    //função para retornar o último caractere(1)
    public static int ultimoCaractere (int[] lista){
        return lista[lista.length-1];
    }

    //função para retornar o primeiro caractere(2)
    public static int primeiroCaractere (int[] lista){
        return(lista[0]);
    }

    //função que retorna o maior valor(3)
    public static int maiorValor(int[] lista){
        int maiorVal = lista[0];
        for (int j = 0; j < lista.length; j++) {
            if (maiorVal < lista[j]) {
                maiorVal = lista[j];
            }
        }
        return maiorVal;
    }

    //função que retorna o menor valor(4)
    public static int menorValor(int[] lista){
        int menorVal = lista[0];
        for (int j = 0; j < lista.length; j++) {
            if (menorVal > lista[j]) {
                menorVal = lista[j];
            }
        }
        return menorVal;
    }

    //função que soma todos os valores da lista(5)
    public static int somaValores (int[] listaInteiros) {
        int soma = 0;
        for (int i : listaInteiros) {
            soma += i;
        }
        return soma;
    }
    
    //função que inverte o array(6)
    public static void inverteArray(int[] lista){
        for (int i = 0; i < lista.length/2; i++) {
            int temp = lista[i];
            lista[i] = lista[lista.length-1-i];
            lista[lista.length-1-i] = temp;            
        }
        System.out.println("lista invertida: " + Arrays.toString(lista));
    }

    //função que coloca os valores em ordem crescente(7)
    public static void ordemCresc(int[] lista){
        int[] copia = Arrays.copyOf(lista, lista.length);
        Arrays.sort(copia);
        System.out.println("Ordem crescente: " + Arrays.toString(copia));
    }

    //função que coloca os valores em ordem decrescente(8)
    public static void ordemDecresc(int[] lista){
        int[] copia = Arrays.copyOf(lista, lista.length);
        Arrays.sort(copia);
        for (int i = 0; i < copia.length / 2; i++) {
            int temp = copia[i];
            copia[i] = copia[copia.length - 1 - i];
            copia[copia.length - 1 - i] = temp;
        }
        System.out.println("Ordem decrescente: " + Arrays.toString(copia));
    }
    
    //função que remove os pares(9)
    public static void removePares(int[] lista){       
        ArrayList<Integer> novaLista = new ArrayList<>();
        for (int vals : lista) {
            if (vals % 2 != 0) {
                novaLista.add(vals);
            }
        }
        System.out.println("Ímpares: " + novaLista);
    }

    //função que remove os impares(10)
    public static void removeImpares(int[] lista){
        ArrayList<Integer> novaLista = new ArrayList<>();
        for (int vals : lista) {
            if (vals % 2 == 0) {
                novaLista.add(vals);
            }
        }
        System.out.println("Pares: " + novaLista);
    }
    
    //função que multiplica todo o array por um número escolhido pelo usuário(11)
    public static void multiplicaArray(int[] lista){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o número que deseja multiplicar o array todo: ");
        int multiplicador = scan.nextInt();

        int[] resultado = new int[lista.length];
        for (int i = 0; i < lista.length; i++) {
            resultado[i] = lista[i] * multiplicador;
            scan.close();
        }
        System.out.println("Resultado da multiplicação: " + Arrays.toString(resultado));
    }

    //outro modo de função que soma todos os valores do array fornecido
    /*
    public static int somaArray(int[] lista){
        int soma = Arrays.stream(lista).sum();
        return soma;
    }; */
}
