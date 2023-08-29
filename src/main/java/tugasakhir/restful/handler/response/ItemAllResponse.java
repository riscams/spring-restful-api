package tugasakhir.restful.handler.response;

import lombok.Data;

@Data
public class ItemAllResponse {
    private int itemId;
    private String itemCode;
    private String itemName;
    private Integer itemQty;
}
