package com.techprimers.test.testcontrollerexample;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest {
	
	
	private MockMvc mockMvc;
	
	@Mock
	private HelloService helloService;
	
	@InjectMocks
	private HelloResource helloResource;
	
	

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.standaloneSetup(helloResource).build();
	}
	
	@Test
	public void TestHelloworld() throws Exception {
		
		Mockito.when(helloService.getData()).thenReturn("hello");
		
	mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("hello"));
	
	Mockito.verify(helloService).getData();
		
	}
	
	@Test
	public void testPost() throws Exception {
		
		String json="";
		JSONObject object=new JSONObject();
		object.put("title", "Greetings");
		object.put("value", "Hello world");
		json=object.toString();
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/hello/post")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Greetings")))
		.andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello world")));
		
	}
	
	/*@Test
	public void getJson() throws Exception 
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello/json")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Greetings")))
		.andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello world")))
		.andExpect(MockMvcResultMatchers.jsonPath("$.*",Matchers.hasSize(1)));
		//.andExcept(MockMvcResultMatchers.jsonPath("$.value",Matchers.is("Hello World")));
	//	.andExpect(MockMvcResultMatchers.status().isOk())
	//	)
	} */
	
	
	
	

}
