package com.fundamentos.SpringBoot.fundamentos.Repository;

import com.fundamentos.SpringBoot.fundamentos.Dto.UserDto;
import com.fundamentos.SpringBoot.fundamentos.Entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface  UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("Select u from User u WHERE u.email = ?1")
    Optional<User> findByUserEmail(String email);
    @Query("Select u from User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);

    List<User> findByNameLike(String name);

    List<User> findByNameOrEmail(String name, String email);

    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);

    //List<User> findByNameLikeOrderByIdDesc(String name);

    List<User> findByNameContainingOrderByIdDesc(String name);

    @Query("SELECT new com.fundamentos.SpringBoot.fundamentos.Dto.UserDto(u.id, u.name, u.birthDate)" +
            " FROM User u " +
            " where u.birthDate=:parameterFecha " +
            " and u.email=:parameterEmail")
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parameterFecha")LocalDate date,
                                                @Param("parameterEmail")String email);

    List<User> findAll(Sort sort);


}
