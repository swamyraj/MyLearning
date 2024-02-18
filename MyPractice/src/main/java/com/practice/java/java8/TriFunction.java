package com.practice.java.java8;

import java.util.Objects;
import java.util.function.Function;

public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);

	default <X> TriFunction<T, U, V, X> andThen(Function<R, X> after) {
		Objects.requireNonNull(after);
		return (T t, U u, V v) -> after.apply(apply(t, u, v));

	}
}
