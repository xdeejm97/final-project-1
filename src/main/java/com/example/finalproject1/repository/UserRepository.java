package com.example.finalproject1.repository;

import com.example.finalproject1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //List<User> findall();
    User save(User entity);

    void delete(User aLong);
    User findById(long id);
}
