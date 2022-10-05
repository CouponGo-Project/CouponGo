package com.coupongo.business.Services;

import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.Users.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    Result addUser(User user);
    DataResult<User> deleteUser(int userId);
    DataResult<User> updateUser();

}
