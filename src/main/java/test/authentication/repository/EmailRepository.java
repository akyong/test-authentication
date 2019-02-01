package test.authentication.repository;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import java.util.HashMap;

@KafkaClient
public interface EmailRepository {
    @Topic("sendSMSOTP")
    void sendSms(@KafkaKey String name, HashMap data);
}
