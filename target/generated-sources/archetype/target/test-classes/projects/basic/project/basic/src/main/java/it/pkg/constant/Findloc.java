package it.pkg.constant;

import java.util.Properties;

import it.pkg.util.ReadProp;
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
