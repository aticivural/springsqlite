package com.database.dao;

import com.database.model.User;

/**
 * Created by vural on 19-Jan-17.
 */
public interface UserRepository {

    User getUserById(Integer id);
}
