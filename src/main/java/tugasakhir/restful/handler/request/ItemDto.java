package tugasakhir.restful.handler.request;


import lombok.Data;

@Data
public class ItemDto {
  private String itemCode;
  private String itemName;
  private int itemQty;
}
