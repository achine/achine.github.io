package demo;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoRestApplication.class)
@WebAppConfiguration
public class SecondDemoControllerTests {

	@Autowired
	private WebApplicationContext ctxWeb;

	private MockMvc mockMvc;

	@Before
	public void setup() {	
		mockMvc = webAppContextSetup(ctxWeb).build();
	}

	@Test
	public void testTheme() throws Exception {
		MockHttpServletRequestBuilder getRestUrl = get("/theme") ;//.accept(MediaType.parseMediaType("application/json;charset=UTF-8"));
		ResultActions resAct = mockMvc.perform(getRestUrl);
		resAct.andDo(print());
		ResultMatcher rm= result ->{
			final String expectedBody="application web avec Spring-Boot, serveur Undertow";
			String contentAsString = result.getResponse().getContentAsString();
			if(!contentAsString.contains(expectedBody)) 
				throw new Exception("Not match!! response="+contentAsString);
		};
		
		resAct.andExpect(status().isOk()).andExpect(rm);

	}
	
	@Test
	public void testRestNbUsers() throws Exception {

		MockHttpServletRequestBuilder getRestUrl = get("/nbUsers") ;//.accept(MediaType.parseMediaType("application/json;charset=UTF-8"));
		ResultActions resAct = mockMvc.perform(getRestUrl);

		resAct.andDo(print());
		
		resAct.andExpect(status().isOk())
			  .andExpect(content().contentType("application/json;charset=UTF-8"))
			  .andExpect(content().string("8"));		
	}
}
