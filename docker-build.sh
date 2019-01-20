#!/bin/bash

MAVEN_BINARY=/home/ashay/Software/STS/apache-maven-3.6.0/bin/mvn

cd customer-microservice && $MAVEN_BINARY clean install docker:build && cd ../
cd email-service && $MAVEN_BINARY clean install docker:build && cd ../
cd gateway-microservice && $MAVEN_BINARY clean install docker:build && cd ../
cd order-microservice && $MAVEN_BINARY clean install docker:build && cd ../
cd product-inventory-microservice && $MAVEN_BINARY clean install docker:build && cd ../
cd product-microservice && $MAVEN_BINARY clean install docker:build && cd ../
cd review-microservice && $MAVEN_BINARY clean install docker:build && cd ../

