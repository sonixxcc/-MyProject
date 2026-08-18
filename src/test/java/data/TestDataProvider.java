package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][]{
                {"wrong@gmail.com", "wrong123"},
                {"test@gmail.com", "wrong456"},
                {"invalid@gmail.com", "password"}
        };
    }
}