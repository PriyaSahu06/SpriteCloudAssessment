package API_Testing.pojo;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PlaceOrder {
    Long id;
    Long petId;
    int quantity;
    String shipDate;
    boolean complete;
    String status;
}