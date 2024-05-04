#FROM openjdk:17-jdk-slim

#COPY target/schoolmangagement-0.0.1-SNAPSHOT.war .

#EXPOSE 8080

#ENTRYPOINT ["java", "-jar", "schoolmangagement-0.0.1-SNAPSHOT.jar"]


From tomcat:8.0.51-jre8-alpine
CMD ["catalina.sh","run"]

