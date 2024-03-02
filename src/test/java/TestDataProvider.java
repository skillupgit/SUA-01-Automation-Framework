import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "NegativeLoginTestData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][] {
                //{"demo@koel.dev","demo"},
                {"demo1@koel.dev","demos"},
                {"demo@koel.dev","demos"},
                {"",""},
        };
    }

}
