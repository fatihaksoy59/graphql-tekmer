package com.example.graphqltekmer.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @MutationMapping
  public User createUser(@Argument CreateUserInput input) {
    return userService.createUser(input);
  }

  @QueryMapping
  public User user(@Argument Long id) {
    return userService.getUser(id);
  }

  @QueryMapping
  public List<User> users() {
    return userService.getAllUsers();
  }
}
