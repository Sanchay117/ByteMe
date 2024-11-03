package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Food, Integer> cart = new HashMap<>();
    private String deliveryDetail;
    private String paymentDetail;
    private String status;
    private LocalDateTime orderDate;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private int price;

    public Order(Map<Food,Integer> cart,String deliveryDetail, String paymentDetail, String status) {
        this.cart = cart;
        this.deliveryDetail = deliveryDetail;
        this.paymentDetail = paymentDetail;
        this.status = status;

        orderDate = LocalDateTime.now();

        for(Map.Entry<Food, Integer> entry : cart.entrySet()) {
            price += entry.getValue()*entry.getKey().getPrice();
        }
    }

    public String getStatus(){
        return status;
    }

    public Map<Food, Integer> getCart(){
        return cart;
    }

    @Override
    public String toString() {
        return dtf.format(orderDate) + " ₹" + price + " " + deliveryDetail + "[address] " + paymentDetail + "[payment] " +status + "[status]";
    }
}
