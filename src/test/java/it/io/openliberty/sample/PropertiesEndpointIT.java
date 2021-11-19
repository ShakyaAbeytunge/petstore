package it.io.openliberty.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.provider.jsrjsonp.JsrJsonpProvider;
import org.junit.jupiter.api.Test;

public class PropertiesEndpointIT {

  @Test
  public void testGetType() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets/types");
    Response response = target.request().get();

    // response
    assertEquals(200, response.getStatus(), "Incorrect response code from " + url);

    response.close();
  }

  @Test
  public void testDeleteType() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets/deleteType");
    String petType = "fish";
    Response response = target.path(petType).request().delete(Response.class);

    // response
    assertEquals(204, response.getStatus(), "Incorrect response code from " + url);

    response.close();
  }

  @Test
  public void testGetPets() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets");
    Response response = target.request().get();

    // response
    assertEquals(200, response.getStatus(), "Incorrect response code from " + url);

    response.close();
  }

  @Test
  public void testDeletePet() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets");
    String petId = "3";
    Response response = target.path(petId).request().delete(Response.class);

    // response
    assertEquals(204, response.getStatus(), "Incorrect response code from " + url);

    response.close();
  }

  @Test
  public void testInsertPet() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets");
    Response response = target.request()
        .post(Entity.json("{\"id\":1,\"petAge\":3,\"petName\":\"Boola\",\"petType\":\"Dog\"}"));

    // response
    assertEquals(200, response.getStatus(), "Incorrect response code from " + url);

    String output = response.readEntity(String.class);

    assertEquals("{\"id\":1,\"petAge\":3,\"petName\":\"Boola\",\"petType\":\"Dog\"}", output,
        "Inserted pet name and responded pet name should match");
    response.close();
  }

  @Test
  public void testUpdatePet() {

    // system properties
    String port = System.getProperty("http.port");
    String contextRoot = "/";
    String url = "http://localhost:" + port + contextRoot;

    // client setup
    Client client = ClientBuilder.newClient();
    client.register(JsrJsonpProvider.class);

    // request
    WebTarget target = client.target(url + "petstore/pets");
    Response response = target.request()
        .put(Entity.json("{\"id\": 1,\"petAge\": 5,\"petName\": \"Boola\",\"petType\": \"Dog\"}"));

    // response
    assertEquals(200, response.getStatus(), "Incorrect response code from " + url);

    String output = response.readEntity(String.class);

    assertEquals("{\"id\":1,\"petAge\":5,\"petName\":\"Boola\",\"petType\":\"Dog\"}", output,
        "Inserted pet details and responded pet details should match");

    response.close();
  }

}
