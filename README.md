# kotlin + SpringBoot 2.5.5 + Swagger + Docker Demo
kotlin 프로젝트 세팅 및 demo 를 위한 프로젝트

## Swagger 
* http://localhost:8080/swagger-ui/index.html

## Docker
* docker build : docker build -t demo/kotlin-demo:0.0.1 .
* docker-compose run : TAG=0.0.1 JAR_NAME=kotlin-demo JAR_VERSION=0.0.1-SNAPSHOT docker-compose up -d