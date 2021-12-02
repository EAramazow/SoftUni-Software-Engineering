package objectsAndClasses.Exercise.P02Articles;

public class Articles {
    private String tittle;
    private String content;
    private String author;


    public Articles (String title, String content, String author) {
        this.tittle = title;
        this.content = content;
        this.author = author;
    }

    public void edit (String newContent) {
        this.content = newContent;
    }

    public void rename (String newTitle) {
        this.tittle = newTitle;
    }

    public void changeAuthor (String newAuthor) {
        this.author = newAuthor;
    }

    @Override
    public String toString() {

        return this.tittle + " - " + this.content + ": " + this.author;
    }
}
