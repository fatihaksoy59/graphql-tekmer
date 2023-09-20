package com.example.graphqltekmer.user;

import graphql.GraphQLException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User createUser(CreateUserInput input) {
    User user = User.builder().name(input.name()).birthDate(input.birthDate()).build();
    return userRepository.save(user);
  }

  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
