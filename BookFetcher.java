import com.google.gson.*;
import java.net.http.*;
import java.net.URI;
import java.util.List;

public class BookFetcher {
    public static void fetchBooks(String apiUrl, List<Book> books) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonArray booksArray = JsonParser.parseString(response.body()).getAsJsonArray();

        for (JsonElement bookElement : booksArray) {
            JsonObject book = bookElement.getAsJsonObject();
            String title = book.get("title").getAsString();
            String author = book.get("author").getAsString();
            String genre = book.has("genre") ? book.get("genre").getAsString() : "Desconhecido";
            int year = book.has("published_year") ? book.get("published_year").getAsInt() : 0;

            books.add(new Book(title, author, genre, year));
        }

        System.out.println("Livros carregados com sucesso!");
    }
}
