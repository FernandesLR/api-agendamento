# api-agendamento

Uma solução de backend robusta e simples para gestão de horários, projetada para ser adaptável a qualquer nicho de negócio (Barbearias, Clínicas, Consultorias, etc.).

Agendamento Dinâmico: Cadastro de compromissos com data e hora customizáveis.

Busca Inteligente: Filtro de agendamentos por data específica via Query Params.

Gestão Completa (CRUD): Endpoints para criar, listar, atualizar e remover agendamentos.

Tecnologias Utilizadas
Java 21: Versão mais recente com foco em performance e novos recursos da linguagem.

Spring Boot 3.2.4: Framework base para criação de microserviços e APIs REST.

Spring Data JPA: Abstração para persistência de dados e consultas ao banco.

H2 Database: Banco de dados em memória para agilidade no desenvolvimento e testes.

Lombok: Automação de códigos repetitivos (Boilerplate) como Getters, Setters e Construtores.

Jackson: Serialização e desserialização eficiente de objetos Java para JSON.

Maven: Gerenciamento de dependências e build do projeto.

Como testar
Clone o repositório.

Certifique-se de ter o JDK 21 instalado.

Execute o comando ./mvnw spring-boot:run.

Utilize o Insomnia ou Postman para enviar requisições para http://localhost:8080/agendamentos.
