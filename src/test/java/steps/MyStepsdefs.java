package steps;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MyStepsdefs {

    /**
     * {} reemplaza cualquier valor como parametro
     * {word} = reemplaza una sola palabra
     * {string} = reemplaza un valor cuando esta en comillas dobles
     * {int} = reemplaza un valor numerico
     * {float} = reemplaza el valor decimal
     * */

    @Given("que tengo acceso a {}")
    public void queTengaAccesoAFacebook(String appName){
        System.out.println("step: que tengo acceso a " + appName);

    }

    @When("ingreso mi email: {word}")
    public void ingresoMiEmailAltCarlosGmailCom(String email) {
        System.out.println("step: ingreso mi usuario " + email);
        
    }

    @And("ingreso mi password: {string}")
    public void ingresoMiPassword(String password) {
        System.out.println("step: ingreso mi clave " + password);
    }

    @Then("hago clic en el boton iniciar sesion")
    public void hagoClicEnElBotonIniciarSesion() {
        System.out.println("step: clic boton iniciar sesion");
        
    }

    @And("muestra la pagina principal")
    public void muestraLaPaginaPrincipal() {
        System.out.println("step: muestra la pagina principal");
    }

    @And("no muestra la pagina principal")
    public void noMuestraLaPaginaPrincipal() {
        System.out.println("step: NOO muestra la pagina principal");
    }

    @And("deberia ver los siguientes menus")
    public void deberiaVerLosSiguientesMenus(List<String> menus) {
        for (String menu : menus){
            System.out.println("menu: " + menu);
        }
    }

    @When("me registro con")
    public void meRegistroCon(Map<String, String> data) {
        data.forEach((String key, String value) -> {
            System.out.println("clave: " + key + " - valor: " + value);
        });

    }
/**
    @When("me registro usando")
    public void meRegistroUsando(Persona persona) {
        System.out.println("Persona: ");
        System.out.println("nombre: " + persona.getNombre());
        System.out.println("apellidos: " + persona.getApellidos());
        System.out.println("telefono: " + persona.getTelefono());
        System.out.println("direccion: " + persona.getDireccion());
        System.out.println("dni: " + persona.getDni());
    }*/

@When("me registro usando")
public void meRegistroUsando(List<Persona> personas) {
    for (Persona persona : personas) {
        System.out.println("Persona: ");
        System.out.println("nombre: " + persona.getNombre());
        System.out.println("apellidos: " + persona.getApellidos());
        System.out.println("telefono: " + persona.getTelefono());
        System.out.println("direccion: " + persona.getDireccion());
        System.out.println("dni: " + persona.getDni());
        System.out.println("----");
    }
}

    @DataTableType
    public Persona convertToPersona(Map<String, String> data) {
        Persona persona = new Persona();
        persona.setNombre(data.get("nombre"));
        persona.setApellidos(data.get("apellidos"));
        persona.setTelefono(data.get("telefono"));
        persona.setDireccion(data.get("direccion"));
        persona.setDni(data.get("dni"));
        return persona;
    }

    @Then("deberia ver sus terminos de aceptacion")
    public void deberiaVerSusTerminosDeAceptacion(String data) {
        System.out.println("términos de aceptación: \n" + data);
    }
}
