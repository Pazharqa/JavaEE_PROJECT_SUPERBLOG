package db;

import model.Blog;
import model.Comment;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static Connection connection;

    public static void connectToDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog_project?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("DB connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUserByEmail(String email){
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet res = statement.executeQuery();
            if (res.next()){
                user = new User(res.getLong("id"), res.getString("login"), res.getString("password"), res.getString("email"), res.getString("full_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void addNewUser(User user){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users values (null, ?, ?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFullname());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void editUser(User user){
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET login = ?, password = ?, email = ?, full_name = ? WHERE id = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFullname());
            statement.setLong(5, user.getId());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBlog(Blog blog){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO blogs values (null, ?, ?, ?)");
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getText());
            statement.setLong(3, blog.getAuthor_id());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List <Blog> getAllBlogs() {
        List <Blog> blogList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM blogs ORDER BY id desc");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("text");
                Long author_id = resultSet.getLong("author_id");
                blogList.add(new Blog(id, title, text, author_id));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return blogList;
    }

    public static String authorNameByBlogID(Long id){
        String authorName = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT u.full_name FROM users u JOIN blogs b ON b.author_id = u.id WHERE b.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                authorName = resultSet.getString("full_name");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return authorName;
    }

    public static void addComment(Comment comment){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO comments VALUES (null, ?, ?, ?)");
            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getAuthorID());
            statement.setLong(3, comment.getBlogID());
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Comment> getCommentsByBlogID(Long blogID){
        List <Comment> comments = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments WHERE blog_id = ? ORDER BY id desc");
            statement.setLong(1, blogID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String comment = resultSet.getString("comment");
                Long authorID = resultSet.getLong("author_id");
                comments.add(new Comment(id, comment, authorID, blogID));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static List<Blog> getBlogsBySearchWord(String searchWord) {
        List<Blog> blogList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM blogs WHERE title LIKE '%" + searchWord + "%' ORDER BY id DESC");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String content = result.getString("text");
                Long authorId = result.getLong("author_id");
                blogList.add(new Blog(id, title, content, authorId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return blogList;
    }

    public static String userNameByCommentID(Long id){
        String userName = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT u.login FROM users u JOIN comments c ON c.author_id = u.id WHERE c.id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                userName = resultSet.getString("login");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }
}
