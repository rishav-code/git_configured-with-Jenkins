#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.validation;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import ${package}.constant.FilePath;
import ${package}.helper.CommonUtlity;
import ${package}.util.ReadProp;

public class DemoValidation {
	WebDriver driver;
	Properties loc;
	CommonUtlity WebUtility;

	public DemoValidation (WebDriver driver) {
		this.driver = driver;
		loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);

	}

}
