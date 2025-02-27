package it.ex.scalartes_be.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Grado implements Comparable<Grado> {
    // Dal 3A al 5C
    GRADO_3A("3A", 1), GRADO_3B("3B", 2), GRADO_3C("3C", 3),
    GRADO_4A("4A", 4), GRADO_4B("4B", 5), GRADO_4C("4C", 6),
    GRADO_5A("5A", 7), GRADO_5B("5B", 8), GRADO_5C("5C", 9),

    // Dal 6A al 6C+
    GRADO_6A("6A", 10), GRADO_6A_PLUS("6A+", 11),
    GRADO_6B("6B", 12), GRADO_6B_PLUS("6B+", 13),
    GRADO_6C("6C", 14), GRADO_6C_PLUS("6C+", 15),

    // Dal 7A al 7C+
    GRADO_7A("7A", 16), GRADO_7A_PLUS("7A+", 17),
    GRADO_7B("7B", 18), GRADO_7B_PLUS("7B+", 19),
    GRADO_7C("7C", 20), GRADO_7C_PLUS("7C+", 21),

    // Dal 8A al 8C+
    GRADO_8A("8A", 22), GRADO_8A_PLUS("8A+", 23),
    GRADO_8B("8B", 24), GRADO_8B_PLUS("8B+", 25),
    GRADO_8C("8C", 26), GRADO_8C_PLUS("8C+", 27),

    // Dal 9A al 9B+
    GRADO_9A("9A", 28), GRADO_9A_PLUS("9A+", 29),
    GRADO_9B("9B", 30), GRADO_9B_PLUS("9B+", 31);

    private final String livello;
    private final int ordine;

    Grado(String livello, int ordine) {
        this.livello = livello;
        this.ordine = ordine;
    }

    public String getLivello() {
        return livello;
    }

    public int getOrdine() {
        return ordine;
    }

    @Override
    public String toString() {
        return livello;
    }

    public static Grado fromString(String text) {
        for (Grado g : Grado.values()) {
            if (g.livello.equalsIgnoreCase(text)) {
                return g;
            }
        }
        throw new IllegalArgumentException("Grado non valido: " + text);
    }

    public static List<Grado> getGradiOrdinati() {
        return Arrays.stream(Grado.values())
                .sorted(Comparator.comparingInt(Grado::getOrdine))
                .toList();
    }
}
