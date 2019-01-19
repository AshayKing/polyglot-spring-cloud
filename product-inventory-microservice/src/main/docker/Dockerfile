FROM java:8

MAINTAINER AshayKing

ADD product-inventory-microservice-0.0.1.jar productinventoryservice.jar

EXPOSE 8084

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","productinventoryservice.jar"]


