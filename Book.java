public class Book {
    private final String title;
    private final String author;
    private final String genre;
    private final int publishedYear;

    public Book(String title, String author, String genre, int publishedYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Gênero: %s | Ano: %d",
                title, author, genre, publishedYear);
    }
}
