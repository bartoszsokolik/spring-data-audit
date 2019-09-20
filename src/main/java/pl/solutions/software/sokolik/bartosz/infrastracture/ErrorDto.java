package pl.solutions.software.sokolik.bartosz.infrastracture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto implements AbstractDto {

  private int code;

  private String message;
}
