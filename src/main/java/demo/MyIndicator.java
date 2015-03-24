package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyIndicator implements HealthIndicator{
	

	final static Logger LOGGER = LoggerFactory
			.getLogger("MyIndicator");
	 @Override
	  public Health health() {
		 
		 Health.Builder  hb=new Health.Builder(Status.UP);
		 if(LOGGER.isInfoEnabled()){
			 LOGGER.info("indicateur health");
		 }
		 return hb.build();
	 }
}
