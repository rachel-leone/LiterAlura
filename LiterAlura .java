import java.util.*;

public class LiterAlura {
    private static final List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        // Adicionando livros diretamente no código
        books.add(new Book("Dom Casmurro", "Machado de Assis", "Romance", 1899));
        books.add(new Book("1984", "George Orwell", "Distopia", 1949));
        books.add(new Book("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 1954));
        books.add(new Book("A Revolução dos Bichos", "George Orwell", "Sátira", 1945));

        startUserInteraction();
    }

    private static void startUserInteraction() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Catálogo LiterAlura ===");
            System.out.println("1. Listar todos os livros");
            System.out.println("2. Buscar livros por autor");
            System.out.println("3. Buscar livros por gênero");
            System.out.println("4. Livros publicados em um determinado ano");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (choice) {
                case 1 -> BookManager.listAllBooks(books);
                case 2 -> BookManager.searchBooksByAuthor(scanner, books);
                case 3 -> BookManager.searchBooksByGenre(scanner, books);
                case 4 -> BookManager.searchBooksByYear(scanner, books);
                case 5 -> {
                    System.out.println("Encerrando o programa. Até logo!");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
