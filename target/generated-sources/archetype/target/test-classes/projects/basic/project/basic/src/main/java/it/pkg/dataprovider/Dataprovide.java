package it.pkg.dataprovider;

import org.testng.annotations.DataProvider;

import it.pkg.constant.FilePath;
import it.pkg.util.ProvideData;
/**
 * DataProvider class
 * In this class, data is given from the dataprovider
 * @author rishav.kumar
 *
 */
public class Dataprovide {
	@DataProvider(name = "Dpdninput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}


}
