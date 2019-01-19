FROM java:8

MAINTAINER AshayKing

ADD gateway-microservice-0.0.1.jar gatewayservice.jar

EXPOSE 8086

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","gatewayservice.jar"]


