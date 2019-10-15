package com.challenge.storeservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceApplicationTests {
	@Test
	public void contextLoads() {
		StoreServiceApplication.main(new String[]{"--spring.config.location=classpath:application-test.properties"});
	}
}
