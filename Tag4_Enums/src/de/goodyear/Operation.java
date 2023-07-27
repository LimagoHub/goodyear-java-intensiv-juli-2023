package de.goodyear;

public enum Operation {

    ADDIEREN,
    SUBTRAHIEREN,
    MULTIPLIZIERIEN,

    DIVIDIEREN;

    public double calculate(double x, double y) {
        return switch (this) {
            case ADDIEREN -> x +y;
            case SUBTRAHIEREN -> x -y;
            case MULTIPLIZIERIEN -> x *y;
            case DIVIDIEREN -> x /y;

        };
    }
}
