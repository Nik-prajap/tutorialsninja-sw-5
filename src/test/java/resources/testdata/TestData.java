package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"HTC Touch HD", "1", "Success: You Have Added HTC Touch HD to Your shopping Cart!", "HTC Touch HD", "Product 1", "£74.73"},
                {"iPhone", "2", "Success: You Have Added iPhone to Your shopping Cart!", "iPhone", "Product 11", "£150.92"},
                {"Palm Treo Pro", "3", "Success: You Have Added Palm Treo Pro to Your shopping Cart!", "Palm Treo Pro", "Product 2", "£1,242.11"}
        };
        return data;
    }
}
