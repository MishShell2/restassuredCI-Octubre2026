Feature: Login

  Scenario: Como usuario quiero ingresar un email y password para registrasr usuarios
    Given que tengo acceso a facebook
     When me registro usando
       | nombre    | apellidos  | telefono | direccion | dni        |
       | juan      | perez      | 23432    | peru      | 32424      |
       | luis      | venegas    | 5354     | peru      | 6465       |
       | marcos    | lopez      | 6564     | peru      | 64654654   |
Then muestra la pagina principal
