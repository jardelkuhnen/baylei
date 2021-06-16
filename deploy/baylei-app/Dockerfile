FROM openjdk:11

RUN mkdir /opt/baylei/baylei-app -p
COPY . /opt/baylei/baylei-app/

RUN chmod +x /opt/baylei/baylei-app/*.jar

WORKDIR /opt/baylei/baylei-app
ENTRYPOINT ["java", "-jar", "baylei-app.jar"]