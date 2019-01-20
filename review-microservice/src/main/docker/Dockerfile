FROM java:8

MAINTAINER AshayKing

ADD review-microservice-0.0.1.jar reviewservice.jar

EXPOSE 8085

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","reviewservice.jar"]


