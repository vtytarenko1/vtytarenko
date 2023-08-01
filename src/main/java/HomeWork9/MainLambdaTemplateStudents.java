package HomeWork9;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();

        // 1. Display a list of all fruits that contain vitamin C or vitamin A
        List<Fruit> fruitsWithVitaminCOrA = fruits.stream()
                .filter(fruit -> fruit.getVitamins().contains(Vitamin.C) || fruit.getVitamins().contains(Vitamin.A))
                .collect(Collectors.toList());

        System.out.println("Fruit with vitamins C or A: ");
        fruitsWithVitaminCOrA.forEach(System.out::println);

        // 2. Display a list without repetitions (Set) of all vitamins in alphabetical order
        Set<Vitamin> uniqueVitamins = fruits.stream()
                .flatMap(fruit -> fruit.getVitamins().stream())
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("\nList of unique vitamins in alphabetical order: ");
        uniqueVitamins.forEach(System.out::println);

        // 3. Output a map with the type of fruit as the key, with the cheapest fruits. That is, if there are two pears, the value will be the cheaper pear
        Map<FruitType, Fruit> cheapestFruitsMap = fruits.stream()
                .collect(Collectors.toMap(
                        Fruit::getFruitType,
                        fruit -> fruit,
                        (existingFruit, newFruit) -> existingFruit.getPrice() < newFruit.getPrice() ? existingFruit : newFruit
                ));

        System.out.println("\nMap with fruit type as key and cheapest fruits: ");
        cheapestFruitsMap.forEach((fruitType, fruit) -> System.out.println(fruitType + ": " + fruit));

        // 4. Find the three fruits with the longest storage time
        List<Fruit> topThreeLongestStorageFruits = fruits.stream()
                .sorted(Comparator.comparingInt(Fruit::getDayToLive).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nThree fruits with the longest storage time: ");
        topThreeLongestStorageFruits.forEach(System.out::println);

        // 5. Find how many fruits of each type we have
        Map<FruitType, Long> fruitTypeCountMap = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType, Collectors.counting()));

        System.out.println("\nNumber of fruits of each type: ");
        fruitTypeCountMap.forEach((fruitType, count) -> System.out.println(fruitType + ": " + count));

        // 6. Output a map with the type of fruit as the key, with a list of matching fruits. That is, if there are two pears, then the value will be a sheet of these two pears
        Map<FruitType, List<Fruit>> fruitTypeFruitsMap = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType));

        System.out.println("\nMap with fruit type as key and list of matching fruits: ");
        fruitTypeFruitsMap.forEach((fruitType, fruitList) -> System.out.println(fruitType + ": " + fruitList));
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(FruitType.APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(List.of(Vitamin.B, Vitamin.C));
        fruits.add(fruit);

        fruit = new Fruit(FruitType.STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(List.of(Vitamin.A, Vitamin.C));
        fruits.add(fruit);

        // Додайте інші фрукти

        return fruits;
    }
}
