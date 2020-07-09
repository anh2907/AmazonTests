package amazonautotest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
    @Test
    public void loginByEmail(){
        System.out.println("Login by mail");
        Assert.assertEquals("anh", "anh");
    }
    @Test
    public void loginByFacebook(){
        System.out.println("Login by facebook");
        Assert.assertEquals("nguyen", "anh");
    }

}
