package pl.andrzejjozefow.schooldiary.model;

import lombok.Getter;

@Getter
public class BaseDTO {

  private final Integer id;

  public BaseDTO(final Integer id) {
    this.id = id;
  }
}
