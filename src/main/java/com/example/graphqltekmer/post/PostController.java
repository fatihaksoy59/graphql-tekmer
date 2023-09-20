package com.example.graphqltekmer.post;

import com.example.graphqltekmer.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @MutationMapping
  private Post createPost(@Argument CreatePostInput input) {
    return postService.createPost(input);
  }


  @BatchMapping(field = "posts", typeName = "User")
public Map<User, List<Post>> posts(@Argument List<User> ids) {
    return postService.postForUsers(ids);
  }
}
