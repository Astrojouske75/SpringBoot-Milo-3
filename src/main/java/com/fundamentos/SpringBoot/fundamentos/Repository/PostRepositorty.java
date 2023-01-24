package com.fundamentos.SpringBoot.fundamentos.Repository;

import com.fundamentos.SpringBoot.fundamentos.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositorty extends JpaRepository<Post, Long> {
}
