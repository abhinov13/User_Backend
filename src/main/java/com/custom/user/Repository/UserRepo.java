package com.custom.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.custom.user.Model.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
}
