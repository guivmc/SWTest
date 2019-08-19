package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
    User findById(long id);
    User findByIdentifierLikeAndPasswordLike(String identifier, String password);
}
