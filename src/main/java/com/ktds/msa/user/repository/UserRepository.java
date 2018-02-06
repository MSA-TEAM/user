package com.ktds.msa.user.repository;

import com.ktds.msa.user.domain.User;
import org.hibernate.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String username);

}
