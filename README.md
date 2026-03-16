# ERP-Estoque

Sistema de gerenciamento de estoque desenvolvido com foco em arquitetura escalável, transicionando de uma lógica **Vanilla** para uma **Arquitetura Orientada a Serviços (SOA)**.

> **Status do Projeto:** Em desenvolvimento (Fase: Protótipo Funcional em Java)

---

## Visão Geral
Este projeto nasceu da necessidade de aplicar conceitos de **SRE (Site Reliability Engineering)** e **Engenharia de Software** em um cenário real de logística. O sistema é poliglota, utilizando cada linguagem para o que ela possui de melhor: **Java** para a robustez do núcleo

## Arquitetura e Decisões Técnicas
O planejamento detalhado, incluindo a escolha de estruturas de dados como `HashMap` (para busca $O(1)$) e o roadmap de evolução para SQL e Rust, pode ser encontrado no nosso documento oficial de design:

>[**Acesse o Plan.md aqui**](./Plan.md)

## 🛠️ Stack Tecnológica (Fase Atual)
* **Linguagem Principal:** Java 25 (OpenJDK Temurin)
* **Estrutura de Dados:** HashMaps para alta performance de busca.
* **Ambiente:** Desenvolvimento via CLI (terminal puro) e VS Code para controle total de dependências.

## 🔧 Como Executar (Modo Manual)
Para manter o projeto sem excessos (No Bloat), a execução é feita via terminal:

1. **Compile o projeto:**
   ```powershell
   javac menu/Menu.java