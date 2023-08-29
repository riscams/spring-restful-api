package tugasakhir.restful.handler.response;


import lombok.Data;

@Data
public class ItemResponse {
  private String status;
  private int statusCode;
  private String resultMessage;
}
