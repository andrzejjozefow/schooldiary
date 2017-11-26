package pl.andrzejjozefow.schooldiary.model;

public class BaseDTO {

  private final Integer id;

  public BaseDTO(final Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }
}
