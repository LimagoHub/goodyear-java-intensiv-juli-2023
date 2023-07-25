package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;


public class Main {
    public static void main(String[] args) throws Exception{

        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JoachimWagner\\git\\goodyear\\goodyear-java-intensiv-juli-2023\\UebungDienstag\\src\\resource\\Hello.txt"))){
            reader.lines()
                    .collect(Collectors.joining("\n"))
                    .chars()
                .mapToObj(i->(char) i)
                .collect(groupingBy(Function.identity(), counting()))
                .forEach((k,v)-> System.out.printf("Anzahl '%s' ist %s.%n", k,v));
        }


//        var path = Path.of("C:\\Users\\JoachimWagner\\git\\goodyear\\goodyear-java-intensiv-juli-2023\\UebungDienstag\\src\\resource\\Hello.txt");
//        Files.readString(path)
//                .chars()
//                .mapToObj(i->(char) i)
//                .collect(groupingBy(Function.identity(), counting()))
//                .forEach((k,v)-> System.out.printf("Anzahl '%s' ist %s.%n", k,v));
//        ;



    }
}