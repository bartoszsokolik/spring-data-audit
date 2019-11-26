package pl.solutions.software.sokolik.bartosz.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort.Direction;

@Data
@AllArgsConstructor
public class CustomPageRequest {

  private int page;

  private int size;

  private Direction order;

  private String sortBy;

  public CustomPageRequest() {
    this.page = 0;
    this.size = 10;
    this.order = Direction.ASC;
    this.sortBy = "id";
  }
}
