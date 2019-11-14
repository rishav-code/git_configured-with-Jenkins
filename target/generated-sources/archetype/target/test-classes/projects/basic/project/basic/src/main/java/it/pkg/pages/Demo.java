package it.pkg.pages;

import org.openqa.selenium.WebDriver;

import it.pkg.constant.Findloc;
import it.pkg.helper.CommonUtlity;

public class Demo {
	WebDriver driver;
	CommonUtlity commonUtlity;
	 
	Findloc loc;

	public Demo(WebDriver driver) {
		this.driver = driver;
		commonUtlity = new CommonUtlity(driver);
		loc = new Findloc();
	}

}
