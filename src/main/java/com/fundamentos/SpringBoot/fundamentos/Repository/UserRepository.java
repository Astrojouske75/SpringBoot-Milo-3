package com.fundamentos.SpringBoot.fundamentos.Repository;

import com.fundamentos.SpringBoot.fundamentos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
