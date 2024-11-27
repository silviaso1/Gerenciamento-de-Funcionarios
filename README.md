Aqui está uma sugestão de **README.md** para o projeto de **Sistema de Gerenciamento de Funcionários**:

---

# Sistema de Gerenciamento de Funcionários

Este projeto implementa um sistema de gerenciamento de funcionários para a empresa TechCorp. O sistema permite o cadastro, consulta, atualização e exclusão de dados de funcionários. Ele foi desenvolvido seguindo o padrão arquitetural **MVC** (Model-View-Controller) e implementando práticas de **Clean Code**.

## Objetivo

Desenvolver um sistema de gerenciamento de funcionários que utilize conceitos de:
- **Herança**
- **Interfaces**
- **Abstração**
- **ArrayList** para armazenamento temporário de dados
- Persistência em arquivos para armazenamento permanente

## Funcionalidades

1. **Cadastro de Funcionários**:
   - Permite o cadastro de desenvolvedores, gerentes, treinadores e gerente desenvolvedores.
   - Cada tipo de funcionário possui atributos e métodos específicos baseados nas interfaces e na classe abstrata **Funcionario**.

2. **Armazenamento de Dados**:
   - Utiliza **ArrayList** para armazenar temporariamente os dados dos funcionários.
   - Persistência dos dados em um arquivo de texto, permitindo a recuperação dos funcionários cadastrados ao reiniciar o sistema.

3. **Interfaces e Herança**:
   - Interfaces para definir responsabilidades específicas de cada tipo de funcionário (Desenvolve, Gerencia, Treina).
   - Uma classe abstrata **Funcionario** define os atributos e métodos comuns a todos os funcionários.

4. **Padrão MVC**:
   - **Model**: Contém as classes de negócios (Funcionario, Desenvolvedor, Gerente, etc.).
   - **View**: Interface com o usuário, responsável pela exibição e captura de dados.
   - **Controller**: Gerencia a lógica de manipulação dos dados e interação entre Model e View.

5. **Persistência de Dados**:
   - Armazena dados dos funcionários em um arquivo de texto para garantir que as informações não sejam perdidas entre as execuções.

## Estrutura do Projeto

### Model
- **Funcionario** (classe abstrata): Define os atributos e métodos comuns a todos os funcionários.
- **Desenvolvedor**: Implementa **Funcionario** e a interface **Desenvolve**.
- **Gerente**: Implementa **Funcionario** e a interface **Gerencia**.
- **Treinador**: Implementa **Funcionario** e a interface **Treina**.
- **GerenteDesenvolvedor**: Implementa **Funcionario**, **Desenvolve** e **Gerencia**.

### View
- Classes responsáveis pela interação com o usuário, como capturar dados e exibir informações sobre os funcionários.

### Controller
- **FuncionarioController**: Responsável pela lógica de negócio para manipulação de dados dos funcionários (adicionar, listar, atualizar e excluir).

## Requisitos de Implementação

1. **Cadastro de Funcionários**: 
   - Permitir o cadastro de funcionários com dados específicos de cada tipo.
   - Persistir os dados no arquivo de texto ao adicionar, atualizar ou excluir um funcionário.

2. **Listagem de Funcionários**:
   - Exibir uma lista de todos os funcionários com seus detalhes.

3. **Atualização de Dados**:
   - Permitir a atualização do nome e salário de um funcionário existente.

4. **Exclusão de Funcionários**:
   - Permitir a remoção de um funcionário da lista, tanto no **ArrayList** quanto no arquivo de persistência.

5. **Recuperação de Dados do Arquivo**:
   - Ao iniciar o sistema, carregar os dados do arquivo e armazená-los no **ArrayList**.

## Estrutura dos Arquivos

O arquivo de persistência segue o formato:
```
[ID];[Tipo];[Nome];[Salário]
```
Exemplo de conteúdo:
```
1;Desenvolvedor;Alice;5000.00
2;Gerente;Bob;8000.00
3;Treinador;Carlos;6000.00
4;GerenteDesenvolvedor;Daniel;10000.00
```

## Como Usar

### Requisitos
- Java 8 ou superior

### Rodando o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/silviaso1/Gerenciamento-de-Funcionarios.git
   cd repositorio
   ```

2. Compile e execute o projeto:
   ```bash
   javac -d bin src/*.java
   java -cp bin Main
   ```

### Funções do Sistema
- O sistema irá exibir um menu no terminal com as opções para:
  - Cadastrar funcionários
  - Listar funcionários
  - Atualizar dados de um funcionário
  - Excluir um funcionário
  - Recuperar e exibir dados do arquivo

### Exemplo de Execução
1. O sistema irá solicitar informações para cadastrar um novo funcionário:
   ```
   Digite o nome do funcionário: Alice
   Digite o salário do funcionário: 5000.00
   Escolha o cargo (Desenvolvedor, Gerente, Treinador, GerenteDesenvolvedor): Desenvolvedor
   Funcionário Alice cadastrado com sucesso!
   ```

2. Para listar todos os funcionários cadastrados:
   ```
   Funcionários Cadastrados:
   1. Alice (Desenvolvedor) - Salário: 5000.00
   ```

3. Ao atualizar um funcionário:
   ```
   Digite o ID do funcionário a ser atualizado: 1
   Novo nome: Alice Silva
   Novo salário: 5500.00
   Funcionário atualizado com sucesso!
   ```

4. Para excluir um funcionário:
   ```
   Digite o ID do funcionário a ser excluído: 1
   Funcionário excluído com sucesso!
   ```

## Arquitetura MVC

- **Model**: Contém as classes e lógica de dados (Funcionario, Desenvolvedor, Gerente, etc.).
- **View**: Interage com o usuário para exibir informações e capturar entradas.
- **Controller**: Coordena a lógica de negócio entre o Model e a View.

## Princípios de Clean Code Aplicados

- **Nomes significativos**: Nomes de classes, métodos e variáveis são claros e refletem suas responsabilidades.
- **Métodos curtos**: Cada método possui uma única responsabilidade.
- **Tratamento de exceções**: Exceções são tratadas para garantir robustez.
- **Validação de entradas**: O sistema valida as entradas dos usuários para evitar erros.
