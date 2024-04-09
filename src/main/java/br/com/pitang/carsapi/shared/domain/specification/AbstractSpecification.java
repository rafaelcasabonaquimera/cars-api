package br.com.pitang.carsapi.shared.domain.specification;

import br.com.pitang.carsapi.shared.domain.exception.GenericSpecificationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractSpecification<T> implements Specification<T> {

  private String message;

  public void check(T t) throws GenericSpecificationException {
    boolean isValid = isSatisfiedBy(t);
    if (!isValid) {
      throw new GenericSpecificationException(this.getMessage());
    }
  }

}
