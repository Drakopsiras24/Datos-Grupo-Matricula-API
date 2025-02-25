FROM frolvlad/alpine-java:jdk8-slim
RUN apk add -U tzdata
RUN cp /usr/share/zoneinfo/America/Santiago /etc/localtime
RUN date
RUN mkdir -p /api-sidep-grupo-matricula/lib/
RUN mkdir -p /api-sidep-grupo-matricula/config/
RUN mkdir -p /api-sidep-grupo-matricula/logs/
ADD bootstrap.yml /api-sidep-grupo-matricula/config
ADD logback.xml /api-sidep-grupo-matricula/config
ADD application-api-sidep-grupo-matricula-messages.properties /api-sidep-grupo-matricula/config
WORKDIR /api-sidep-grupo-matricula
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","lib/app.jar"]
EXPOSE 9308
HEALTHCHECK --interval=2s --retries=15 --timeout=2s --start-period=8s CMD curl --connect-timeout 1 -f http://127.0.0.1:9308/api-sidep-grupo-matricula
ADD api-sidep-grupo-matricula.jar /api-sidep-grupo-matricula/lib/app.jar
