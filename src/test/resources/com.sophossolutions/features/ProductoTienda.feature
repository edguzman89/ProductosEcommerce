Feature: Búsqueda y filtro de productos en la tienda
  Yo Como usuario,
  Quiero buscar productos en la tienda, filtrarlos por categoría agregarlos al carrito de compras
  para realizar una compra posterior.

  @Scenario1
  Scenario: Filtrar productos por categoría
    Given que el usuario está en la página de búsqueda de productos
    When el usuario hace clic en la opcion Laptops de la seleccion de categorias
    Then el sistema muestra productos como un Sony vaio i5 que pertenecen a la categoría seleccionada

  @Scenario1
  Scenario Outline: Agregar un producto al carrito desde los resultados de búsqueda por nombre
    Given que el usuario realiza una búsqueda por categoria <categoria> y ve los resultados de productos
    When el usuario hace clic sobre el producto <producto> para agregar
    And luego el usuario hace clic en el botón Agregar al carrito del producto visualizado
    Then el sistema muestra el mensaje Product added de confirmación que el producto fue agregado exitosamente
    And se visualiza el articulo <producto> agregado en el carrito de compras

    Examples:
      | categoria | producto          |
      | Phones    | Nexus 6           |
      | Laptops   | MacBook air       |
      | Monitors  | Apple monitor 24  |



