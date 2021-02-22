package App.controllers;

import App.Repository.PostRepository;
import App.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PostControllerJPAImpl {

    @Autowired
    private PostRepository postService;

    @GetMapping("/posts")
    public List<Post> retrieveAllStudents() {
        return postService.findAll();
    }



    @GetMapping("/post/view/{id}")
    public Post view(@PathVariable Long id) {
        Post post = postService.findOne(id);

        if(post == null){
            throw  new IllegalStateException("no posts found");
        }
        return post;
    }

    @DeleteMapping("/posts/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        postService.delete(id);
        return "true";
    }


    @PostMapping("/posts/create")
    public String createPost(@RequestBody Post post) {
        postService.save(post);
        return "created";

    }

    @PutMapping("/posts/edit/{id}")
    public String editPost(@RequestBody Post post, @PathVariable long id) {

    Post updatePost =  postService.findOne(id);
    updatePost.setId(id);
    postService.save(post);

     return "updated";
    }

    @GetMapping("/posts/debit/{id}/{amount}")
    public  synchronized Post debitMoney(@PathVariable long id ,@PathVariable int amount){
        Post post = postService.findOne(id);
        if(post.getBalance() >= amount) {
            post.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw " +post.getBalance() );
        }
        else {
            System.out.println("Not enough balance  in account for " + Thread.currentThread().getName() + " to withdraw");
        }
        postService.save(post);
        return post;
    }
}
