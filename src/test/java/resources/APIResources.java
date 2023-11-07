package resources;

public enum APIResources {
    AddProductAPI("/api/ecom/product/add-product"),
    CreateOrderAPI("/api/ecom/order/create-order"),
    DeleteOrderAPI("/api/ecom/product/delete-product/{productId}"),
    LoginAPI("/api/ecom/auth/login");

    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
