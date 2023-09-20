package com.example.graphqltekmer.post;

import com.example.graphqltekmer.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  List<Post> findByUserIn(List<User> ids);
}
