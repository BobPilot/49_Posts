package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Post;
import model.PostDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Appl {

    public static ObjectMapper om = new ObjectMapper();

    public static void main (String[] args) throws IOException {

        om.findAndRegisterModules();
        om.registerSubtypes(Post.class);
        String files = "src/Post.json";
        List <PostDTO> posts = getPosts(files);

        System.out.println(posts.get(0));

    }

    private static List <PostDTO> getPosts(String files) throws IOException {

//        List <PostDTO> posts = new ArrayList<>();
//        for (int i = 0; i < files.length; i++){
//            String json = readFile(files[i]);
//            System.out.println(json);
//            posts.add(om.readValue(json, new TypeReference<Post>(){}));
//        }
//
//

        return om.readValue(readFile(files), new TypeReference<List<Post>>(){});
    }

    private static String readFile(String path) {
        StringBuilder res = new StringBuilder();
        String line;
        try ( BufferedReader br = new BufferedReader(new FileReader(new File(path)))){

            while((line = br.readLine()) != null){
                res.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(res.toString());
        return res.toString();
    }

}
