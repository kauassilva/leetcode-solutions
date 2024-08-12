package com.kauassilva.algorithms.solutions;

/**
 * <p>
 * You are given a non-negative floating point number rounded to two decimal
 * places {@code celsius}, that denotes the <b>temperature in Celsius</b>.
 *
 * <p>
 * You should convert Celsius into <b>Kelvin</b> and <b>Fahrenheit</b> and return it as an array {@code ans = [kelvin, fahrenheit]}.
 *
 * <p>
 * <i>Return the array {@code ans}</i>. Answers within {@code 10-^5} of the actual answer will be accepted. *
 *
 * <p>
 * <b>Note that:</b>
 * <ul>
 *     <li>{@code Kelvin = Celsius + 273.15}</li>
 *     <li>{@code Fahrenheit = Celsius * 1.80 + 32.00}</li>
 * </ul>
 *
 * <p>
 * <b>Constraints:</b>
 * <ul>
 *     <li>{@code 0 <= celsius <= 1000}</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/convert-the-temperature/description/">
 *     2469. Convert the Temperature</a>
 */
public class Solution2469 {

    public static double[] convertTemperature(double celsius) {
        validateConvertTemperature(celsius);

        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;

        return new double[] {kelvin, fahrenheit};
    }

    private static void validateConvertTemperature(double celsius) {
        if (celsius < 0 || celsius > 1000) {
            throw new IllegalArgumentException("expected 'celsius' to have value from 0 to 1000 only");
        }
    }


}
