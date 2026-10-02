Feature: Login
  Scenario Outline: Como usuario quiero ingresar un email y password para iniciar sesion
    Given que tengo acceso a facebook
     When ingreso mi email: <email>
      And ingreso mi password: "<password>"
     Then hago clic en el boton iniciar sesion
      And muestra la pagina principal

    Examples:
    | email | password |
    | usuario1@gmail.com | admin123 |
    | usuario2@gmail.com | admin143 |
    | usuario3@gmail.com | admin126 |