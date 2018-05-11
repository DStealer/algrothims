package com.dstealer.algrothims.common;

import java.util.Objects;

public class Pair<T> {
    private final T _1;
    private final T _2;

    public Pair(T _1, T _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public T get_1() {
        return _1;
    }

    public T get_2() {
        return _2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(_1, pair._1) &&
                Objects.equals(_2, pair._2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_1, _2);
    }
}
