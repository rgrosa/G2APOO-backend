# approval-workflow-v2-backend

## Executando o aplicativo localmente

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método `main` na classe` br/com/crearesistemas/frota/Application.java` do seu IDE.

- Faça o download do zip ou clone o repositório Git.
- Descompacte o arquivo zip (se você tiver baixado)
- Abra o Prompt de Comando e navegue com comando (cd) para a pasta que contém pom.xml
- Abra o Eclipse 
   - Arquivo -> Importar -> Projeto Maven existente -> Navegue até a pasta em que você descompactou o zip
   - Selecione o projeto
- Escolha o arquivo do aplicativo de inicialização do Spring (pesquise @SpringBootApplication)
- Clique com o botão direito do mouse no arquivo e execute como aplicativo Java
- Ou ainda pelo IntelliJ: Abra o intelliJ 
    - File -> Open -> escolha o diretório do clone do projeto -> e clique em OK.
    - Agurdar o carregamento do projeto
    - Escolha o arquivo do aplicativo de inicialização do Spring (pesquise @SpringBootApplication)
    - Clique com o botão direito do mouse no arquivo e execute como aplicativo Java
 
`` shell
mvn spring-boot:run
``