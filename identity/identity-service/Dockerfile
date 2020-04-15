FROM openjdk:9
ADD target/identity-service-0.0.1.jar /identity-service-0.0.1.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=suJA8fyoJWCGjE -Vsumo.accesskey=vd96dLlE4b2f5WE3ot2lKbSubNjczOUefqYm2g6o1Tfv7NeBUQFX01Lw0iHSb6ii -Vsources=/usr/local/SumoCollector -Vcollector.name=identity
ENTRYPOINT ["java", "-jar", "identity-service-0.0.1.jar"]
