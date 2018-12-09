/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiv.tut.webservices.rest.crunchifyrestjersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ihor
 */
public class CrunchifyRESTJerseyClient {

    private static final Logger LOG = Logger.getLogger(CrunchifyRESTJerseyClient.class.getName());
    
    public static void main(String[] args) {
        CrunchifyRESTJerseyClient client = new CrunchifyRESTJerseyClient();
        client.getFtoCResponse();
        client.getCtoFResponse();
    }
    

    private void getFtoCResponse() {
        try {
            Client client = Client.create();
            WebResource webResource2 = client.resource("http://localhost:8080/CrunchifyRESTJersey/crunchify/ftocservice/90");
            ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
            if (response2.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
            }
            
            String output2 = response2.getEntity(String.class);
            System.out.println("\n============getFtoCResponse============");
            System.out.println(output2);

        } catch (RuntimeException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
        private void getCtoFResponse() {
        try {
            Client client = Client.create();
            WebResource webResource2 = client.resource("http://localhost:8080/CrunchifyRESTJersey/crunchify/ctofservice/90");
            ClientResponse response2 = webResource2.accept("application/xml").get(ClientResponse.class);
            if (response2.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
            }
            
            String output2 = response2.getEntity(String.class);
            System.out.println("\n============getFtoCResponse============");
            System.out.println(output2);

        } catch (RuntimeException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
}
