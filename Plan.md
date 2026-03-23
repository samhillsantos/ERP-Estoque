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
  * **(Galpoes.java):** Modelagem de Entidade (POO) para estruturação de dados e formatação de saída para auditoria via `toString`.
  * **(POO):** Implementação de Construtores e `toString` para garantir a integridade dos dados e facilitar o rastreio (Log) no terminal.
