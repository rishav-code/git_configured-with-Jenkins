package com.atmecs.scripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atmecs.constant.FilePath;
import com.atmecs.constant.TimeOut;
import com.atmecs.dataprovider.Dataprovide;
import com.atmecs.pages.HeatClinicPages;
import com.atmecs.testbase.TestBase;
import com.atmecs.util.ReadProp;

public class HeatClinic extends TestBase{
	Properties baseClass;
	//PhpFlow flow;
	ReadProp property ;
	
	String url;
	
	HeatClinicPages travel;
	
	@BeforeClass
	public void urlqw() {
		baseClass = ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url2");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);

}
	@Test(priority = 1, dataProvider = "indexInput", dataProviderClass = Dataprovide.class)
	public void menuClick(String index,String title) {
		travel=new HeatClinicPages(driver);
		travel.menu( index,title);
		
	}
	@Test(priority = 2, dataProvider = "logindata", dataProviderClass = Dataprovide.class)
	public void menuTravelTest(String Mensmarchandisedata,String Personalizname,String shirtname,String expectedShirtSize,String expectedNameInCart ,String expectedShirtColour,String quantity,String expectedtotalupdatedprice,String pricebexpected,String totalbexpected) {
		travel=new HeatClinicPages(driver);
		
		travel.clickOnMerchindiseMen(Mensmarchandisedata);
		travel.selectShirt(Personalizname);
		travel.validateCart(shirtname,expectedShirtSize,expectedNameInCart,expectedShirtColour);
		travel.increaseQuantity(quantity,expectedtotalupdatedprice);
		travel.validatePrice( totalbexpected);
		
	}

}
