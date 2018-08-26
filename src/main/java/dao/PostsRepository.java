package dao;

import model.Post;
import model.PostDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class PostsRepository {

    public static final String DATE_TIME_FORMAT = "yyyy.MM.dd HH:mm:ss";

    Map <Integer, Post> posts = new HashMap<>();
    TreeMap<String, List <PostDTO>> tags = new TreeMap<>(String::compareTo);
    TreeMap<LocalDate, List <PostDTO>> dates = new TreeMap<>(LocalDate::compareTo);

    public boolean addPost(Post post){
        boolean res = posts.putIfAbsent(post.getId(), post) == null;
        if(res){
            addTags(post);
            addDate(post);
        }
        return res;
    }

    private void addDate(Post post) {
        dates.merge(LocalDate.from(post.getDateCreated()), new ArrayList<>(Arrays.asList(post)), (oldV, newV) -> {
            oldV.add(post);
            return oldV;
        });
    }

    private void addTags(Post post) {
        for (String tag : post.getTags()) {
            tags.merge(tag, new ArrayList<PostDTO>(Arrays.asList(post)), (oldV, newV) -> {
                oldV.add(post);
                return oldV;
            });
        }
    }

    public List<PostDTO> getByTag(String tag){
        return tags.get(tag);
    }

    public List<PostDTO> getByDate(LocalDate date){
        return dates.get(date);
    }

    public Post getPost(int id){
        return posts.get(id);
    }

}
