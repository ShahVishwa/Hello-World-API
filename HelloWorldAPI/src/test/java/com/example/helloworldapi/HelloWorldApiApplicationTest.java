package com.example.helloworldapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.helloworldapi.controller.HelloWorldController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class)
@WebAppConfiguration
public class HelloWorldApiApplicationTest {

	private static final String REQUEST_URL ="/";
	private static final String POST_MESSAGE = "{'message':'Hello! World'}";
	private static final String MEDIA_TYPE_TEXT = "text/plain;charset=UTF-8";
	private static final String MEDIA_TYPE_JSON = "application/json;charset=UTF-8";
	private static final String HEADER_CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_HTML = "text/html";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetRequest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_URL))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf(MEDIA_TYPE_TEXT)));
	}

	@Test
	public void testGetRequestWithAcceptHeaders() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(REQUEST_URL).header(HEADER_CONTENT_TYPE, CONTENT_TYPE_HTML))
				.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content()
						.contentType(MediaType.valueOf(MEDIA_TYPE_JSON)));
	}

	@Test
	public void testPostRequestWithAcceptHeaders() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post(REQUEST_URL).accept(MediaType.APPLICATION_JSON).content(POST_MESSAGE)
				.contentType(MediaType.TEXT_HTML)).andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content()
						.contentType(MediaType.valueOf(MEDIA_TYPE_JSON)));
	}

}
