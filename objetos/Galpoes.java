package objetos;

import java.util.ArrayList;
import java.util.List;

public class Galpoes {
    private int id;
    private String nome;
    private List<Produtos> estoque;

    public Galpoes() {
        this.estoque = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produtos> getEstoque() {
        return estoque;
    }

    // Método para adicionar produtos no estoque
    public void adicionarProdutosNoEstoque(List<Produtos> produtos) {
        for (Produtos produto : produtos) {
            this.estoque.add(produto);
        }
    }
}
