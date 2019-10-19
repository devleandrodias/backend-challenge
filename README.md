# Desafio de recrutamento da Invillia
Para o desafio foram desenvolvidos 3 módulos independentes para atender os princípios de arquitetura de microsserviços, sendo loja, pedido e pagamento, onde cada módulo contém o seu próprio Dockerfile o que permite o isolando dos ambientes de cada projeto.
Cada microserviço pode ser compilado e executado através do maven ou utilizando um container docker.

## Requisitos
```sh
Java 11
Maven
Docker
Docker Compose
Plugin Lombok
MySql (local ou docker)
```

## RESTfull service(s) URIs:
> Para cada módulo foi disponibilizado todas as rotas de um CRUD.
##### MicroService API **Store**:
* GET: 	`/challenge/v1/stores/{id}` - Buscar loja pelo Id
* GET: 	`/challenge/v1/stores` - Buscar todas as lojas
* GET: 	`/challenge/v1/stores/filter?{name}` - Buscar loja por filtros
* POST: 	`/challenge/v1/stores` - Serviço responsável por cadastrar a loja
* PUT:	`/challenge/v1/stores/{id}` - Serviço responsável por atualizar a loja
* DELETE: `/challenge/v1/stores/{id}` - Serviço responsável por remover a loja pelo Id

##### MicroService API **Sale**:
* GET: 	`/challenge/v1/sales/{id}` - Buscar venda pelo Id
* GET: 	`/challenge/v1/sales` - Buscar todas as vendas
* POST: 	`/challenge/v1/sales` - Serviço responsável por cadastrar a venda
* PUT:	`/challenge/v1/sales/{id}` - Serviço responsável por atualizar a venda
* DELETE: `/challenge/v1/sales/{id}` - Serviço responsável por remover a venda pelo Id

##### MicroService API **Payment**:
* GET: 	`/challenge/v1/payments/{id}` - Buscar pagamento pelo Id
* GET: 	`/challenge/v1/payments` - Buscar todas os pagamentos
* POST: 	`/challenge/v1/payments` - Serviço responsável por cadastrar o pagamento
* PUT: 	`/challenge/v1/payments/{id}` - Serviço responsável por atualizar o pagamento
* DELETE: `/challenge/v1/payments/{id}` - Serviço responsável por remover a pagamento pelo Id

## Tecnologias
> Para o desenvolvimento foram utilizadas as tecnologias abaixo:
 - Maven (Compilação)
 - Docker (Virtualização de contêiners)
 - Java (Linguagem de programação)
 - JUnit (Teste unitários)
 - Mockito (Mock de testes)
 - Spring Boot (Framework)
 - Mysql (base de dados)
 - Flyway (Controle de versões da base de dados `db Migrations`)
 - Swagger (Documentação de api `http://localhost:8080/swagger-ui.html`)
 - Spring Security JWT (Gerar o token acessar https://jwt.io/ e utilizar o valor da variável de ambinete JWT_SECRET_KEY)

## Extras
> Recursos adicionados ao projeto mas não solicitados no desafio.
 - Coleção do postman - Anexo ao projeto tem o arquivo `_postman_collection/Challenge.postman_collection.json` que é a collection do postman utilizado nos testes do desenvolvimento.
 - Contratos - Anexo ao projeto tem os arquivos de contratos no diretório `_contracts` definidos no desenvolviemtno do projeto.
 - db Migrations / Seeders - Ao iniciar a aplicação será criado toda a estrutura de tabelas e adicionado uma massa de dados básica de loja, pedido e pagamento.
 - Circleci - Foi aplicado o circleci no projeto mas resolvi remover para dar mais atenção aos módulos.
 - Testes unitários - Foi implementado uma cobertura de testes mínima para cada microserviço desenvolvido utilizando JUnit, Mockito e Faker.

## Variáveis de ​​ambiente


## Não aplicados
 - AWS
 - Spring Cloud Netflix

## Regras
Ao incluir um novo pedido com seus itens, o status será gravado como pendente e sem data de confirmação.
Ao incluir um novo pagamento, o status será gravado como #########.
Ao atualizar o status do pedido para #########, será gravado a data de confirmação.

