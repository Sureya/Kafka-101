import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
import java.util.Random;

public class KafkaProducer {

    public static void main(String[] args){

        long events = 5;
        Random rnd = new Random();

        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //props.put("partitioner.class", "example.producer.SimplePartitioner");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        Producer<String, String> producer = new Producer<String, String>(config);


        String ip = " Message is : 2182";
        String msg ="localhost:"+ ip;
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("test", ip, msg);
        producer.send(data);

        producer.close();
        System.out.println("Executed Sucessfully.");
    }
}
