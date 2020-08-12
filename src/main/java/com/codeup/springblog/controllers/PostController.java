package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PostController {

    private final UserRepository users;
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao, UserRepository users) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.users = users;
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

//    ==== OLD WAY =======

// This gives the user the VIEW to edit the post
//    @GetMapping("/posts/{id}/edit")
//    public String showEditPage(@PathVariable long id, Model model) {
//        Post postToShow = postDao.getOne(id);
//        model.addAttribute("postToShow", postToShow);
//        return "posts/edit";
//    }

//    GetMapping Edit Form-Model-Binding
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
//        we're sending this into our view
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }


//    @PostMapping("/posts/{id}/edit")
//    public String updatePost(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name ="body") String body) {
////        ====== Vivian's way
////        Post oldPost = postDao.getOne(id);
////        oldPost.setTitle(title);
////        oldPost.setBody(body);
////        postDao.save(oldPost);
//
////        ========  Justin's way
//        Post postToUpdate = new Post();
//        postToUpdate.setId(id);
//        postToUpdate.setTitle(title);
//        if(!body.isEmpty()) {
//        postToUpdate.setBody(body);
//        }
//        postDao.save(postToUpdate);
//        //After updating posts, redirecting to the endpoint that returns the view...we're calling the endpoint of /posts to re-reun the logic in the mapping and then return the view
//        return ("redirect:/posts");
//    }

//    ====Form Model Binding for PostMapping
@PostMapping("/posts/{id}/edit")
public String editPost(@PathVariable long id, @ModelAttribute Post post) {
//        TODO: change user to logged in user dynamic
        User user = userDao.getOne(3L);
        post.setParentUser(user);
        postDao.save(post);
        return "redirect:/posts";
}

    @PostMapping("/posts/delete/{id}")
    public String deletePostByTitle(@PathVariable long id) {
        postDao.deleteById(id);
        return ("redirect:/posts");
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
//    @ResponseBody
    public String createPost(@ModelAttribute Post post) {
//        User user =  userDao.getOne();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setParentUser(user);
        postDao.save(post);
        return ("redirect:/posts");
    }

}
