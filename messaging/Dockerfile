FROM openjdk:9
ADD target/kick-scooter-messaging.jar kick-scooter-messaging.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=-hidden_access_id- -Vsumo.accesskey=-hidden_access_key- -Vsources=/usr/local/SumoCollector -Vcollector.name=messaging
ENTRYPOINT ["java", "-jar", "kick-scooter-messaging.jar"]
