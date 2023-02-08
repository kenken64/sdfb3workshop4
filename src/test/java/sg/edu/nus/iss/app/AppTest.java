package sg.edu.nus.iss.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.app.server.Cookie;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private List<String> cookies = null;
    private static final String COOKIE_FILENAME =
    "/Users/kennethphang/Projects/sdfb3workshop6/" + 
            "cookie_file.txt";
    /**
     * Rigorous Test :-)
     */
    @Before
    public void init() throws IOException{
        cookies =Cookie.getDataFromText(COOKIE_FILENAME);
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
        String cookieName= Cookie.getRandomCookie(COOKIE_FILENAME);
        assertTrue(cookieName.length() >= 4);
    }
}
