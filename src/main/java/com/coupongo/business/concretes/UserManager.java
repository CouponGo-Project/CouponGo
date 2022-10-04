package com.coupongo.business.concretes;

import com.coupongo.business.abstracts.UserService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.abstracts.UserDao;
import com.coupongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"User Listelendi");
    }

    @Override
    public Result addUser(User user) {
        this.userDao.save(user);
        return new SuccessResult("User Eklendi");
    }

    @Override
    public DataResult<User> deleteUser(int userId) {
        this.userDao.deleteById(userId);
        return new SuccessDataResult<>("The User with number: " + userId + " is deleted.");
    }

    @Override
    public DataResult<User> updateUser() {
        return null;
    }
}
