package com.kauassilva.algorithms.solutions;

public class Solution2469 {

    public double[] convertTemperature(double celsius) {
        validateConvertTemperature(celsius);

        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;

        return new double[] {kelvin, fahrenheit};
    }

    private void validateConvertTemperature(double celsius) {
        if (celsius < 0 || celsius > 1000) {
            throw new IllegalArgumentException("expected 'celsius' to have value from 0 to 1000 only");
        }
    }


}
