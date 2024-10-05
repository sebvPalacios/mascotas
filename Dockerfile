# Dockerfile 
FROM openjdk:21-ea-24-oracle

WORKDIR /app

# asegurarnos que el nombre del jar coincida
COPY target/mascotas-0.0.1-SNAPSHOT.jar app.jar

# Ubicacion del wallet descomprimido
COPY Wallet_MsMascotas /app/oracle_wallet/
EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]