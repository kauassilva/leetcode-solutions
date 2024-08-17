# 2469. Convert the Temperature

You are given a non-negative floating point number rounded to two decimal places `celsius`, that denotes the **temperature in Celsius**.

You should convert Celsius into **Kelvin** and **Fahrenheit** and return it as an array `ans = [kelvin, fahrenheit]`.

*Return the array `ans`*. Answers within `10-^5` of the actual answer will be accepted.

**Note that:**
- `Kelvin = Celsius + 273.15`
- `Fahrenheit = Celsius * 1.80 + 32.00`


**Constraints:**
- `0 <= celsius <= 1000`


[Link to the LeetCode](https://leetcode.com/problems/convert-the-temperature/description/)

## My Solution

````java
public static double[] convertTemperature(double celsius) {
    validateConvertTemperature(celsius);

    double kelvin = celsius + 273.15;
    double fahrenheit = celsius * 1.80 + 32.00;

    return new double[] {kelvin, fahrenheit};
}
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2469.java)



## Method Validation

````java
private static void validateConvertTemperature(double celsius) {
        if (celsius < 0 || celsius > 1000) {
            throw new IllegalArgumentException("expected 'celsius' to have value from 0 to 1000 only");
        }
    }
````

[Link to the document](../../java/com/kauassilva/algorithms/solutions/Solution2469.java)



### Tests

How to run the tests:

````bash
mvn test -Dtest=Solution2469Test
````

Test cases ([Link to the document](../../../test/java/com/kauassilva/algorithms/solutions/Solution2469Test.java))

| Nº | Description                                                                         |
|----|-------------------------------------------------------------------------------------|
| 1  | It should return correct values for the example 1                                   |
| 2  | It should return correct values for the example 2                                   |
| 3  | It should return correct values for the minimum input value (0)                     |
| 4  | It should return correct values for the maximum input value (1000)                  |
| 5  | It should throw IllegalArgumentException for a input below the minimum (-0.00001)   |
| 6  | It should throw IllegalArgumentException for a input above the maximum (1000.00001) |
