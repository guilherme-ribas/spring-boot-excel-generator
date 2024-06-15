# Usar uma imagem base do OpenJDK que suporte a arquitetura ARM
# FROM arm64v8/openjdk:17-ea-16-jdk
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho no contêiner
WORKDIR /app

# Copiar o arquivo JAR da aplicação para o contêiner
COPY target/excel-generator-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Expor a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
