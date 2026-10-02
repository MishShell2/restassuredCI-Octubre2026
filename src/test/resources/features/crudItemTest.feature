Feature: Item API

    @projects
  Scenario: Como usuario quiero hacer el CRUD de un item por API
    #crear
    Given que tengo acceso al API todo.ly
    When envio el POST request a la url "https://todo.ly/api/items.json" con el body
    """
    {
      "Content": "Taller03"
    }
    """
    Then el codigo de respuesta deberia ser 200
    And el nombre del item deberia ser "Taller03"
#    And el Checked del item deberia "false"
    And guardo el id del item de la variable "Id"

    #actualizar
    When envio el PUT request a la url "https://todo.ly/api/items/ITEM_ID.json" con el body
    """
    {
      "Content": "Taller03Update"
      "Checked": true
    }
    """
    Then el codigo de respuesta deberia ser 200
    And el nombre del item deberia ser "Taller03Update"
    And el Checked del item deberia "true"
#
#        leer
    When envio el GET request a la url "https://todo.ly/api/items/ITEM_ID.json"
    Then el codigo de respuesta deberia ser 200
    And el nombre del item deberia ser "Taller03Update"
    And el Checked del item deberia "true"
#
#    eliminar
    When envio el DELETE request a la url "https://todo.ly/api/items/ITEM_ID.json"
    Then el codigo de respuesta deberia ser 200
    And el nombre del item deberia ser "Taller03Update"
    And el Checked del item deberia "true"