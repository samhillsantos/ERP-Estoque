package menu;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import produtos.Galpoes;

public class Menu{
    public static Scanner input = new Scanner (System.in);
    public static HashMap<Integer, Galpoes> galpoesMap = new HashMap<>();
    public static int idContador = 1;

    public static void main(String[] args){
        System.out.println("Bem-vindo ao sistema de Estoque: ");
	exibirMenu();
    }

    public static void exibirMenu(){
	    criarGalpoes();
    }

    public static void criarGalpoes(){

        while(true){

            System.out.println("\n--- Criação de galpões ---");
            System.out.println("Nome (ou 'sair'):");
            String nome = input.nextLine();

            if(nome.equalsIgnoreCase("sair")){
                System.out.println("Operação cancelada...");
                return;
            }

	    Galpoes novoGalpao = new Galpoes(idContador, nome);

	    galpoesMap.put(idContador, novoGalpao);

	    System.out.println("Sucesso: " + novoGalpao);
	    idContador++;
        }

    }
}
