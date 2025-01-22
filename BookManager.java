import java.util.List;
import java.util.Scanner;

public class BookManager {
    public static void listAllBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void searchBooksByAuthor(Scanner scanner, List<Book> books) {
        System.out.print("Digite o nome do autor: ");
        String author = scanner.nextLine();
        books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .forEach(System.out::println);
    }

    public static void searchBooksByGenre(Scanner scanner, List<Book> books) {
        System.out.print("Digite o gênero: ");
        String genre = scanner.nextLine();
        books.stream()
                .filter(book -> book.getGenre().toLowerCase().contains(genre.toLowerCase()))
                .forEach(System.out::println);
    }

    public static void searchBooksByYear(Scanner scanner, List<Book> books) {
        System.out.print("Digite o ano de publicação: ");
        int year = scanner.nextInt();
        books.stream()
                .filter(book -> book.getPublishedYear() == year)
                .forEach(System.out::println);
    }
}
