FROM openjdk:11

RUN mkdir /opt/baylei/baylei-config-server -p
COPY . /opt/baylei/baylei-config-server/

RUN chmod +x /opt/baylei/baylei-config-server/*.jar

WORKDIR /opt/baylei/baylei-config-server
ENTRYPOINT ["java", "-jar", "baylei-config-server.jar"]