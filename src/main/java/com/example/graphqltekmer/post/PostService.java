package com.example.graphqltekmer.post;

import com.example.graphqltekmer.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public Post createPost(CreatePostInput input) {
    Post post =
        Post.builder()
            .title(input.title())
            .content(input.content())
            .user(User.builder().id(input.userId()).build())
            .build();
    return postRepository.save(post);
  }

  public Map<User, List<Post>> postForUsers(List<User> ids) {

    List<Post> postsForUsers = postRepository.findByUserIn(ids);
    return ids.stream()
        .collect(
            Collectors.toMap(
                Function.identity(),
                book ->
                    new ArrayList<>(
                        postsForUsers.stream()
                            .filter(post -> post.getUser().getId().equals(book.getId()))
                            .toList())));
  }
}
