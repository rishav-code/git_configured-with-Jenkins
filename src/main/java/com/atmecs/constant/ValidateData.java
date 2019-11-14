package com.atmecs.constant;

import java.util.Properties;

import com.atmecs.util.ReadProp;
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

	public String getData(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}
