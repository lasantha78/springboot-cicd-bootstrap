package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.controller.ApiController;

class ApiControllerTest extends Mockito {

	@Mock
	ApiController mockApi;

	@Test
	void testEcho() {
		ApiController api = new ApiController();
		assertEquals("hello", api.echo());
		mockApi = mock(ApiController.class);
		when(mockApi.echo()).thenReturn("blah blah");
		assertEquals("blah blah", mockApi.echo());
	}

}
