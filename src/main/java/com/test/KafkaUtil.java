package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.alibaba.fastjson.JSONObject;
import com.zy.ssh.model.PrdCont;


public class KafkaUtil {
	private static Producer<String, String> producer;
	static {
		/*
		 * SystemConfigManager systemConfigManager = (SystemConfigManager)
		 * Constants.ctx .getBean("systemConfigManager"); String ip =
		 * systemConfigManager.getConfigValue("KAFKA_IP");
		 */
		//String ip = "10.200.66.83:9092,10.200.66.82:9092,10.200.66.81:9092";
		String ip = "127.0.0.1:9092";
		Properties props = new Properties();
		props.put("bootstrap.servers", ip);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
	}

	public static String send(String json, String key, String ip, String topic) {
		try {
			if (producer == null) {
				producer = getProducer();
			}
			producer.send(new ProducerRecord<String, String>(topic, key, json));
		} catch (Exception e) {
			e.printStackTrace();
		}

		producer.flush();
		// producer.close();
		return json;
	}

	public static Producer<String, String> getProducer() {
		/*
		 * SystemConfigManager systemConfigManager = (SystemConfigManager)
		 * Constants.ctx.getBean("systemConfigManager"); String ip =
		 * systemConfigManager.getConfigValue("KAFKA_IP");
		 */
		//String ip = "10.200.66.83:9092,10.200.66.82:9092,10.200.66.81:9092";
		String ip = "127.0.0.1:9092";
		Properties props = new Properties();
		props.put("bootstrap.servers", ip);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<String, String>(props);
		return producer;
	}

	public static void main(String[] args) throws InterruptedException {

		List<PrdCont> prdConts = new ArrayList<PrdCont>();
		PrdCont prdCont = new PrdCont();
		prdCont.setId(1);
		prdCont.setContentId("100001");

		PrdCont prdCont1 = new PrdCont();
		prdCont.setId(2);
		prdCont.setContentId("200002");

		prdConts.add(prdCont);
		prdConts.add(prdCont1);

		String s = JSONObject.toJSON(prdConts).toString();
		System.out.println(s);
		while (true) {
			send(s, "test", SourceConstants.kafka_ip,
					SourceConstants.kafka_topic);
			System.out.println("5次" + new Date());
		}

	}
}
