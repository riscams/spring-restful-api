package tugasakhir.restful.entities;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {
  private Date createdDate;
  private Date updatedDate;
}
