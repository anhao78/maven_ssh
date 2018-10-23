package com.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Test1 {
	private static Properties prop = new Properties();
	/*static {
		inintProp();
	}

	private static void inintProp() {
		try {
			prop.load(Test.class.getResourceAsStream("redis.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/

	public static void main(String[] args) {
		/*System.out.println(prop.getProperty("redisPort"));
		System.out.println(Test.class);*/
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream("src/main/resources/redis.properties"));
			prop.load(in);
			System.out.println(prop.getProperty("redisPort"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
