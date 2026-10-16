package org.EasyProblems;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

public class Streams_and_Mapping {
    record Book(String title, String genre, int pages) {}
    record Car(String type, String make, String model, Integer engineCapacity) {}

    List<Book> books = List.of(
            new Book("Dune", "SciFi", 612),
            new Book("Neuromancer", "SciFi", 271),
            new Book("The Hobbit", "Fantasy", 310),
            new Book("Eragon", "Fantasy", 509),
            new Book("Clean Code", "Tech", 464),
            new Book("Refactoring", "Tech", 448),
            new Book("Kafka on the Shore", "Fiction", 505)
    );

    List<Car> cars = List.of(
            new Car("sedan", "BMW", "530", 1998),
            new Car("sedan", "Audi", "A5", 1998),
            new Car("sedan", "Mercedes", "E-Class", 2500),
            new Car("hatchback", "Skoda", "Octavtia", 1600),
            new Car("hatchback", "Toyota", "TypeR", 1450)
    );

    void main() {
        // List<String> of titles of all Fantasy and SciFi books with more than 300 pages, in uppercase, sorted alphabetically.
        /**
         * Explanation in my own words:
         * You need to stream( Stream is like a sushi train, go through every sushi)
         * then filter ( REMEMBER filter the Object before you turn it into a string or whadeva)
         * in the filter use a lamda because its pretty, then map you take the Book because we first have the Object and then we basically turn it into the tyoe of title and then we map the type of title again toUpperCase
         * then you need to sort: the Comparator is the Judge and the Judge says you go first and you go last
         * **/
        List<String> bigBooks = books.stream()
                .filter(book -> (book.genre().equals("Fantasy") || book.genre().equals("SciFi")) && book.pages() > 300)
                .map(Book::title)
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .toList();

        System.out.println(bigBooks);

        // Map<String, Integer> with the genre as key and the total pages as value. Hint: Collectors.summingInt.
        Map<String, Integer> pagesPerGenre = books.stream()
                .collect(Collectors.groupingBy(Book::genre, Collectors.summingInt(Book::pages)));

        System.out.println(pagesPerGenre);

        //CARS ---------------------------

        List<Car> seadnCars = cars.stream().filter(car -> car.type.equals("sedan")).toList();
        List<Car> seadnCars1 = cars.stream().filter(car -> car.type().equals("sedan")).toList();

        System.out.println(seadnCars);
        System.out.println(seadnCars1);

        List<String> carMakeModelList = cars.stream().flatMap(c -> Stream.of(c.make, c.model)).toList();  // FLATMAP: you can flatten 2 strings into 1


        //Divides into 2 logical groups, then you can call all false or all true always a bool and a list
        Map<Boolean, List<Car>> partitionedCars = cars.stream()
                .collect(
                        partitioningBy(car -> car.type.equals("sedan"))
                );


        List<Car> sedans = partitionedCars.get(true);

    }
}



