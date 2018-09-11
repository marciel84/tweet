FROM openjdk:8-jdk-stretch
MAINTAINER Marciel Alves
WORKDIR /usr/share/twitter/
ADD target/twitter-pool-0.0.1-SNAPSHOT.jar /usr/share/twitter/twitter-pool.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/twitter/twitter-pool.jar"]
