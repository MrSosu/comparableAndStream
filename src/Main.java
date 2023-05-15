import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> parole = Arrays.asList("java", "oracle", "develhope", "coding", "programming language", "computer science");
        // il forEach permette di definire una funzione da applicare ad ogni elemento dello stream
        // parole.stream().forEach(s -> System.out.println(s));
        parole.stream().forEach(System.out::println);
        System.out.println("-----------------------------");
        /* il filter è una operazione intermedia che permette di "filtrare" gli elementi facendo "passare" solamente quelli che
        rispettano una condizione definita tramite un predicato.
         */
        parole.stream().filter(s -> s.length() > 6).forEach(System.out::println);
        System.out.println("-----------------------");
        /*
        il map è un'altra operazione intermedia che permette di mappare ogni elemento con un altro oggetto a seconda della
        funzione che scrivo all'interno del map stesso.
         */
        List<Integer> len_parole = parole.stream().map(parola -> parola.length()).toList();
        System.out.println("le lunghezze delle parole sono: " + len_parole);
        /*
        contiamo tutte le parole che contengano il carattere 'c' nella lista
         */
        long num_parole = parole.stream().map(s -> s.toLowerCase()).filter(s -> s.contains("c")).count();
        System.out.println("Il numero di parole con la 'c' è: " + num_parole);
        System.out.println("------------------------------");
        /*
        inseriamo in un SET tutte le parole messe in maiuscolo
         */
        Set<String> parole_maiuscole = parole.stream().map(s -> s.toUpperCase()).collect(Collectors.toSet());
        System.out.println(parole_maiuscole);
        System.out.println("---------------------------------");

        /* posso usare gli stream anche sui file
        * qui per esempio salviamo dentro una lista tutte le righe del file*/
        List<String> righe_file = Files.lines(Path.of("resources/esempio.txt")).toList();
        System.out.println(righe_file);

        /* voglio salvare in una lista tutte le righe del file rese minuscole e senza punteggiatura */
        List<String> righe_pulite = Files.lines(Path.of("resources/esempio.txt")).map(s -> s.toLowerCase().replaceAll("[^A-z\\s]", "")).toList();
        System.out.println(righe_pulite);
        System.out.println("----------------------");
        /* posso anche ordinare un array con sorted() */
        List<String> parole_ordinate = parole.stream().sorted().toList();
        System.out.println(parole_ordinate);

    }

}
