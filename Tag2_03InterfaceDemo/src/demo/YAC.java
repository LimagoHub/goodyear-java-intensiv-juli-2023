package demo;
public interface YAC<T> {

    boolean eq(T other);
    boolean lt(T other);

    default boolean le(T other) {
        return eq(other) || lt(other);
    }

    static YAC<?> create() {
        return null;
    }
}
