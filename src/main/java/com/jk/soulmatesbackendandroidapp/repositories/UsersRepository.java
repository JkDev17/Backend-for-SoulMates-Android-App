package com.jk.soulmatesbackendandroidapp.repositories;

import com.jk.soulmatesbackendandroidapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

}
