package com.codeup.springblog.services;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class SillySvc {

    private PostRepository postDao;
//    This constructor assigns a new instance of a postDao
    public SillySvc(PostRepository postDao) {
        this.postDao = postDao;
    }

    public int totalPostCharacters() {
//        Spring has an iterable which is a Java object, sort of like an ArrayList
        Iterable<Post> posts = postDao.findAll();
        int total = 0;
        for(Post post : posts){
            total += post.getBody().length();
        }
            return total;
    }


}
