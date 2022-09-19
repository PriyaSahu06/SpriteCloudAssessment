package stepDefinitions;
import API_Testing.pojo.AddPet;
import API_Testing.pojo.PlaceOrder;
import com.google.gson.Gson;
import enums.OrderStatus;
import helper.GlobalAPIObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class ApiTest extends GlobalAPIObjects{

    Gson gson = new Gson();

    private String path;
    private Response response;


    @Given("the pet endpoint exists")
    public void preReq() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        path = "/pet";
        addpet = new AddPet();
    }

    @When("the order endpoint exists")
    public void preOrder() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        path = "/store/order/";
        placeOrder = new PlaceOrder();
    }

    @When("the delete order endpoint exists")
    public void deleteRequest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        path = "/store/order/";
    }

    @When("I send a valid order payload")
    public void validOrderPayload() {
        placeOrder.setId(0L);
        placeOrder.setPetId(addpet.getId());
        placeOrder.setStatus(OrderStatus.PLACED.toString());
        placeOrder.setQuantity(1);
        placeOrder.setComplete(true);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        placeOrder.setShipDate(sdf.format(date));

        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(gson.toJson(placeOrder))
                .post(path)
                .then().extract().response();
    }


    @When("I send a delete order request")
    public void deleteOrderRequest() {
        path = path+placeOrder.getId();
        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .delete(path)
                .then().extract().response();
    }



    @Then("order response should be valid")
    public void orderResponseValid() {
        PlaceOrder temporary = gson.fromJson(response.getBody().asPrettyString(), PlaceOrder.class);
        Assert.assertNotEquals(temporary.getId(),0L);
        Assert.assertEquals(temporary.getPetId(),placeOrder.getPetId());
        placeOrder = temporary;
    }

    @When("I send a valid add pet payload with name (.*) and photoUrl (.*)$")
    public void createPet(String name, String photoUrl) {
        AddPet.Category category = new AddPet.Category();
        category.setId(0L);
        category.setName("String");
        addpet.setCategory(category);
        addpet.setName(name);
        addpet.setPhotoUrls(Arrays.asList(photoUrl));
        AddPet.Tags tag = new AddPet.Tags();
        tag.setId(0L);
        tag.setName("stringData");
        addpet.setTags(Arrays.asList(tag));
        addpet.setStatus("available");


        response = given()
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON)
                .body(gson.toJson(addpet))
                .post(path)
                .then().extract().response();
    }

    @Then("response status code should be {int}")
    public void checkResponseStatusCode(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }

    @And("add pet response should be valid")
    public void verifyResponse() {
        AddPet temporary = gson.fromJson(response.getBody().asPrettyString(), AddPet.class);
        Assert.assertNotEquals(temporary.getId(),0L);
        Assert.assertEquals(temporary.getName(),addpet.getName());
        addpet = temporary;
    }
}