FROM openjdk:9
ADD target/kick-scooter-messaging.jar kick-scooter-messaging.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=suMZOIwlw0e5Pk -Vsumo.accesskey=24ruwMosQMpaQcD0fNVUmcrb6tEdSF7ASrRHIbrAUdBUjqw1BlqUI9EL6XFMUw5E -Vsources=/usr/local/SumoCollector -Vcollector.name=messaging
ENTRYPOINT ["java", "-jar", "kick-scooter-messaging.jar"]
