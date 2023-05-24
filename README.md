# VallyTool
## Aplicação criada para informatizar o processo de pré conselho de classe na ETEJK.

- [Introdução](https://github.com/toxxxey/VallyTool#introdu%C3%A7%C3%A3o)  
- [Projeto](https://github.com/toxxxey/VallyTool#projeto) 
- [Desenvolvedores](https://github.com/toxxxey/VallyTool/edit/aula/README.md#desenvolvedores-do-projeto)
- [Documentação Técnica](https://github.com/toxxxey/VallyTool/blob/aula/DOCUMENTACAO.md)

![image](https://user-images.githubusercontent.com/86073233/209441740-f81a5a97-20b5-4df0-ab34-901999a35538.png)
![image](https://user-images.githubusercontent.com/86073233/209441756-1e8afa11-087c-4e49-8c7e-738c07d24dda.png)
![image](https://user-images.githubusercontent.com/86073233/209441772-d5acc514-d45e-4f47-87fc-7369b60fdb32.png)
![image](https://user-images.githubusercontent.com/86073233/209441787-b12f2f66-196e-483b-9b14-30ccc1e789f2.png)
![image](https://user-images.githubusercontent.com/86073233/209441794-ef1942f5-5105-4daf-9536-68358c44643d.png)
![image](https://user-images.githubusercontent.com/86073233/209441824-720524b3-f241-430c-a147-bb8e73ba7009.png)

# Introdução

### Como projeto final da FAETEC o nosso grupo ficou encarregado de criar uma solução para os problemas que existiam no SOP (Serviço de Educação Pedagógica) em relação à realização do pré-conselho de classe.
### O sistema que os funcionários usavam era de planilhas no Excel para informar a situação das turmas, que chegava por meio das imensas papeladas que vinham dos professores.
### A solução foi criar uma plataforma web para resolver tanto a situação dos professores, que precisavam escrever muito, tanto a situação dos funcionários que precisavam transcrever à mão as informações que vinham dos professores para uma planilha do Excel.

# Projeto

## A base da aplicação é a existência de 2 tipos de usuários.

> ## ***Professor***
> - Encarregado de avaliar as disciplinas das turmas do qual foi relacionado.

> ## ***Admin (SOP)***
> - Encarregado de relacionar professores nas suas respectivas turmas e disciplinas.
> - Fechar o trimestre.
> - Remover usuários ou Adicionar novos, podendo ser do tipo Admin ou Professor.
> > - A senha de todo usuário novo adicionado é o seu CPF
> - Adicionar turmas e disciplinas.
> - Gerenciar os resultados trimestrais.
> - Emitir PDF com todos os resultados do trimestre.

# Como rodar
- # Rodar utilizando o código fonte
### Se tratando de um projeto Spring Boot, você pode baixar o projeto, baixar as dependências usando o ***Maven*** e rodar o arquivo ***VallyToolApplication.java*** como um arquivo java normal.

### Crie o arquivo application.yml em src/main/resources e insira mudando as suas informações.

```yml
spring:
  datasource:
    url: jdbc:mysql://${DB_HOST}:${DB_PORT}/${DB_NAME}?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa: 
    hibernate:
      ddl-auto: update
    properties: 
      hibernate:
        show_sql: true
        format_sql:  true
        dialect: org.hibernate.dialect.MySQL8Dialect	
    database-platform: org.hibernate.dialect.MySQL8Dialect

  mail:
    host: smtp.gmail.com
    port: 587
    username: ${MAIL_USERNAME}
    password: ${MAIL_PASSWORD}
    properties:
      mail:
      smpt:
      auth: true
      starttls:
      enable: true

server: 
  error:
    whitelabel: 
      enabled: false
    path: /error
```
### Adicione essas variáveis no environment colocando as suas informações
```
DB_HOST=localhost
DB_PORT=3306
DB_NAME=vallytooldb
DB_USERNAME=
DB_PASSWORD=
MAIL_USERNAME=
MAIL_PASSWORD=
```

## OBS: A senha do email é senha de app, deve ser gerada.


# Para rodar usando a build pronta siga estes passos:

- ### Tenha certeza de que baixou todas as dependências necessárias:
- #### MySQL
- #### Java 17

### Agora que você já tem baixado as dependências e o arquivo jar
- ### Abra o prompt de comando na localização do arquivo jar.
- ### Digite:  
```bash
java -jar VallyTool.jar --spring.datasource.password=suasenhadomysql --spring.datasource.username=seuusuariomysql
```
## Se tiver aparecido uma mensagem parecida com essa:
![Sucesso](https://user-images.githubusercontent.com/86073233/209565313-b617c8a2-8f8f-4449-ace6-68f46016ad14.png)

### Vá no seu MySQL Workbench e rode o seguinte script:
```sql
use vallytooldb;
INSERT INTO `trimestre_atual` VALUES(default, true, 'PRIMEIRO');
INSERT INTO `usuario` VALUES (1,'00000000000', 'host@gmail.com','Host', '$2a$10$JRZrRRmKHjAfVrWQsyP43u3aBgy7oStir847QlIe6YRkWYr1R2CxG');
INSERT INTO `roles` VALUES (1,'ROLE_PROFESSOR'),(2,'ROLE_SOP');
INSERT INTO `usuario_roles` VALUES (1,2);
```

## Agora o projeto está rodando na sua máquina.
## Para acessar: http://localhost:8080/login
## O usuário padrão é 000.000.000-00 e sua senha é admin.

# Desenvolvedores do Projeto

> ## [João Victor](https://github.com/joaorfragoso)
> - Design e Front-End da Aplicação


> ## [Marcos Guimarães](https://github.com/toxxxey)
> - Documentação, Modelagem de Dados, Arquitetura e Back-End da Aplicação  


# [Documentação Técnica](https://github.com/toxxxey/VallyTool/blob/aula/DOCUMENTACAO.md)
