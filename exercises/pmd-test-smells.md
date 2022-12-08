# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

En utilisant le fichier DetachedTestCase.md à l’aide de PMD, on peut repérer les méthodes de test qui n’ont pas d’annotation @Test ou @Ignore.
Par exemple, dans le fichier :  
**commons-collections\src\test\java\org\apache\commons\collections4\IterableUtilsTest.java**,
la fonction de test getFromIterable ne possède pas d’annotation (ligne 337).

```java
public void getFromIterable() throws Exception {
        // Collection, entry exists
        final Bag<String> bag = new HashBag<>();
        bag.add("element", 1);
        assertEquals("element", IterableUtils.get(bag, 0));
    }
```

Pour corriger cela, on ajoute l’annotation @Test si c’est un test ou @Ignore si on veut ignorer le test.
