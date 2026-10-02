package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CrudItemApiStep {

    Response response;
    int itemId;

    @Given("que tengo acceso al API todo.ly")
    public void queTengoAccesoAlAPITodoLy() {

    }

    @When("envio el POST request a la url {string} con el body")
    public void envioElPOSTRequestALaUrlConElBody(String url, String body) {
        response =
                given()
                        .auth()
                        .preemptive()
                        .basic("MishShell@clase.com", "abc123")
                        .body(body)
                        .log().all()
                        .when()
                        .post(url)
                        .then()
                        .log()
                        .all()
                        .extract().response();
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int codigoRespuestaEsperado) {
        response
                .then()
                .statusCode(codigoRespuestaEsperado);
    }

    @And("el nombre del item deberia ser {string}")
    public void elNombreDelPItemDeberiaSer(String nombreItemEsperado) {
        response
                .then()
                .body("Content", equalTo(nombreItemEsperado));
    }

    @And("el Checked del item deberia {string}")
    public void elCheckedDelItemDeberiaSer(String checkedItemEsperado) {
        response
                .then()
                .body("Checked", equalTo(checkedItemEsperado));
    }

    @And("guardo el id del item de la variable {string}")
    public void guardoElIdDelItemDeLaVariable(String variable) {
        itemId = response.jsonPath().getInt(variable);
    }

    @When("envio el PUT request a la url {string} con el body")
    public void envioElPUTRequestALaUrlConElBody(String url, String body) {
        response =
                given()
                        .auth()
                        .preemptive()
                        .basic("MishShell@clase.com", "abc123")
                        .body(body)
                        .log().all()
                        .when()
                        .put(url.replace("ITEM_ID", "" + itemId))
                        .then()
                        .log().all()
                        .extract().response();
    }

    @When("envio el GET request a la url {string}")
    public void envioElGETRequestALaUrl(String url) {
        response =
                given()
                        .auth()
                        .preemptive()
                        .basic("MishShell@clase.com", "abc123")
                        .log().all()
                        .when()
                        .get(url.replace("ITEM_ID", "" + itemId))
                        .then()
                        .log().all()
                        .extract().response();
    }

    @When("envio el DELETE request a la url {string}")
    public void envioElDELETERequestALaUrl(String url) {
        response =
                given()
                        .auth()
                        .preemptive()
                        .basic("MishShell@clase.com", "abc123")
                        .log().all()
                        .when()
                        .delete(url.replace("ITEM_ID", "" + itemId))
                        .then()
                        .log().all()
                        .extract().response();
    }
}
