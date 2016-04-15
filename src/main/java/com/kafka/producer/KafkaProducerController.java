package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by ykurtulus on 4/15/16.
 */
@RestController
@RequestMapping("kafka-demo")
public class KafkaProducerController {

    private static final String TOPIC_NAME ="test";

    @Autowired
    private KafkaProducer<String,String> producer;

    @RequestMapping(value = "/{key}/{value}", method = RequestMethod.GET)
    public void produce(@Valid @PathVariable("key") String key,@Valid @PathVariable("value") String value){

        ProducerRecord record = new ProducerRecord(TOPIC_NAME,key, value);
        producer.send(record);
    }
}
