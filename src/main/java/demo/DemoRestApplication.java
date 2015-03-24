package demo;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abdou 
 */
@SpringBootApplication
@RestController
public class DemoRestApplication {
	
	private final static Logger LOGGER = LoggerFactory
			.getLogger("DemoRestApplication");

	/**Jdbctemplate */
	@Autowired 
	private transient JdbcTemplate template;
	
	@RequestMapping("/nbUsers")
	int nbUsers() throws SQLException{
		final int res = template.queryForObject("select count(*) from userlogin", new Integer[] {},Integer.class);
		if( LOGGER.isDebugEnabled() ){
			LOGGER.debug("count users=" + res);
		}
		return res;
	}
	
	public static void main(final String[] args) {
    	final SpringApplication app = new SpringApplication(DemoRestApplication.class);
    	app.setLogStartupInfo(false);
    	app.setShowBanner(true);
    	app.run(args);
    }
}
