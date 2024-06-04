# Sistema de Empréstimo de Ferramentas

---

- 📌 Feito em Java-MVC com Maven

---

Este projeto é um software para gerenciar o empréstimo de ferramentas, desenvolvido para atender a uma necessidade fictícia do cotidiano. O software foi solicitado pelo tio-avô do desenvolvedor para ser utilizado localmente em seu computador. A aplicação permite o cadastro de ferramentas e amigos, registro de empréstimos e devoluções, além de gerar relatórios detalhados sobre os empréstimos e ferramentas.

### Funcionalidades Principais

1. **Cadastro de Ferramentas**:
- Nome da ferramenta
- Marca
- Custo de aquisição
1. **Cadastro de Amigos**:
- Nome do amigo
- Telefone
1. **Gerenciamento de Amigos e Ferramentas**:
- ID, Nome E Telefone (Amigo)
- ID, Nome, Marca e Custo de Aquisição (Ferramenta)
1. **Registro de Empréstimo e Devolução:**
- Registrar novo empréstimo
- Registrar data de devolução prevista
- Registrar devolução
1. **Relatórios**:
- Relatório de ferramentas cadastradas e total de custo de aquisição
- Relatório de empréstimos ativos
- Relatório de todos os empréstimos realizados
- Identificação do amigo que fez mais empréstimos
- Identificação de amigos que nunca devolveram ferramentas
- Alerta de empréstimos não devolvidos ao registrar um novo empréstimo

### Requisitos Funcionais

**RF01** - O sistema deve permitir o cadastro de novas ferramentas com os seguintes dados: nome, marca e custo de aquisição.

**RF02** - O sistema deve permitir o cadastro de novos amigos com os seguintes dados: nome e telefone.

**RF03** - O sistema deve permitir que o usuário registre os empréstimos de ferramentas para os amigos, informando a ferramenta, o amigo, a data do empréstimo e a data prevista de devolução.

**RF04** – O sistema deve permitir que o usuário registre a devolução dos empréstimos, informando o amigo, a ferramenta e a data devolução.

**RF05** - O sistema deve gerar um relatório de ferramentas com o custo total das ferramentas cadastradas.

**RF05.01** - Deve ser possível gerar um relatório de empréstimos ativos, mostrando as ferramentas emprestadas e seus respectivos amigos.

**RF05.02** - Deve ser possível gerar um relatório de todos os empréstimos realizados, mostrando as ferramentas emprestadas, amigos envolvidos e datas.

**RF06** - O sistema deve notificar se um amigo ainda tem ferramentas não devolvidas ao realizar um novo empréstimo para esse amigo.

**RF07** - O sistema deve integrar-se com a Google Agenda para registrar convites de amigos para eventos, enviando lembretes por e-mail.

**RF08** - O sistema deve permitir a edição e exclusão de ferramentas e amigos cadastrados.

### Requisitos Não Funcionais

**RNF01** - O sistema deve rodar localmente no computador do usuário.

**RNF02** - O sistema deve garantir a segurança dos dados dos usuários, como informações de ferramentas e amigos.

**RNF03** - O sistema deve ser fácil de usar, com uma interface intuitiva para o usuário.

**RNF04** - O sistema deve ter um bom desempenho, mesmo com um grande volume de dados.

**RNF05** - O sistema deve ser compatível com diferentes sistemas operacionais e navegadores.

### Estrutura do Projeto

- **src**: Código fonte do projeto
- **lib**: Bibliotecas externas utilizadas
- **docs**: Documentação do projeto
- README: Este arquivo
- **LICENSE**: https://github.com/uRodolfo/ProjetoA3SQL/blob/Master/LICENSE

### Instruções de Instalação e Uso

1. Clone o repositório para o seu computador:
    
    ```java
    git clone <https://github.com/uRodolfo/ProjetoA3SQL.git>
    ```
    
2. Abra o projeto no NetBeans.
3. Compile e execute o projeto a partir do NetBeans.
4. Siga as instruções na interface do usuário para cadastrar ferramentas e amigos, registrar empréstimos e gerar relatórios.

### Configurações do Banco de Dados

- Usuário: root
- Senha: root

### Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](https://github.com/uRodolfo/ProjetoA3SQL/blob/Master/LICENSE) para mais detalhes.

---

Este software foi desenvolvido como parte da UC de Programação de Soluções Computacionais, atendendo à necessidade fictícia de gerenciamento de empréstimos de ferramentas em um contexto familiar.
