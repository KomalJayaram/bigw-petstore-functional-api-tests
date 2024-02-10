package endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PetStoreEndpoint {

    public RequestSpecification httpRequest = RestAssured.given();

     private final String baseURL = "https://petstore.swagger.io/v2";
     private final String addPetPath = "/pet";

     public PetStoreEndpoint(){
         httpRequest.header("Content-Type","application/vnd.api+json; character=UTF-8");
     }


    /**
     *
     */
    public Response hitPetStoreHomePage(){
        return httpRequest
                .header("Content-Type", "application/json")
                .get(baseURL);

    }

    /**
     *
     */
    public Response addPetToStoreCatalogue(int id, String name, String status, int categoryId, String categoryName, int tagId, String tagName) {

        JSONObject body = new JSONObject();
        JSONObject category = new JSONObject();
        JSONArray tags = new JSONArray();
        JSONArray photoUrls = new JSONArray();
        JSONObject tag1 = new JSONObject();

        body.put("id", id);
        body.put("category", category);
        body.put("name", name);
        body.put("tags", tags);
        body.put("status", status);
        body.put("photoUrls", photoUrls);
        category.put("id", categoryId);
        category.put("name", categoryName);
        tags.add(tag1);
        tag1.put("id", tagId);
        tag1.put("name", tagName);
        photoUrls.add("photoUrl.jpg");


        return httpRequest
                .log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(body.toJSONString())
                .post(baseURL+ addPetPath);

    }

    /**
     *
     */
    public Response addPetToStoreCatalogue() {


        return httpRequest
                .log().all()
                .header("Content-Type", "application/json")
                .post(baseURL+ addPetPath);
    }

    public Response addPetToStoreCatalogueWithNoHeader() {
        JSONObject body = new JSONObject();

        return httpRequest
                .log().all()
                .body(body.toJSONString())
                .post(baseURL+ addPetPath);
    }
}
