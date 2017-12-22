package nyc.c4q;

import java.net.URL;
import java.util.Scanner;

/**
 * Created by samuel on 2015-03-22.
 */
public class HttpTest {

    public static final String
            URL = "http://alexsamuel.net/AliceInWonderland.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a url: ");
        String input = scanner.nextLine();
        URL url = HTTP.stringToURL(input);
        String document = HTTP.get(url);

        System.out.println(document);
    }

}
