package com.atmecs.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.constant.FilePath;
import com.atmecs.util.ProvideData;
/**
 * DataProvider class
 * In this class, data is given from the dataprovider
 * @author rishav.kumar
 *
 */
public class Dataprovide {
	@DataProvider(name = "SearchData")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}

	@DataProvider(name = "logindata")
	public Object[][] getData2() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE2, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	@DataProvider(name = "indexInput")
	public Object[][] getData5() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE2, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	@DataProvider(name = "TutorialsNinja")
	public Object[][] getData3() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	@DataProvider(name = "TutorialsNinjaCart")
	public Object[][] getData4() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideData();
		return getData;
	}
	
	
}
