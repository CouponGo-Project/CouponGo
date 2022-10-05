package com.coupongo.business.ServiceImpl;

import com.coupongo.business.Services.UserService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.core.utilities.results.SuccessDataResult;
import com.coupongo.core.utilities.results.SuccessResult;
import com.coupongo.dataAccess.UserRepos.UserRepo;
import com.coupongo.entities.Users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserRepo userRepo;

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepo.findAll(),"User Listelendi");
    }

    @Override
    public Result addUser(User user) {
        this.userRepo.save(user);
        return new SuccessResult("User Eklendi");
    }

    @Override
    public DataResult<User> deleteUser(int userId) {
        this.userRepo.deleteById(userId);
        return new SuccessDataResult<>("The User with number: " + userId + " is deleted.");
    }

    @Override
    public DataResult<User> updateUser() {
        return null;
    }
}
