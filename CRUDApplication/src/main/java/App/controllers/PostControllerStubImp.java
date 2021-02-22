//package App.controllers;
//
//import App.model.Post;
//import App.services.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//public class PostControllerStubImp {
//    @Autowired
//    private PostService postService;
//
//    //method to read all entities
//    @GetMapping("/posts")
//    public List<Post> viewAll(){
//        return postService.findAll();
//    }
//
//    //method to read a specific entity operation
//    @GetMapping("/posts/view/{id}")
//    public Post view(@PathVariable("id") Long id) {
//        Post post = postService.findById(id);
//        if(post == null){
//            throw  new IllegalStateException("no posts found");
//        }
//        return post;
//    }
//
//    //method to Delete
//    @DeleteMapping("/posts/delete/{id}")
//    public String  delete(@PathVariable("id") Long id) {
//        postService.deleteById(id);
//        return "true";
//    }
//
//    //method to update
//    @PutMapping(value = "/posts/edit/{id}")
//    public String editPost(@RequestBody Post post, @PathVariable("id")Long id){
//        Post updatePost = postService.edit(post, id);
//        return "post updated";
//    }
//
//    //method to create
//    @PostMapping(value = "/posts/create")
//    public String createPost(@RequestBody Post post){
//        Post createPost = postService.create(post);
//        return "created";
//    }
//
//}
