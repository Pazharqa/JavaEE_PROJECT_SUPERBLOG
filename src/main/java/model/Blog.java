package model;

public class Blog {
    private Long id;
    private String title;
    private String text;
    private Long author_id;

    public Blog(){}

    public Blog(Long id, String title, String text, Long author_id) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author_id = author_id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
