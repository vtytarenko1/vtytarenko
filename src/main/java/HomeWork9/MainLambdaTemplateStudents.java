package HomeWork9;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();

        // 1. Вивести список (List) всіх фруктів в яких є вітамін С або вітамін А
        List<Fruit> fruitsWithVitaminCOrA = fruits.stream()
                .filter(fruit -> fruit.getVitamins().contains(Vitamin.C) || fruit.getVitamins().contains(Vitamin.A))
                .collect(Collectors.toList());

        System.out.println("Фрукти з вітамінами C або A:");
        fruitsWithVitaminCOrA.forEach(System.out::println);

        // 2. Вивести список без повторів (Set), усіх вітамінів в алфавітному порядку
        Set<Vitamin> uniqueVitamins = fruits.stream()
                .flatMap(fruit -> fruit.getVitamins().stream())
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("\nСписок унікальних вітамінів в алфавітному порядку:");
        uniqueVitamins.forEach(System.out::println);

        // 3. Вивести мапу з типом фрукта як ключ, з найдешевшими фруктами. Тобто якщо дві груші, то в якості value буде дешевша груша
        Map<FruitType, Fruit> cheapestFruitsMap = fruits.stream()
                .collect(Collectors.toMap(
                        Fruit::getFruitType,
                        fruit -> fruit,
                        (existingFruit, newFruit) -> existingFruit.getPrice() < newFruit.getPrice() ? existingFruit : newFruit
                ));

        System.out.println("\nМапа з типом фрукта як ключ і найдешевшими фруктами:");
        cheapestFruitsMap.forEach((fruitType, fruit) -> System.out.println(fruitType + ": " + fruit));

        // 4. Знайти три фрукта з найбільшим часом зберігання
        List<Fruit> topThreeLongestStorageFruits = fruits.stream()
                .sorted(Comparator.comparingInt(Fruit::getDayToLive).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\nТри фрукта з найбільшим часом зберігання:");
        topThreeLongestStorageFruits.forEach(System.out::println);

        // 5. Знайти скільки фруктів кожного типу ми маємо
        Map<FruitType, Long> fruitTypeCountMap = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType, Collectors.counting()));

        System.out.println("\nКількість фруктів кожного типу:");
        fruitTypeCountMap.forEach((fruitType, count) -> System.out.println(fruitType + ": " + count));

        // 6. Вивести мапу з типом фрукта як ключ, з списком відповідних фруктів. Тобто якщо дві груші, то в якості value буде ліст з цих двох груш
        Map<FruitType, List<Fruit>> fruitTypeFruitsMap = fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitType));

        System.out.println("\nМапа з типом фрукта як ключ і списком відповідних фруктів:");
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
