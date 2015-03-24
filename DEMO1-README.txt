README  SPRING BOOT

NOTE BENA: the run use agent springloaded
 * Agent springloaded used in vm argument bloc run config 
 * with this line -javaagent:/PATH/springloaded-x.x.x.jar -noverify


OVERVIEW SPRING-BOOT:
======================
src:
deals.manningpublications.com/SpringBootOverview.pdf 
voici un resumé:
Spring boot brings a great deal of magic to Spring application development. But there are four core tricks that it performs:

1) Automatic configuration: Spring Boot can automatically provide configuration for
application functionality common to many Spring applications.

2) Starter dependencies: You tell Spring Boot what kind of functionality you need and it will ensure that the libraries needed are added to the build.

3) The command line interface: This optional feature of Spring Boot lets you write complete applications with just application code, but no need for a traditional project build.

4) The Actuator: Gives you insight into what is going on inside of a running Spring Boot application.


traduit en fr:
Spring Boot apporte beaucoup de magie pour le développement d'applications de Spring. 
Mais il ya quatre tours de magie: 
1) Configuration automatique: 
   Spring Boot peut automatiquement fournir configuration pour les fonctionnalité communes à 
   de nombreuses applications de spring. 
2) Les dépendances : 
   Vous dites à Spring Boot le type de fonctionnalité dont vous avez besoin et il va 'assurer 
   que les bibliothèques nécessaires sont ajoutées à la construction. 

3) L'interface de ligne de commande: 
   C'est une option du Spring Boot qui permet d'écrire des applications complètes avec 
   le code de l'application juste, mais pas besoin d'une génération de projet traditionnelle. 
4) Actionneur: 
vous donne un aperçu de ce qui se passe à l'intérieur d'une application Spring boot en cours.


===========================================

Pour le rechargement a chaud voir cet article:

http://blog.netgloo.com/2014/05/21/hot-swapping-in-spring-boot-with-eclipse-sts/


=====================================================================
POUR CONSTRUIRE UN WAR A DEPLOYER DANS UN CONTAINER EXTERNE voici les étapes:
(src: http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file  §74)
I. dans le pom changer le package en war 	
    <packaging>war</packaging>

II. S'assurer que la classe SpringApplication (ici DemoApplication) extends SpringBootServletInitializer comme ceci:

public class DemoApplication extends SpringBootServletInitializer {
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(DemoApplication.class);
	}
....


III. Optionnel, mettre en provided la dependance sur tomcat
