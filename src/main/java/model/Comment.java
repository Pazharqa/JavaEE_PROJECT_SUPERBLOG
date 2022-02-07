package model;

public class Comment {
    private Long id;
    private String comment;
    private Long authorID;
    private Long blogID;

    public Comment(){}

    public Comment(Long id, String comment, Long authorID, Long blogID) {
        this.id = id;
        this.comment = comment;
        this.authorID = authorID;
        this.blogID = blogID;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public Long getBlogID() {
        return blogID;
    }

    public void setBlogID(Long blogID) {
        this.blogID = blogID;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", authorID=" + authorID +
                ", blogID=" + blogID +
                '}';
    }
}
