# Hacka Cont

Projeto desenvolvido para facilitar o preenchimento de campo discriminação da emissão do imposto de renda.


## Link do projeto do front
-  [Stock - Repo do front](https://github.com/Diegobbrito/ContCodeHackaton-front)
-  [Deploy na Vercel](https://cont-code-hackaton-front.vercel.app/)
## Link da projeto no SonarCloud
-  [SonarCloud - Stock](https://sonarcloud.io/project/overview?id=Diegobbrito_contcode-hackaton)

## Como testar a aplicação com docker compose

Faça download do projeto, crie/atualize o arquivo de variaveis e na pasta principal rode o comando no terminal:

```bash
   docker-compose --env-file *.env up -d
```

## Como testar a aplicação com kubernetes

Faça download do projeto e na pasta principal rode os comandos no terminal para cada arquivo, seguindo a ordem:

Aplicação:
```bash
   kubectl apply -f ./kubernetes/app/<file>.yaml 
```
Arquivos para aplicação:

    1. service.yaml
    2. deployment.yaml


## Stack utilizada

**Banco de dados:** [Neon](https://neon.tech/) - [Postgres](https://www.postgresql.org/)

**Back-end:** [Java](https://www.oracle.com/br/java/), [Springboot](https://spring.io/projects/spring-boot)

**Docker**

**Github Actions**

**Deploy:** [OpenShift](https://www.redhat.com/pt-br/technologies/cloud-computing/openshift/container-platform)

## Autores

- [Diego B Brito](https://github.com/Diegobbrito)
- [Brian Zavala](https://github.com/brianzav)
- [Bruno Santos](https://github.com/BrunoSantos37)