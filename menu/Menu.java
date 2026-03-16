package menu;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Menu{
    public static Scanner input = new Scanner (System.in);
    public static HashMap<Integer, String> galpoes = new HashMap<>();
    
    public static void main(String[] args){
        System.out.println("Bem-vindo ao sistema de Estoque: ");
        criarGalpoes();
    }
    
    public static void criarGalpoes(){
        int idContador = 1; 
        String nomeGalpao;

        while(true){

            System.out.println("digite (sair) caso queira cancelar esta operação...");
            System.out.println("--- Criação de galpões ---");
            System.out.println("Nome:");
            nomeGalpao = input.nextLine();

            if(nomeGalpao.equalsIgnoreCase("sair")){
                System.out.println("Operação cancelada...");
                return;
            }

            galpoes.put(idContador, nomeGalpao);
            idContador++;

            System.out.println("\nGalpões criados:");
                for (Map.Entry<Integer, String> entry : galpoes.entrySet()) {
                    System.out.println("ID: " + entry.getKey() + ", Galpão: " + entry.getValue());
                }

        }
    }
}