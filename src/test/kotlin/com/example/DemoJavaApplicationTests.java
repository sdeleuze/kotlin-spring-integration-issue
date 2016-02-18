package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoJavaApplication.class)
public class DemoJavaApplicationTests {

	// This test with Java final lambda implementation works as expected
	@Test
	public void contextLoads() {
	}

}
