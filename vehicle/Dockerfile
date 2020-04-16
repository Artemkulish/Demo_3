FROM openjdk:11
ADD target/kick-scooter-vehicle.jar /kick-scooter-vehicle.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=-hidden_access_id- -Vsumo.accesskey=-hidden_access_key- -Vsources=/usr/local/SumoCollector -Vcollector.name=vehicle
ENTRYPOINT ["java", "-jar", "kick-scooter-vehicle.jar"]
