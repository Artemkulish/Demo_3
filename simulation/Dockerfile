FROM openjdk:11
ADD target/kick-scooter-simulation.jar kick-scooter-simulation.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=suCK0fySCEhWUi -Vsumo.accesskey=SGFgrlwR2gYKKO2nvGkjm5BUmWrJQHBapJ1eiaWrWgxRyFxVSgoDdpm7GOuo9fZ4 -Vsources=/usr/local/SumoCollector
ENTRYPOINT ["java", "-jar", "kick-scooter-simulation.jar"]
