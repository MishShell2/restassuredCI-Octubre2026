Feature: Login

  Scenario: Como usuario quiero ingresar un email y password para registrasr usuarios
    Given que tengo acceso a facebook
     When me registro con
        | nombre    | carlos |
        | apellidos | perez  |
        | telefono  | 123    |
        | direccion | peru   |
        | dni       | 23232  |
Then muestra la pagina principal
