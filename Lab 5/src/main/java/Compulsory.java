public class Compulsory {

    public static void main(String[] args) {

        Book book1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth");
        Article article1 = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "ORACLE");

        Catalog catalog = new Catalog("Catalog name..");
        catalog.add(book1);
        catalog.add(article1);

        System.out.println(catalog);
    }
}
