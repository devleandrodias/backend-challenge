# Desafio de recrutamento da Invillia
> Para o desafio foram desenvolvidos 3 módulos independentes para atender os princípios de arquitetura de microsserviços, sendo loja, pedido e pagamento, onde cada módulo contém o seu próprio Dockerfile o que permite o isolamento dos ambientes de cada projeto.

> Cada microserviço pode ser compilado e executado através do maven ou utilizando um container docker.

> Para atender os requisitos de clean code foi utilizado métodos para manter o código limpo, legivel e produtivo com a ajuda do plugin `Lombok`. 


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
> Para o módulo de loja foi criado uma estrutura que permite uma loja ter vários endereços.

* GET: 	`/challenge/v1/stores/{id}` - Buscar loja pelo Id
* GET: 	`/challenge/v1/stores` - Buscar todas as lojas
* GET: 	`/challenge/v1/stores/filter?{name}` - Buscar lojas por filtros
* POST: 	`/challenge/v1/stores` - Serviço responsável por cadastrar a loja
* PUT:	`/challenge/v1/stores/{id}` - Serviço responsável por atualizar a loja
* DELETE: `/challenge/v1/stores/{id}` - Serviço responsável por remover a loja pelo Id

##### MicroService API **Sale**:
> Para o módulo de venda foi criado uma estrutura que permite uma venda ter vários itens e endereços, onde os endereços são tipados em principal, entrega e cobrança.

* GET: 	`/challenge/v1/sales/{id}` - Buscar venda pelo Id
* GET: 	`/challenge/v1/sales` - Buscar todas as vendas
* GET: 	`/challenge/v1/sales/filter?{status}` - Buscar vendas por filtros
* POST: 	`/challenge/v1/sales` - Serviço responsável por cadastrar a venda
* PUT:	`/challenge/v1/sales/{id}` - Serviço responsável por atualizar a venda
* DELETE: `/challenge/v1/sales/{id}` - Serviço responsável por remover a venda pelo Id

##### MicroService API **Payment**:
> Para o módulo de pagamento foi criado uma estrutura que permite realizar o pagamento de uma venda.

* GET: 	`/challenge/v1/payments/{id}` - Buscar pagamento pelo Id
* GET: 	`/challenge/v1/payments` - Buscar todas os pagamentos
* POST: 	`/challenge/v1/payments` - Serviço responsável por cadastrar o pagamento
* PUT: 	`/challenge/v1/payments/{id}` - Serviço responsável por atualizar o pagamento
* DELETE: `/challenge/v1/payments/{id}` - Serviço responsável por remover a pagamento pelo Id


## Regras adicionadas
> Foi adicionado regras que entendi ser o melhor para o negócio baseado em meu conhecimento.

* Ao incluir um novo pedido com seus itens, o status será gravado como `OPEN` e sem data de confirmação.
* Ao incluir um novo pagamento, o status será gravado como `COMPLETE`.
* Ao atualizar o status do pedido para `CONCLUDED`, será gravado a data de confirmação.


## Tecnologias
> Para o desenvolvimento foram utilizadas as tecnologias:

 - Maven (Compilação)
 - Spring Boot (Framework)
 - Java (Linguagem de programação)
 - JPA (Persistência de dados)
 - JUnit (Teste unitários)
 - Mockito (Mock de testes)
 - MySQL (base de dados)
 - Flyway (Controle de versões da base de dados `db Migrations`)
 - Faker (Mock de dados)
 - Lombok (Desenvolvimento ágil)
 - Swagger (Documentação de api `http://localhost:8080/swagger-ui.html`)
 - Spring Security JWT (Gerar o token acessando https://jwt.io/ com o valor `stubJWT`)
 - Docker (Virtualização de contêiners)


## Variáveis de ​​ambiente
> Para a variável {MODULE-NAME} substituir para o nome do seu respectivo projeto, `sale`, `store`, `payment` para rodar a aplicação.

| variável | valor default |
| ------ | ------ |
| CHALLENGE_{MODULE-NAME}_ENV | development |
| CHALLENGE_{MODULE-NAME}_DATASOURCE_URL | jdbc:mysql://127.0.0.1:3306/challenge_{MODULE-NAME}?createDatabaseIfNotExist=true&useSSL=false&useTimezone=true&serverTimezone=UTC |
| CHALLENGE_{MODULE-NAME}_DATASOURCE_USERNAME | challenge |
| CHALLENGE_{MODULE-NAME}_DATASOURCE_PASSWORD |!@12QWqw  |
| CHALLENGE_{MODULE-NAME}_SECURITY_BASIC_NAME | challenge |
| CHALLENGE_{MODULE-NAME}_SECURITY_BASIC_PASSWORD | challenge |
| CHALLENGE_{MODULE-NAME}_SECURITY_JWT_SECRET_KEY | stubJWT |


## Extras adicionados
> Recursos adicionados ao projeto mas não solicitados no desafio.

 - Coleção do postman - No projeto tem o arquivo `_postman_collection/Challenge.postman_collection.json` que é a collection do postman utilizado nos testes do desenvolvimento.
 - Contratos - No projeto tem os arquivos de contratos no diretório `_contracts` definidos no desenvolviemtno do projeto.
 - db Migrations / Seeders - Ao iniciar a aplicação será criado toda a estrutura de tabelas e adicionado uma massa de dados básica de loja, pedido e pagamento para testes.
 - Circleci - Foi aplicado o circleci no projeto mas resolvi remover para dar mais atenção aos módulos e suas regras.
 - Testes unitários - Foi implementado uma cobertura de testes mínima para cada microserviço desenvolvido utilizando JUnit, Mockito e Faker.


## Não aplicados
 - AWS
 > Para Cloud AWS seria utilizado os serviços `EC2` para servers, `Security Groups` para controlar o tráfego de entrada e saída das aplicações, `Load Balancers` para distribuição de carga, `VPC` nuvem privada virtual em uma rede definida, `IAM` para definir privilégios de acesso aos grupos de usuários, `RDS Mysql` para a base de dados, `Route 53` para o gerencimento de DNS.
 
 > Seria feito um teste de comportamento dos microserviços utilizando `AWS Lambda` e `Serverless` analisando o tempo de resposta e o custo da aplicação por um determinado período.
 
 - Spring Cloud Netflix
 > Pensei em utilizar os serviços do Spring Cloud Netflix `Eureka`, `Zuul`, `Ribbon`, `Hystrix` mas por ter conhecimento somente teórico e não pratico acebei não aplicando ao projeto.
 
 - Criptografia de dados do cartão de crédito
 > Para segurança da informação seria importante a criptografia dos dados, para isto eu utilizaria o método de criptografia `Salt` onde é gerado uma criptografia dupla, sendo uma somente com os dados do cartão e depois novamente com o `Salt` (identificador unico de criptografia).
 
 - Método de reembolso
 > Não foi feito o método de reembolso mas seria desenvolvido uma rota na api de venda `/challenge/v1/sales/{id}/refound` seguindo as regras do desafio onde somente seria possível aplicar um reembolso caso o pedido estiver com o pagamento concluído e em até no máximo 10 dias da confirmação.
 