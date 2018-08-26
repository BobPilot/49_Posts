package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dao.PostsRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Post extends PostDTO{

    @JsonFormat(pattern = PostsRepository.DATE_TIME_FORMAT)
    LocalDateTime dateCreated;
    List<String> tags;
    int likes;
    Comment[] comments;

    public Post() {
    }

    public Post(int id, String title, String content, String autor, List<String> tags, LocalDateTime dateCreated, List<String> tags1, int likes) {
        super(id, title, content, autor, tags);
        this.dateCreated = dateCreated;
        this.tags = tags1;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public List<String> getTags() {
        return tags;
    }

    public int getLikes() {
        return likes;
    }

    public Comment[] getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }

    public void addComment(Comment comment){
        //TODO
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", autor='" + autor + '\'' +
                ", dateCreated=" + dateCreated +
                ", tags=" + tags +
                ", likes=" + likes +
                ", comments=" + Arrays.toString(comments) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                likes == post.likes &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(autor, post.autor) &&
                Objects.equals(dateCreated, post.dateCreated) &&
                Objects.equals(tags, post.tags) &&
                Arrays.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, content, autor, dateCreated, tags, likes);
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }

}
