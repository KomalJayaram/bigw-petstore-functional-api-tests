package steps;

import endpoints.PetStoreEndpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class addPetAPITests {

    Response response;

    @Given("The POST pet API can be hit")
    public void the_POST_pet_API_can_be_hit() {

        response = new PetStoreEndpoint().hitPetStoreHomePage();
    }

    @When("I add a pet to the catalogue with \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void i_add_a_pet_to_the_catalogue(int petId, String petName, String status, int categoryId, String categoryName, int tagId, String tagName) throws Throwable{

        response = new PetStoreEndpoint()
                .addPetToStoreCatalogue(petId,petName,status,categoryId,categoryName,tagId,tagName);

    }

    @Then("the pet is added to the catalogue successfully with \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void the_pet_is_added_to_the_catalogue_successfully(int id, String name, String status, int categoryId, String categoryName, int tagId, String tagName) {

        response.then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(id),
                        "name", equalTo(name),
                        "status", equalTo(status),
                        "category.name", equalTo(categoryName),
                        "category.id", equalTo(categoryId),
                        "tags[0].name", equalTo(tagName),
                        "tags[0].id", equalTo(tagId));
    }

    @When("I add a pet to the catalogue with no payload")
    public void i_add_a_pet_to_the_catalogue_with_no_payload(){

        response = new PetStoreEndpoint()
                .addPetToStoreCatalogue();
    }

    @Then("send an error with \"(.*)\"$")
    public void send_an_error_with_errorCode(int errorCode){

        response.then().log().all()
                .statusCode(errorCode)
                .body(notNullValue());
    }

    @When("I add a pet to the catalogue with no header")
    public void i_add_a_pet_to_the_catalogue_with_no_header(){

        response = new PetStoreEndpoint()
                .addPetToStoreCatalogueWithNoHeader();
    }

    @When("I add a pet to the catalogue with empty payload")
    public void i_add_a_pet_to_the_catalogue_with_empty_payload(){

        response = new PetStoreEndpoint()
                .addPetToStoreCatalogueWithEmptyPayload();
    }

    @Then("the pet is added to the catalogue successfully with an Id")
    public void the_pet_is_added_to_the_catalogue_successfully_with_an_Id(){
        response.then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("id",notNullValue());
    }
}
