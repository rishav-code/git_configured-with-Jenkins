package it.pkg.validation;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import it.pkg.constant.FilePath;
import it.pkg.helper.CommonUtlity;
import it.pkg.util.ReadProp;

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
