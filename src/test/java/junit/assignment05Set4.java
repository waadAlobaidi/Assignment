package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class assignment05Set4 extends testCase{
    @Test
    public void assignment0504(){
      /*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */

//    Go to URL: http://facebook.com
        driver4.navigate().to("http://facebook.com");

//    getCookies
        driver4.manage().getCookies().forEach(System.out::println);
        Cookie newCookie = new Cookie("my new cookie", "waadAlobaidi");
//    addCookie
        driver4.manage().addCookie(newCookie);
        System.out.println(newCookie);

//    deleteCookieNamed,
        driver4.manage().deleteCookieNamed("newCookie");

        System.out.println("Size of cookies "+  driver4.manage().getCookies().size());

//    deleteAllCookies
        driver4.manage().deleteAllCookies();
    }
}
