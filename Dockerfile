FROM maven:3.8.3-openjdk-17
VOLUME /tmp
COPY ./*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8090