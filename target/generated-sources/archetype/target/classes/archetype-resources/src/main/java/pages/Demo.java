#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.pages;

import org.openqa.selenium.WebDriver;

import ${package}.constant.Findloc;
import ${package}.helper.CommonUtlity;

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
