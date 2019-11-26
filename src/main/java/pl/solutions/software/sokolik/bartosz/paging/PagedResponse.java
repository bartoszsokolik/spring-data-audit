package pl.solutions.software.sokolik.bartosz.paging;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Data
@NoArgsConstructor
public class PagedResponse<T> {

  private int totalPages;

  private long totalElements;

  private List<T> content;

  private int numberOfElements;

  private int size;

  private int pageNumber;

  public PagedResponse(Page<T> page) {
    this.totalPages = page.getTotalPages();
    this.totalElements = page.getTotalElements();
    this.content = page.getContent();
    this.numberOfElements = page.getNumberOfElements();
    this.size = page.getSize();
    this.pageNumber = page.getNumber();
  }
}
