FROM adoptopenjdk/openjdk16
ENV DBHOST=localhost
ENV DBPORT=5432
ENV DBNAME=sterling
ENV DBUSER=postgres
ENV DBPASS=admin
ENV REDISHOST=localhost
COPY target/first-api-version-2-1.0.0.jar app.jar
EXPOSE 8100
ENTRYPOINT ["java","-jar","/app.jar"]


