#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import java.util.Properties;

import ${package}.util.ReadProp;
/**
 * Find locator class
 *  In this class, property file is loaded for getting locators.
 * @author rishav.kumar
 *
 */
public class Findloc {
	static Properties assessment;

	public Findloc() {
		assessment = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
	}

	public String getlocator(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}
