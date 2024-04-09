package br.com.pitang.carsapi.shared.domain.specification;

public interface Specification<T> {

  boolean isSatisfiedBy(T t);
}