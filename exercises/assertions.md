# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. ‘3 * .4’ ne sera pas exactement égale à 1.2 mais à une approximation inexacte
         (1.2000000000000002).
         Pour cela, il faut utiliser ‘assertEquals(expected,actual,epsilon)’ qui correspond à l’assertion suivante : `Math.abs(expected - actual) <= epsilon`
         Cela permet de ne pas avoir d’erreur d’approximation dans l’assert, et de fixer sa propre échelle de métrique.


2. ‘assertSame’ : Affirme que deux Objets font référence au même objet en mémoire (obj1 == obj2 en java). S'ils ne sont pas identiques, une ‘AssertionError’ sans message est lancée.
   ‘assertEquals’ : assure que les deux objets référencés ont le même contenu (obj1.equals(obj2) en java).       
    Même résultat : 
    
   ```java 
    String s1 = new String("hello");
    String s2 = s1;
    assertEquals(s1, s2); // -> true
    assertSame(s1, s2);   // -> true
    ```
   
    Pas le même résultat :
    ```java
   String s1 = new String("hello");
    String s2 = new String("hello");
    assertEquals(s1, s2); // -> true
    assertSame(s1, s2);   // -> false
    ```
   

3. On peut utiliser la méthode fail pour un test qui n’est pas encore écrit.
    ```java
   @Test
    public void exercice3() {
        fail("function not yet implemented");
    }
    ```
   
4. Je pense que le code est plus lisible en utilisant la méthode assertThrow.
   Et cela rejoint la logique des autres méthodes (assertTrue, assertEquals, …)

