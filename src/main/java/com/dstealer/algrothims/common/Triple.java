package com.dstealer.algrothims.common;

import java.util.Objects;

public class Triple<T> {
    private final T _1;
    private final T _2;
    private final T _3;

    public Triple(T _1, T _2, T _3) {
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
    }

    public T get_1() {
        return _1;
    }

    public T get_2() {
        return _2;
    }

    public T get_3() {
        return _3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triple<?> triple = (Triple<?>) o;
        return Objects.equals(_1, triple._1) &&
                Objects.equals(_2, triple._2) &&
                Objects.equals(_3, triple._3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(_1, _2, _3);
    }
}
