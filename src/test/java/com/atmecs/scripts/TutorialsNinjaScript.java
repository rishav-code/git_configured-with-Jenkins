package com.atmecs.scripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.constant.FilePath;
import com.atmecs.constant.TimeOut;
import com.atmecs.dataprovider.Dataprovide;
import com.atmecs.pages.TutorialsNinja;
import com.atmecs.testbase.TestBase;
import com.atmecs.util.ReadProp;

public class TutorialsNinjaScript extends TestBase {
	Properties baseClass;
	// PhpFlow flow;
	ReadProp property;

	String url;
	TutorialsNinja flow;

	@BeforeClass
	public void urlqw() {
		baseClass = ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url = baseClass.getProperty("url1");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void homePageLandingValidation() {
		flow = new TutorialsNinja(driver);
		flow.homePageLanding();

	}

	@Test(priority = 2, dataProvider = "TutorialsNinja", dataProviderClass = Dataprovide.class)
	public void pageflowValidations(String product, String productQuantity, String productPrice, String extax) {
		flow = new TutorialsNinja(driver);

		flow.addToCartphone(product, productQuantity, productPrice, extax);

	}

	@Test(priority = 3, dataProvider = "TutorialsNinjaCart", dataProviderClass = Dataprovide.class)
	public void cartflowValidations(String iphoneAdded, String macAdded, String totalAmount, String UpdatedTotalAmount,
			String negativeData) {
		flow = new TutorialsNinja(driver);
		flow.cartValidation(iphoneAdded, macAdded, totalAmount, UpdatedTotalAmount);

	}

	@Test(priority = 4, dataProvider = "TutorialsNinjaCart", dataProviderClass = Dataprovide.class)
	public void negativeDataValidation(String iphoneAdded, String macAdded, String totalAmount,
			String UpdatedTotalAmount, String negativeData) {
		flow = new TutorialsNinja(driver);
		flow.negativeDataSearch(negativeData);
	}
}
