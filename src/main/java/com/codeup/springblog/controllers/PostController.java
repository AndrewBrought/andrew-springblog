package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> myPosts = postDao.findAll();
        model.addAttribute("posts", myPosts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showBlog(@PathVariable long id, Model model) {
        Post myPost = postDao.getOne(id);
//        model.addAttrbute() is the same as request.setAttribute();
        model.addAttribute("id", myPost.getId());
        model.addAttribute("title", myPost.getTitle());
        model.addAttribute("body", myPost.getBody());
        return "posts/show";
    }


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

//        ========  Old way
        Post postToUpdate = new Post();
        postToUpdate.setId(id);
        postToUpdate.setTitle(title);
        postToUpdate.setBody(body);
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
    @ResponseBody
    public String create() {
        return "Here is the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insert() {
        return "Post has been created!";
    }

}
