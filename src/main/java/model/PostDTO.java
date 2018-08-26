package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import java.util.List;
import java.util.Objects;

@JsonTypeInfo(use = Id.CLASS)
public class PostDTO {

    int id;
    String title;
    String content;
    String autor;
    List<String> tags;

    public PostDTO() {
    }

    public PostDTO(int id, String title, String content, String autor, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.autor = autor;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", autor='" + autor + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return id == postDTO.id &&
                Objects.equals(title, postDTO.title) &&
                Objects.equals(content, postDTO.content) &&
                Objects.equals(autor, postDTO.autor) &&
                Objects.equals(tags, postDTO.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, autor, tags);
    }
}
