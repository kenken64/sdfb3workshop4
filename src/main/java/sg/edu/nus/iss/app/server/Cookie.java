package sg.edu.nus.iss.app.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cookie {

    public static String getRandomCookie(String cookieFilepath){
        String randomCookie = "";
        List<String> cookies = new LinkedList<>();
        try {
            cookies = getDataFromText(cookieFilepath);
            Random rand = new Random();
            int randVal = rand.nextInt(cookies.size());
            randomCookie = cookies.get(randVal);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return randomCookie;
    }

    public static List<String> getDataFromText(String filepath) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        List<String> lists = new LinkedList<>();

        String line;
        while ((line = br.readLine()) != null) {
            lists.add(line);         
        }
        return lists;
    }
}
