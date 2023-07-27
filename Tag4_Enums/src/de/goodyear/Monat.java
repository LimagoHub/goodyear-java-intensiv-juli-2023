package de.goodyear;

public enum Monat {



    JANUAR,
    FEBRUAR(28),
    MAERZ,
    APRIL(30),
    MAI(31),
    JUNI(30),

    JULI,

    AUGUST,
    SEPTEMBER(30),

    OKTOBER,

    NOVEMBER(30),

    DEZEMBER;

    private final int days;

    Monat(final int days) {
        this.days = days;
    }

    Monat() {
        this.days = 31;
    }


    public int getDays() {
        return days;
    }
}
