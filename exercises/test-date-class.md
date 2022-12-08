# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

Explication des tests :

| Test | Explication |
|:------------------------------:|-------------|
| Date(1, 12, 2024) |   cette date existe  |
| Date(31, 9, 2024) |  cette date n’existe pas (wrong day)|
| Date(24, 13, 2024) | cette date n’existe pas (wrong month)|
|  Date(29, 2, 2022) | cette date n’existe pas (not a leap  year)|
|  Date(29, 2, 2024)  | cette date existe (leap year)|
|   isLeapYear(2024) == true)   | “2024” est une année bisextile|
|   isLeapYear(2022) == false)  | “2022” est une année bisextile|
|  Date(1, 12, 2024).nextDate()	| “2/12/2024” existe	|
|  Date(28, 2, 2024).nextDate() |”29/02/2024” existe 	|
| Date(28, 2, 2025).nextDate()	|”29/02/2025” n’existe pas	|
| Date(2, 12, 2024).previousDate()|”1/12/2024” n’existe pas	|
|Date(1, 1, 2024).previousDate()	|”31/12/2023” n’existe pas	|
|Date(1, 3, 2024).previousDate()|”29/02/2024” existe	|
|Date(1, 3, 2025).previousDate()	|”28/02/2025” n’existe pas	|

Et en plus, on a testé sur 1000 jours consécutifs si la date est correcte en partant du 1er janvier 1970.

4. Avec ces tests, on obtient un score de 84% de mutants tués (76 sur 90) :
   ![alt image mutant test](./mutant_tests2.png)





