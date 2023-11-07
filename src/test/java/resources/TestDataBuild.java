package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.org.LoginRequest;
import pojo.org.OrderDetail;
import pojo.org.Orders;
import stepdefinations.StepDefination;

public class TestDataBuild extends Utils {

    public static Orders addOrderDetails(String country) {
        OrderDetail orderdetails = new OrderDetail();
        orderdetails.setCountry(country);
        orderdetails.setProductOrderedId(StepDefination.productId);

        List<OrderDetail> orderdetailsList = new ArrayList<OrderDetail> ();
        orderdetailsList.add(orderdetails);
        Orders orders = new Orders();
        orders.setOrders(orderdetailsList);
        return orders;
    }

    public static LoginRequest addLoginCredentials(String userEmail, String userPass) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail(userEmail);
        loginRequest.setUserPassword(userPass);
        return loginRequest;
    }
}
