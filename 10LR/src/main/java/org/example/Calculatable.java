package org.example;

import java.util.Locale;

public interface Calculatable {
     int number = 0;

    double calculateArea();

    double calculatePerimeter();

    static String format(double value) {
        return String.format(Locale.ROOT, "%.2f", value);
    }
}
