FROM adoptopenjdk/openjdk11:alpine

ENV JAR_NAME kotlin-demo
ENV JAR_VERSION 0.0.1-SNAPSHOT

# Timezone 보정
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime
RUN echo "Asia/Seoul" > /etc/timezone

ARG JAR_FILE=./build/libs/${JAR_NAME}-${JAR_VERSION}.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]