package com.example

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(DemoApplication::class))
class DemoApplicationTests {

	// This test with Kotlin lambdas (final by default) produces some error in the logs
	@Test
	fun contextLoads() {
	}

}
