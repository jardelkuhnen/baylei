FROM openjdk:11

RUN mkdir /opt/baylei/baylei-eureka -p
COPY . /opt/baylei/baylei-eureka/

RUN chmod +x /opt/baylei/baylei-eureka/*.jar

WORKDIR /opt/baylei/baylei-eureka
ENTRYPOINT ["java", "-jar", "baylei-eureka.jar"]