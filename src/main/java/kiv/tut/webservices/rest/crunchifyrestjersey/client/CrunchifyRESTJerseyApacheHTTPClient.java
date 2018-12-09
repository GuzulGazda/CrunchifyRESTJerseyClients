/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiv.tut.webservices.rest.crunchifyrestjersey.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author ihor
 */
public class CrunchifyRESTJerseyApacheHTTPClient {

    static String URL = "http://localhost:8080/CrunchifyRESTJersey/crunchify/ctofservice/122";
    private static final Logger LOG = Logger.getLogger(CrunchifyRESTJerseyApacheHTTPClient.class.getName());

    public static void main(String[] args) {
        try {

            // Create HTTP clietn
            HttpClient client = HttpClientBuilder.create().build();

            //create new getRequest with given URL
            HttpGet getRequest = new HttpGet(URL);

            // Add additional header to getRequest which accepts application/xml data
            getRequest.addHeader("accept", "application/xml");

            // Execute request and catch responce
            HttpResponse response = client.execute(getRequest);

            // Check for HTTP response code: 200 = success
            int statusCode = response.getStatusLine().getStatusCode();
            if (!(statusCode == 200)) {
                throw new RuntimeException("Failed: HTTP error code : " + statusCode);
            }

            // Get-Capture Complete application/xml body response
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String output;
            System.out.println("============Output:============");

            // Simply iterate through XML response and show on console.
            while ((output = reader.readLine()) != null) {
                System.out.println(output);
            }
        } catch (IOException | RuntimeException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
}
