package demo;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DemoRestApplication.class, RestTemplate.class})
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class FirstDemoRestCtrlTests {

	
	@Value("${local.server.port}")
	private String port;
	
	@Value("${server.context-path}")
	private String contextPath;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Test
	public void testRest() throws Exception {

		int ret=restTemplate.getForObject("http://localhost:"+port+contextPath+"/nbUsers", Integer.class);
		Assert.assertEquals(ret, 8);
	}
}
