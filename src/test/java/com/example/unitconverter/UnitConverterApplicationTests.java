package com.example.unitconverter;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.unitconverter.controller.TemperatureController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnitConverterApplicationTests {

	@Autowired
	private TemperatureController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
