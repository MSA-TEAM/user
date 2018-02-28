package com.ktds.msa.user.repository;

import java.util.Optional;
//import org.hibernate.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ktds.msa.user.domain.User;

@Repository
public interface UserRepository2 extends CrudRepository<User, Long> {
    
	Optional<User> userInfo(String tenant_id, String cp_cd, String email_id);

}
