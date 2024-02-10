package steps;

import endpoints.PetStoreEndpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


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
                        "name", equalTo(name));
    }

}
