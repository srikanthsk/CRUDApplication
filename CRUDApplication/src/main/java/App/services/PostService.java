package App.services;

import App.model.Post;

import java.util.List;

public interface PostService {
    //read
    List<Post> findAll();
    List<Post> findLatest5();
    //read by ID
    Post findById(Long id);
    //create
    Post create(Post post);
    //update
    Post edit(Post post,Long id);
    //delete
    void deleteById(Long id);

}
