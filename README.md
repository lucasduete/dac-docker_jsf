# Atividade Avaliativa - Docker e Java Server Faces
### Equipe ###
Alexa Lins e Lucas Duete

### Requisitos ###
* Java
* Maven
* Docker (Métodos 1 e 2)
* Postgres (Método 3)
* Glassfish ou Payara (Método 3)

### Implantação ###

Há três formas de fazer a implantação desta aplicação

1) Utilizando Docker e Scripts:<br/>
  Existem dois scripts responsáveis por fazer a implantação automatizada desta aplicação:<br/><br/>
  Utilize `sh run.sh` para fazer o deploy <b>(Necessário Docker)</b><br/>
  Utilize `sh stop.sh` para derrubar a aplicação.<br/><br/>
2) Deploy Manualmente Utilizando Docker:<br/>
  Execute os seguintes comandos para <b>Deploy: (Necessário Docker)</b><br/>
  `cd banco`<br/>
  `docker build -t dac/banco .`<br/>
  `cd ..`<br/>
  `mvn clean package`<br/>
  `docker build -t dac/app .`<br/><br/>
  `docker run -p 5432:5432 --name banco -d dac/banco`<br/>
  `docker run -p 8080:8080 --link banco:banco --name app -d dac/app`<br/><br/>
  Execute os seguintes comandos para <b>Derrubar a aplicação:</b><br/>
  `docker kill banco`<br/>
  `docker stop banco`<br/>
  `docker rm banco`<br/>
  `docker rmi dac/banco`<br/><br/>
  `docker kill app`<br/>
  `docker stop app`<br/>
  `docker rm app`<br/><br/>
3) Deploy na máquina local:<br/>
  3.1) Utilize o comando `mvn clean package` para gerar o arquivo de implantação.<br/>
  3.2) Faça a implantação do arquivo `target/atividade.war` no seu servidor de aplicação <i>(Preferível Glassfish ou Payara)</i><br/>
  3.3) Crie um Banco de dados chamado `dac-docker_jsf`<br/>
  3.3) Cerfitique-se de Existir um usuario `postgres` com senha `postgres`<br/>
  3.4) Utilize o aquivo banco/create.sql` para criação das tabelas necessárias no banco de dados.<br/>
  
