package com.atmecs.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	

public By selectLocator(String locator) {
By by = null;
String[] loc = locator.split(",", 2);

switch (loc[0].toUpperCase()) {
case "ID":
by = (By.id(loc[1]));
break;
case "NAME":
by = (By.name(loc[1]));
break;
case "CLASS":
by = (By.className(loc[1]));
break;
case "LINKTEXT":
by = (By.linkText(loc[1]));
break;
case "PARTIAL":
by = (By.partialLinkText(loc[1]));
break;
case "CSS":
by = (By.cssSelector(loc[1]));
break;
case "TAGNAME":
by = (By.tagName(loc[1]));
break;
case "XPATH":
by = (By.xpath(loc[1]));
break;
}
return by;

}

public WebElement waitElementToBeClickable(WebDriver driver, String locator, long waitingTime) {
WebDriverWait wait = new WebDriverWait(driver, waitingTime);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(selectLocator(locator)));
return element;

}

public WebElement waitElementToBeClickable(WebDriver driver, WebElement webElement, long waitingTime) {
WebDriverWait wait = new WebDriverWait(driver, waitingTime);
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
return element;

}

public WebElement waitVisibilityOf(WebDriver driver, WebElement webElement, long waitingTime) {
WebDriverWait wait = new WebDriverWait(driver, waitingTime);
WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
return element;
}

public WebElement waitPresenceOfElementLocated(WebDriver driver, String locator, long waitingTime) {
WebDriverWait wait = new WebDriverWait(driver, waitingTime);
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(selectLocator(locator)));
return element;


}

}

