package it.pkg.constant;

import java.util.Properties;

import it.pkg.util.ReadProp;
/**
 * ValidateData class
 * Gets validation data
 * In this class, property file is loaded for validation
 * @author rishav.kumar
 *
 */
public class ValidateData {

	static Properties assessment;

	public ValidateData() {
		assessment = ReadProp.loadProperty(FilePath.VALIDATION_FILE);
	}

	public static String getData(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}
