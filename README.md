# ERP-Estoque

**Descrição:** Um sistema de gerenciamento de estoque desenvolvido em Java. O projeto foca na manipulação manual de estruturas e fundamentos de programação (sem uso de frameworks), alinhado com um perfil de aprendizado voltado para Backend de baixo nível e SRE.

## Stack e Motivação
| Componente | Tecnologia | Propósito |
| :--- | :--- | :--- |
| Core (Lógica e CLI) | Java Puro | Robustez e aprendizado focado na base da linguagem, sem abstrações excessivas. |

---

## Roadmap (Evolução do Projeto)

Este projeto foi desenhado com uma visão clara de evolução de arquitetura e aprendizado:

- **Fase 1 (Atual) - Prova de Conceito (PoC) em CLI:** Construção da lógica de negócio e manipulação de estruturas em Java puro, garantindo total entendimento dos fundamentos de orientação a objetos sem depender de "caixas pretas" de frameworks.
- **Fase 2 (Futuro) - Migração para Spring Boot:** Evolução da aplicação para uma API RESTful completa. Tendo a base estrutural muito sólida criada na Fase 1, a adoção do Spring servirá estritamente como ferramenta de produtividade e escalabilidade para o ecossistema web.

---

## Estrutura do Projeto
```text
ERP-Estoque/
├── menu/
│   └── Menu.java
└── objetos/
    ├── Galpoes.java
    └── Produtos.java
```

## Classes e Implementação Técnica

### 1. `menu/Menu.java`
**Descrição:** É a classe principal (`main`) do sistema. É responsável por exibir a interface de linha de comando (CLI) para o usuário, mapeando as opções e orquestrando as chamadas aos objetos de negócio.
- Instancia e manipula `Galpoes` e `Produtos`.

### 2. `objetos/Galpoes.java`
**Descrição:** Modela a entidade de um galpão. 
- Contém atributos como ID e Nome.
- Gerencia internamente o estoque de produtos associados a esse galpão específico.

### 3. `objetos/Produtos.java`
**Descrição:** Modela a entidade de um produto.
- Mantém dados como ID, Nome e Preço.
- Realiza validações de negócio, como a verificação contra preços negativos.

---

## Compilação e Execução

Como o projeto foca nos fundamentos, a compilação e execução são feitas diretamente via terminal, sem a necessidade de ferramentas de build como Maven ou Gradle.

**1. Compilar os arquivos:**
```bash
javac objetos/Galpoes.java objetos/Produtos.java menu/Menu.java
```

**2. Executar o sistema:**
```bash
java menu.Menu
```