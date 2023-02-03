package com.example.mydata45.repository;
import com.example.mydata45.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}