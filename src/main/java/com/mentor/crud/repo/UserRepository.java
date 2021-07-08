package com.mentor.crud.repo;

import com.mentor.crud.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @EntityGraph(attributePaths = {"roles"})
    @Query("SELECT u FROM User u where u.userName =:userName")
    User findByUserName(String userName);
}
