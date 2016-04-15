package com.kafka.consumer;


import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.message.MessageAndMetadata;

public class KafkaConsumer implements Runnable {


    private KafkaStream<byte[], byte[]> stream;
    private String topicName;
    private int threadNumber;


    public KafkaConsumer(KafkaStream<byte[], byte[]> stream, String topicName, int threadNumber) {

        this.stream = stream;
        this.topicName = topicName;
        this.threadNumber = threadNumber;

    }

    @Override
    public void run() {

        ConsumerIterator<byte[], byte[]> it = stream.iterator();

        while (it.hasNext()) {

            String message="";
            String key="";

            try {
                MessageAndMetadata<byte[], byte[]> messageAndMetadata = it.next();
                byte[] messageInBytes = messageAndMetadata.message();
                byte[] keyInBytes = messageAndMetadata.key();
                if (messageInBytes != null) {
                    message = new String(messageInBytes);
                }
                if (keyInBytes !=null) {
                    key = new String(keyInBytes);
                }
                System.out.println("Message consumed by consumer message=" + message + " key="+key);


            } catch (Exception e) {
             e.printStackTrace();
            }

        }

    }

}
