package Utility;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;


@Sources({ 
	"file:src\\test\\resources\\propertyFiles\\${env}.properties" // mention the property file name
})
public interface ConfigProperties extends Config {
	
	@Key(value="baseURI")
	String getBaseURI();
	
	@Key(value="basePath")
	String getBasePath();
	
	

}
