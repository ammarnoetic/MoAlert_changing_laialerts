FROM openjdk:11

ENV TZ=Asia/Karachi
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /opt/app

COPY target/molaerts-0.0.1.jar .

EXPOSE 7000

ENTRYPOINT ["java" , "-jar" , "molaerts-0.0.1.jar"]