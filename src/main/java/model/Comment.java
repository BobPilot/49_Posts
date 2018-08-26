package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import dao.PostsRepository;

import java.time.LocalDateTime;
import java.util.Objects;

public class Comment {

    String user;
    String message;
    @JsonFormat(pattern = PostsRepository.DATE_TIME_FORMAT)
    LocalDateTime dateCreated;
    int likes;

    public Comment() {
    }

    public Comment(String user, String message, LocalDateTime dateCreated, int likes) {
        this.user = user;
        this.message = message;
        this.dateCreated = dateCreated;
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comments = (Comment) o;
        return likes == comments.likes &&
                Objects.equals(user, comments.user) &&
                Objects.equals(message, comments.message) &&
                Objects.equals(dateCreated, comments.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, message, dateCreated, likes);
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public int getLikes() {
        return likes;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", dateCreated=" + dateCreated +
                ", likes=" + likes +
                '}';
    }
}

