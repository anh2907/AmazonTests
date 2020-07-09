package datadriven;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "ValidLoginData")
    public Object[][] getLoginData(){
        //Object[][] data ={{"sunflower837@yahoo.com", "Kms@2018"}};
        ReadExcelFile config = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\AmazonTests\\src\\test\\java\\testdata\\AmazonTestData.xlsx");
        int rows = config.getRowCount("ValidLoginData");
        Object[][] data = new Object[rows][2];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("ValidLoginData", i, 0);
            data[i][1] = config.getData("ValidLoginData", i, 1);
        }
        return data;
    }
    @DataProvider(name = "InValidEmail")
    public Object[][] getInvalidEmail(){
        //Object[][] data = {{"abc@yahoo"},{"testabc@"},{"~!@#$%^&*()"}};
        ReadExcelFile config = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\AmazonTests\\src\\test\\java\\testdata\\AmazonTestData.xlsx");
        int rows = config.getRowCount("InValidEmail");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidEmail", i, 0);
        }
        return data;
    }
    @DataProvider(name="InValidPassword")
    public Object[][] getInvalidPassword(){
        //Object[][] data = {{"123456"},{"testabc"},{"!@#$%^&*"}};
        ReadExcelFile config = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\AmazonTests\\src\\test\\java\\testdata\\AmazonTestData.xlsx");
        int rows = config.getRowCount("InValidPassword");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidPassword", i, 0);
        }
        return data;
    }

}
