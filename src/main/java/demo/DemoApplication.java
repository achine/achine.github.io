package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




/**
 * Agent springloaded used in vm argument bloc run config 
 * with this line -javaagent:/PATH/springloaded-x.x.x.jar -noverify
 * @author Abdou
 *
 */
@SpringBootApplication
@Controller
public class DemoApplication extends SpringBootServletInitializer /* extends SpringBootServletInitializer utile pour le war **/ {

	//ceci est utile pour produire un war a deployer sur un server 
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(DemoApplication.class);
	}
		 
	@RequestMapping("/")
	String technos(Model model){
		model.addAttribute("message","Spring-Boot, Undertow server,Springloaded");
		return "technos";
	}
	@RequestMapping("/theme")
	String theme(Model model){
		model.addAttribute("theme","Démo d'application web avec Spring-Boot, serveur Undertow & l'agent de chargement à chaud: Springloaded");
		return "theme";
	}
    public static void main(String[] args) {
    	
    	SpringApplication app = new SpringApplication(DemoApplication.class,DemoRestApplication.class);
    	app.setLogStartupInfo(false);
    	app.setWebEnvironment(true);/*optionnel but recommanded?*/
    	app.setShowBanner(false);
    	app.run(args);
    }
}
