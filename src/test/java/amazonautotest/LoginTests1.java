package amazonautotest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests1 {
    @Test
    public void loginByEmail1(){
        System.out.println("Login by mail1");
        Assert.assertEquals("anh", "anh");
    }
    @Test
    public void loginByFacebook1(){
        System.out.println("Login by facebook1");
        Assert.assertEquals("nguyen", "anh");
    }
}
