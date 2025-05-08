package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";

		Excelutility xlUtil = new Excelutility(path);

		int totalrows = xlUtil.getRowCount("Sheet1");
		int totalcols = xlUtil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i = 1][j] = xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}

	// DataProvider2

	// DataProvider3

}
