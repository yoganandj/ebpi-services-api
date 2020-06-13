FROM openjdk:11
EXPOSE 8085
ADD ebpi-api-exec/target/ebpi-service-api-exec-0.0.1-SNAPSHOT.jar ebpi-service-api-exec.jar
ENTRYPOINT ["java","-jar","/ebpi-service-api-exec.jar"]