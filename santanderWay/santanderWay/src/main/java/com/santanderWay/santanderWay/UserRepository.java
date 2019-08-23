package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>
{
    User findById(long id);
    User findByIdentifierLikeAndPasswordLike(String identifier, String password);
    User findByIdentifierLike(String identifier);
}
