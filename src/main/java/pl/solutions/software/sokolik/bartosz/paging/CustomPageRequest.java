package pl.solutions.software.sokolik.bartosz.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import java.util.Optional;

@Data
@AllArgsConstructor
public class CustomPageRequest {

  private int page;

  private int size;

  private Direction order;

  private String sortBy;

  public CustomPageRequest(Integer page, Integer size, SortDirection sortDirection, String sortBy) {
    this.order = Optional.ofNullable(sortDirection.getDirection()).orElse(SortDirection.asc.getDirection());
    this.sortBy = Optional.ofNullable(sortBy).orElse("id");
    this.page = Optional.ofNullable(page).map(p -> Math.max(0, p - 1)).orElse(0);
    this.size = Math.max(1, Optional.ofNullable(size).orElse(1));
  }

  public CustomPageRequest() {
    this.page = 0;
    this.size = 10;
    this.order = Direction.ASC;
    this.sortBy = "id";
  }

  public Pageable toPageable() {
    return PageRequest.of(
            page,
            size,
            order,
            sortBy
    );
  }
}
