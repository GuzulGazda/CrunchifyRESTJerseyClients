package kiv.tut.webservices.rest.crunchifyrestjersey.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author Crunchify.com
 *
 */
public class CrunchifyRESTJerseyNetURLClient {

    public static void main(String[] args) {
        System.out.println("\n============Output:============ \n" + callURL("http://localhost:8080/CrunchifyRESTJersey/crunchify/ctofservice/"));
    }

    public static String callURL(String myURL) {
        System.out.println("Requested URL: " + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                try (BufferedReader bufferedReader = new BufferedReader(in)) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                }

            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }

        return sb.toString();
    }
}
