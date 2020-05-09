import Models.Author;

public class Main {
    public static void main(String[] args) {
        fillData();
        show();
    }

    private static void fillData() {
        DataService DataService = new DataService();
        DataService.addBook(1, "Java for dummies");
        DataService.addBook(2, "JavaScript for web");
        DataService.addBook(3, "Easy Pyton!");

        Author author1 = new Author("Arthur Doyle", "Scientific");
        author1.addBook(DataService.getBook(1));
        author1.addBook(DataService.getBook(3));
        DataService.addAuthor(author1);

        Author author2 = new Author("Mark Twain", "Scientific, Sci-Fi");
        author2.addBook(DataService.getBook(2));
        author2.addBook(DataService.getBook(3));
        DataService.addAuthor(author2);

        Author author3 = new Author("Charles Dickens", "Educational");
        author3.addBook(DataService.getBook(1));
        DataService.addAuthor(author3);

        Author author4 = new Author("Agatha Christie", "Scientific, Educational");
        author4.addBook(DataService.getBook(2));
        DataService.addAuthor(author4);

        Author author5 = new Author("Jane Austen", "Educational, Sci-Fi, Comics");
        author5.addBook(DataService.getBook(1));
        DataService.addAuthor(author5);

        DataService.close();
    }

    private static void show() {
        DataService DataService = new DataService();
        System.out.println("All authors of " + DataService.getBook(1).getTitle() + ":\n"
                + DataService.getAuthorsByBook(DataService.getBook(1).getTitle()).toString());
        System.out.println("All books of author " + DataService.getAuthor("Arthur Doyle").getName() + ":\n"
                + DataService.getBookByAuthor("Arthur Doyle").toString());
        DataService.close();
    }
}