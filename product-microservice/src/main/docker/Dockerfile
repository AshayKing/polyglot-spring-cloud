FROM java:8

MAINTAINER AshayKing

ADD product-microservice-0.0.1.jar productmicroservice.jar

EXPOSE 8088

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productmicroservice.jar"]


