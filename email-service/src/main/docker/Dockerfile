FROM java:8

MAINTAINER AshayKing

ADD email-service-0.0.1.jar emailservice.jar

EXPOSE 8082

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","emailservice.jar"]


