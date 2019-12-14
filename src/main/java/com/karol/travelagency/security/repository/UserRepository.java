package com.karol.travelagency.security.repository;


import com.karol.travelagency.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User findByEmail(String email);

    @Query("select count(u)>0 from User u where u.username =?1")
    boolean checkIfNameExists(String username);

}
