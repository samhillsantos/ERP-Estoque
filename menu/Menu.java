package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import objetos.*;

public class Menu {
    public static Scanner input = new Scanner(System.in);
    public static final Map<String, Galpoes> MAPA_DE_GALPOES = new HashMap<>();

    public static void main(String[] args) {
        int escolha;

        do {
            System.out.print("Escolha uma opção do menu: ");
            escolha = input.nextInt();
            input.nextLine(); // Limpeza de buffer

            switch (escolha) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                /* GALPÕES */
                case 1:
                    criarGalpao();
                    break;
                case 2:
                    editarGalpao();
                    break;
                case 3:
                    listarGalpoes();
                    break;
                case 4:
                    removerGalpao();
                    break;
                /* PRODUTOS */
                case 5:
                    criarProduto();
                    break;
                case 6:
                    editarProduto();
                    break;
                case 7:
                    listarProduto();
                    break;
                case 8:
                    removerProduto();
                    break;
                /* SRE */
                case 9:
                    verificarCapacidadeDisponivel();
                    break;
                /* DEVOPS */
                case 10:
                    break;
                case 11:
                    gerarRelatorioStatus();
                    break;
                case 12:
                    simularFalhaCritica();
                    break;
                /* BACKEND */
                case 13:
                    listarGalpoesCriticos();
                    break;
                case 14:
                    buscarProdutoGlobal(input.nextInt());
                    input.nextLine(); // Limpeza de buffer
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    public static void criarGalpao() {
        Galpoes galpao = new Galpoes();
        System.out.print("Digite o ID do galpão: ");
        galpao.setId(input.nextInt());
        input.nextLine(); // Limpeza de buffer
        System.out.print("Digite o nome do galpão: ");
        galpao.setNome(input.nextLine());
        MAPA_DE_GALPOES.put(String.valueOf(galpao.getId()), galpao);
        System.out.println("Galpão criado com sucesso!");
    }

    public static void editarGalpao() {
        listarGalpoes();
        System.out.print("Digite o ID do galpão que deseja editar: ");
        int id = input.nextInt();
        input.nextLine(); // Limpeza de buffer
        Galpoes galpao = MAPA_DE_GALPOES.get(String.valueOf(id));
        if (galpao != null) {
            System.out.print("Digite o novo nome do galpão: ");
            galpao.setNome(input.nextLine());
            System.out.println("Galpão editado com sucesso!");
        } else {
            System.out.println("Galpão não encontrado!");
        }
    }

    public static void listarGalpoes() {
        System.out.println("\n+++ Galpões existentes +++");
        for (Galpoes galpao : MAPA_DE_GALPOES.values()) {
            System.out.println("ID: " + galpao.getId() + ", Nome: " + galpao.getNome());
        }
        System.out.println("++++++++++++++++++++++++++\n");
    }

    public static void removerGalpao() {
        System.out.print("Digite o ID do galpão que deseja remover: ");
        int id = input.nextInt();
        input.nextLine(); // Limpeza de buffer
        Galpoes galpao = MAPA_DE_GALPOES.get(String.valueOf(id));
        if (galpao != null) {
            MAPA_DE_GALPOES.remove(String.valueOf(id));
            System.out.println("Galpão removido com sucesso!");
        } else {
            System.out.println("Galpão não encontrado!");
        }
    }

    public static void criarProduto() {
        Galpoes galpao = getGalpaoPorId();
        if (galpao != null) {
            Produtos produto = new Produtos();
            System.out.print("Digite o ID do produto: ");
            produto.setID(input.nextInt());
            input.nextLine(); // Limpeza de buffer
            System.out.print("Digite o nome do produto: ");
            produto.setNome(input.nextLine());
            System.out.print("Digite o preço do produto: ");
            produto.setPreco(Double.parseDouble(input.nextLine()));
            galpao.adicionarProdutosNoEstoque(List.of(produto));
            System.out.println("Produto criado com sucesso!");
        }
    }

    public static void editarProduto() {
        Galpoes galpao = getGalpaoPorId();
        if (galpao != null) {
            System.out.print("Digite o ID do produto que deseja editar: ");
            int idProduto = input.nextInt();
            List<Produtos> estoque = galpao.getEstoque();
            boolean encontrado = false;

            for (int i = 0; i < estoque.size(); i++) {
                Produtos produto = estoque.get(i);
                if (produto.getID() == idProduto) {
                    System.out.print("Digite o novo nome do produto: ");
                    produto.setNome(input.nextLine());
                    System.out.print("Digite o novo preço do produto: ");
                    produto.setPreco(Double.parseDouble(input.nextLine()));
                    System.out.println("Produto editado com sucesso!");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado!");
            }
        } else {
            System.out.println("Galpão não encontrado!");
        }
    }

    public static void listarProduto() {
        Galpoes galpao = getGalpaoPorId();
        if (galpao != null) {
            List<Produtos> estoque = galpao.getEstoque();
            if (estoque.isEmpty()) {
                System.out.println("Não há produtos no galpão.");
            } else {
                for (Produtos produto : estoque) {
                    System.out.println("ID: " + produto.getID() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
                }
            }
        } else {
            System.out.println("Galpão não encontrado!");
        }
    }

    public static void removerProduto() {
        Galpoes galpao = getGalpaoPorId();
        if (galpao != null) {
            System.out.print("Digite o ID do produto que deseja remover: ");
            int idProduto = input.nextInt();
            List<Produtos> estoque = galpao.getEstoque();
            boolean encontrado = false;

            for (int i = 0; i < estoque.size(); i++) {
                Produtos produto = estoque.get(i);
                if (produto.getID() == idProduto) {
                    estoque.remove(i);
                    System.out.println("Produto removido com sucesso!");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado!");
            }
        } else {
            System.out.println("Galpão não encontrado!");
        }
    }

    public static Galpoes getGalpaoPorId() {
        System.out.print("Digite o ID do galpão: ");
        int id = input.nextInt();
        input.nextLine(); // Limpeza de buffer
        return MAPA_DE_GALPOES.get(String.valueOf(id));
    }

    public static void verificarCapacidadeDisponivel() {
        long totalSpace = Runtime.getRuntime().totalMemory();
        long freeSpace = Runtime.getRuntime().freeMemory();

        long usedSpace = totalSpace - freeSpace;
        double usagePercentage = (double) usedSpace / totalSpace * 100;

        System.out.println("Uso da memória: " + usagePercentage + "%");
    }

    public static void gerarRelatorioStatus() {
        String version = "1.0";
        int numberOfUsers = 50;

        System.out.println("Relatório de Status:");
        System.out.println("Versão do Software: " + version);
        System.out.println("Número de usuários online: " + numberOfUsers);
    }

    public static void simularFalhaCritica() {
        try {
            throw new Exception("Simulando falha crítica");
        } catch (Exception e) {
            System.out.println("Falha crítica simulada: " + e.getMessage());
        }
    }

    public static void listarGalpoesCriticos() {
        // Simulando galpões com capacidade insuficiente
        Galpoes galpao1 = new Galpoes();
        galpao1.setId(1);
        galpao1.setNome("Galpão 01");

        List<Produtos> estoqueGalpao1 = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Produtos produto = new Produtos();
            produto.setID(i);
            produto.setNome("Produto " + i);
            produto.setPreco(99.99);
            estoqueGalpao1.add(produto);
        }

        galpao1.adicionarProdutosNoEstoque(estoqueGalpao1);

        if (estoqueGalpao1.size() >= 500) {
            System.out.println("Galpão Crítico: " + galpao1.getNome());
        }
    }

    public static void buscarProdutoGlobal(int idProduto) {
        List<Galpoes> galpões = new ArrayList<>(MAPA_DE_GALPOES.values());

        for (Galpoes galpão : galpões) {
            if (galpão.getEstoque().stream().anyMatch(produto -> produto.getID() == idProduto)) {
                System.out.println("Produto encontrado em: " + galpão.getNome());
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}
