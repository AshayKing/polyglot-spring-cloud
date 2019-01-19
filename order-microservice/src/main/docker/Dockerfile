FROM java:8

MAINTAINER AshayKing

ADD order-microservice-0.0.1.jar orderservice.jar

EXPOSE 8083

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","orderservice.jar"]


