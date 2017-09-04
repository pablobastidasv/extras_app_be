FROM java:8u111-jre-alpine

COPY build/libs/extras-be.jar /usr

WORKDIR /usr

CMD ["java","-jar", "extras-be.jar"]