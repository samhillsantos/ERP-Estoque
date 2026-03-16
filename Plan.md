# Projeto Estoque

<!-- Decições -->
## Stack 
| Componente | Linguagem | Propósito SRE |
| :--- | :--- | :--- |
| **Menu / Objetos** | Java | Robustez do projeto e facilidade de linguagem. |
| **Scripting** | Python | Gerador de SKUs, Logarinas e Pulmão. |
| **Memória** | SQL | Guarda e manda os dados entre as linguagens. |
| **Performance** | C | Rapidez e fluidez em baixo nível (Algoritmos rápidos). |
| **Segurança** | Rust | Opsec através da segurança de compilação. |
| **Networking** | Go | Implementação para a internet. |

<!-- Pastas e oque esta acontecendo e quais stacks estao sendo utilizadas -->
## Implementação Técnica
<!-- Stack -->
* **Java**
    <!-- Pastas -->
  * **(Menu.java):** Utiliza `HashMap` (Busca $O(1)$) para reduzir overhead de CPU.
  * **(Galpoes.java):** Implementar um objeto utilizando `class` para fixar os dados no sistema.