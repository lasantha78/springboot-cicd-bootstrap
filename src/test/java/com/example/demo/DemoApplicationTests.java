package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.ApiController;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	ApiController contoller;

	@Test
	void contextLoads() {
		Assertions.assertThat(contoller).isNotNull();
	}

}
