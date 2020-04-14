FROM openjdk:11
ADD target/kick-scooter-vehicle.jar /kick-scooter-vehicle.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=suMZOIwlw0e5Pk -Vsumo.accesskey=24ruwMosQMpaQcD0fNVUmcrb6tEdSF7ASrRHIbrAUdBUjqw1BlqUI9EL6XFMUw5E -Vsources=/usr/local/SumoCollector -Vcollector.name=vehicle
ENTRYPOINT ["java", "-jar", "kick-scooter-vehicle.jar"]
