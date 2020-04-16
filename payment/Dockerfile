FROM openjdk:11
ADD target/kick-scooter-payment.jar kick-scooter-payment.jar
RUN wget "https://collectors.sumologic.com/rest/download/linux/64" -O SumoCollector.sh && chmod +x SumoCollector.sh
RUN ./SumoCollector.sh -q -Vsumo.accessid=-hidden_access_id- -Vsumo.accesskey=-hidden_access_key- -Vsources=/usr/local/SumoCollector -Vcollector.name=payment
ENTRYPOINT ["java","-jar","kick-scooter-payment.jar"]
