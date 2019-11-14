#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.scripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;

import ${package}.constant.FilePath;
import ${package}.constant.TimeOut;
import ${package}.testbase.TestBase;
import ${package}.util.ReadProp;

public class DemoScript extends TestBase {
	Properties baseClass;
	//PhpFlow flow;
	ReadProp property ;
	String url;
	@BeforeClass
	public void urlqw() {
		baseClass=ReadProp.loadProperty(FilePath.CONFIG_FILE);
		url=baseClass.getProperty("url2");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOut.TIMEOUT_INSECONDS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOut.IMPLICIT_TIMEOUT_INSECONDS, TimeUnit.SECONDS);

}
}