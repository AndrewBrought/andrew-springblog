package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> myPosts = postDao.findAll();
        model.addAttribute("posts", myPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showBlog(@PathVariable long id, Model model) {
        User postsUser = userDao.getOne(id);
        Post myPost = postDao.getOne(id);
//        model.addAttrbute() is the same as request.setAttribute();
        model.addAttribute("email", postsUser.getEmail());
        model.addAttribute("id", myPost.getId());
        model.addAttribute("title", myPost.getTitle());
        model.addAttribute("body", myPost.getBody());
        return "posts/show";
    }

// This gives the user the VIEW to edit the post
    @GetMapping("/posts/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Post postToShow = postDao.getOne(id);
        model.addAttribute("postToShow", postToShow);
        return "posts/edit";
    }


    @PostMapping("/posts/edit/{id}")
    public String updatePost(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name ="body") String body) {
//        ====== Vivian's way
//        Post oldPost = postDao.getOne(id);
//        oldPost.setTitle(title);
//        oldPost.setBody(body);
//        postDao.save(oldPost);

//        ========  Justin's way
        Post postToUpdate = new Post();
        postToUpdate.setId(id);
        postToUpdate.setTitle(title);
        if(!body.isEmpty()) {
        postToUpdate.setBody(body);
        }
        postDao.save(postToUpdate);
        //After updating posts, redirecting to the endpoint that returns the view...we're calling the endpoint of /posts to re-reun the logic in the mapping and then return the view
        return ("redirect:/posts");
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePostByTitle(@PathVariable long id) {
        postDao.deleteById(id);
        return ("redirect:/posts");
    }

    @GetMapping("/posts/create")

    public String create() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
//    @ResponseBody
    public String insert(@RequestParam String title, @RequestParam String body) {
        User user =  userDao.getOne(1L);
        Post newPost = new Post(title, body, user);
        postDao.save(newPost);
        return ("redirect:/posts");
    }

}
