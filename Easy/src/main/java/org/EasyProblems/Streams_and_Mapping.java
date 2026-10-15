package org.EasyProblems;

import java.util.Comparator;
import java.util.List;

public class Streams_and_Mapping {
    List<Book> books = List.of(
            new Book("Dune", "SciFi", 612),
            new Book("Neuromancer", "SciFi", 271),
            new Book("The Hobbit", "Fantasy", 310),
            new Book("Eragon", "Fantasy", 509),
            new Book("Clean Code", "Tech", 464),
            new Book("Refactoring", "Tech", 448),
            new Book("Kafka on the Shore", "Fiction", 505)
    );

    void main(){
        // List<String> of titles of all Fantasy and SciFi books with more than 300 pages, in uppercase, sorted alphabetically.
        /**
         * Explanation in my own words:
         * You need to stream( Stream is like a sushi train, go through every sushi)
         * then filter ( REMEMBER filter the Object before you turn it into a string or whadeva)
         * in the filter use a lamda because its pretty, then map you take the Book because we first have the Object and then we basically turn it into the tyoe of title and then we map the type of title again toUpperCase
         * then you need to sort: the Comparator is the Judge and the Judge says you go first and you go last
         * **/
        List<String> bigBooks = books.stream().filter(book -> (book.genre()
                .equals("Fantasy") || book.genre().equals("SciFi")) && book.pages() > 300)
                .map(Book::title).map(String::toUpperCase)
                .sorted(Comparator.naturalOrder()).toList();
        System.out.println(bigBooks);

    }
}

record Book(String title, String genre, int pages) {}

