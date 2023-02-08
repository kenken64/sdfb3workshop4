package sg.edu.nus.iss.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.app.server.Cookie;

/**
 * Unit test for simple App.
 * export COOKIEFILE_PATH=/Users/kennethphang/Projects/sdfb3workshop6/cookie_file.txt
 */
public class AppTest 
{
    private List<String> cookies = null;
    private String cookieFilePathI  = null;
    /**
     * Rigorous Test :-)
     */
    @Before
    public void init() throws IOException{
        String cookieFilePath = System.getenv("COOKIEFILE_PATH");
        System.out.println(">>> >" +cookieFilePath);
        this.cookieFilePathI = cookieFilePath;
        cookies =Cookie.getDataFromText(cookieFilePathI);
    }

    @Test 
    public void testCookieDataFromFile(){
        assertTrue(!cookies.isEmpty());
    }

    @Test 
    public void testCookieDataFromFileNotNull(){
        assertTrue(cookies != null);
    }

    @Test 
    public void testCookieDataFromFileSize(){
        assertTrue(cookies.size() >=  27);
    }

    @Test
    public void testCookieRandomName(){
        String cookieName= Cookie.getRandomCookie(cookieFilePathI);
        assertTrue(cookieName.length() >= 4);
    }
}
