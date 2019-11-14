package com.atmecs.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.atmecs.constant.Findloc;
import com.atmecs.constant.TimeOut;
import com.atmecs.constant.ValidateData;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.helper.Waits;
import com.atmecs.reports.LogReport;

public class TutorialsNinja {
	WebDriver driver;
	CommonUtlity WebUtility;
	LogReport log;
	Findloc loc;
	ValidateData validatedata;
	Waits wait;

	public TutorialsNinja(WebDriver driver) {
		this.driver = driver;

		// loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		WebUtility = new CommonUtlity(driver);
		loc = new Findloc();
	}

	public void homePageLanding() {
		log = new LogReport();
		validatedata = new ValidateData();

		String webPageTitle = driver.getTitle();
		System.out.println(validatedata.getData("HomePageTitle"));

		assertEquals(webPageTitle, validatedata.getData("HomePageTitle"), "Assertion for landing on webpage failed");
		log.info("Assertion for home page landing passed");
	}

	public void addToCartphone(String product, String productQuantity, String ExpProductPrice, String expExTax) {
		validatedata = new ValidateData();
		log = new LogReport();
		WebUtility.clickElement(loc.getlocator("loc.search.text"));
		WebUtility.clickAndSendText(loc.getlocator("loc.search.text"), TimeOut.TIMEOUT_INSECONDS, product);
		WebUtility.clickElement(loc.getlocator("loc.SearchButtom.click"));
		WebUtility.clickElement(loc.getlocator("loc.iphoneimage.click"));

		WebUtility.clearTextData(loc.getlocator("loc.iphonequantityinput.text"));
		WebUtility.clickAndSendText(loc.getlocator("loc.iphonequantityinput.text"), TimeOut.TIMEOUT_INSECONDS,
				productQuantity);

		WebUtility.clickElement(loc.getlocator("loc.iphoneaddtocart.click"));
		WebUtility.clearTextData(loc.getlocator("loc.search.text"));
		System.out.println(product);

		if (product.equalsIgnoreCase("iPhone")) {
			wait = new Waits();

			String avablityStatus = WebUtility.getElement(loc.getlocator("loc.productavablityiphone.text")).getText();
			System.out.println(avablityStatus);
			System.out.println(validatedata.getData("Avaibality"));

			assertEquals(avablityStatus, validatedata.getData("Avaibality"),
					"Assertion  product availablity failed" + "" + product);

			log.info("Assertion  product availablity passed " + "" + product);
			// WebUtility.scrollDownPage(300);
			System.out.println("Description validation iphone started");

			String iphonedescription = WebUtility.getElement(loc.getlocator("loc.productdesciphone.text")).getText();
			System.out.println("Description validation iphone continue");
			Assert.assertTrue(iphonedescription.contains(validatedata.getData("iPhonedescription")),
					"Assertion for product iPhone description failed" + " of " + product);
			log.info("Assertion for product iPhone description passed" + " of " + product);

		}
		if (product.equalsIgnoreCase("MacBook Air")) {

			String avablityStatus = WebUtility.getElement(loc.getlocator("loc.productavablitymac.text")).getText();
			System.out.println(avablityStatus);
			assertEquals(avablityStatus, validatedata.getData("Avaibality"),
					"Assertion  product availablity failed" + "" + product);
			log.info("Assertion  product availablity passed " + "" + product);
			WebUtility.scrollDownPage(300);

			String macdescription = WebUtility.getElement(loc.getlocator("loc.productdesc.text")).getText();

			Assert.assertTrue(macdescription.contains(validatedata.getData("MacDescription")),
					"Assertion for product macbook description failed" + "   " + product);
			log.info("Assertion for product macbook description passed" + "   " + product);

		}

		String productPrice = WebUtility.getElement(loc.getlocator("loc.productprice.text")).getText();
		System.out.println(productPrice);
		assertEquals(productPrice, "" + ExpProductPrice, "Assertion  product price failed" + " " + product);
		log.info("Assertion  product price passed " + "" + product);
		String exTax = WebUtility.getElement(loc.getlocator("loc.extax.text")).getText();
		assertEquals(exTax, "" + expExTax, "Assertion  product extax failed" + "  " + product);
		log.info("Assertion  product extax passed " + "" + product);
		// WebUtility.clickElement(loc.getlocator("loc.iphoneimage.click"));

	}

	public void cartValidation(String iphoneAdded, String macAdded, String totalAmount, String UpdatedTotalAmount) {
		log = new LogReport();
		WebUtility.clickElement(loc.getlocator("loc.clickon.cart"));
		WebUtility.clickElement(loc.getlocator("loc.viewcart.click"));

		String cartiphonevalue = WebUtility.getElement(loc.getlocator("loc.iphoneadded.text")).getText();
		System.out.println(cartiphonevalue);
		assertEquals(cartiphonevalue, iphoneAdded, "Assertion failed for iphone added in cart");
		log.info("Assertion passed iphone added in cart");

		String cartmacvalue = WebUtility.getElement(loc.getlocator("loc.macadded.text")).getText();
		System.out.println(cartmacvalue);
		assertEquals(cartmacvalue, macAdded, "Assertion failed for mac added in cart");
		log.info("Assertion passed mac added in cart");
		WebUtility.scrollDownPage(500);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String totalPrice = WebUtility.getElement(loc.getlocator("loc.totalamount.beforeupdate")).getText();
		System.out.println(totalPrice);
		assertEquals(totalPrice, "" + totalAmount, "Assertion failed for totalamount added in cart");
		log.info("Assertion passed for total amount");
		WebUtility.clickElement(loc.getlocator("loc.mac.remove"));
		WebUtility.scrollDownPage(500);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String updatedTotalPrice = WebUtility.getElement(loc.getlocator("loc.totalamount.beforeupdate")).getText();
		System.out.println(updatedTotalPrice);
		assertEquals(updatedTotalPrice, "" + UpdatedTotalAmount, "Assertion failed for totalamount added in cart");
		log.info("Assertion passed for total amount");

	}

	public void negativeDataSearch(String negativeData) {
		log = new LogReport();
		
		System.out.println("this is" + " " + negativeData);
		WebUtility.clickElement(loc.getlocator("loc.search.text"));
		WebUtility.clickAndSendText(loc.getlocator("loc.search.text"), TimeOut.TIMEOUT_INSECONDS, negativeData);
		WebUtility.clickElement(loc.getlocator("loc.SearchButton2.click"));
		boolean negativeMessage = WebUtility.isDisplayed(loc.getlocator("loc.negativemsg.text"));
		assertEquals(negativeMessage, true, "Validation for negative data failed");
		log.info("Validation for negative data passed");

	}

}
