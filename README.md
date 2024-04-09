# ESTÓRIAS DO USUÁRIO

- EU1 - Arquitetura, entidades do projeto e testes unitários
    - EU1A1 - Arquitetura inicial
    - EU1A2 - Criar os inputs(rotas)
    - EU1A3 - Criar testes unitários
    - EU1A4 - Criar camada de segurança
    - EU1A5 - Criar um handler para Excpetion e definir a mensagem de erro padrão
- EU2 - 

# EXECUTAR O PROJETO
## Build

> mvn clean install

## Run Sonar:
  - subir um sonar pelo docker utilizar o comando:
> docker run -d --name sonarqube \
-p 9000:9000 \
-v sonarqube_data:/opt/sonarqube/data \
-v sonarqube_extensions:/opt/sonarqube/extensions \
-v sonarqube_logs:/opt/sonarqube/logs \
sonarqube:9.9.4-community

  - for build sonar, execute comand:

> mvn clean verify sonar:sonar \
-Dsonar.projectKey=cars-api \
-Dsonar.host.url=http://localhost:9000 \
-Dsonar.login=sqp_c4df0e7d63ea8149e55dd0e83dbe36281be78714

 
