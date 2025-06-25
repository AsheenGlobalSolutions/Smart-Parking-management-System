package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.repo.UserRepo;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int addUser(UserDTO user) {
        if (userRepo.existsByEmail((user.getEmail()))) {
            return VarList.Not_Acceptable;
        }
        userRepo.save(modelMapper.map(user, User.class));
        return VarList.Created;
    }

    @Override
    public int updateUser(UserDTO user) {
       if (userRepo.existsByEmail(user.getEmail())) {
           userRepo.save(modelMapper.map(user, User.class));
           return VarList.OK;
       }
       return VarList.Not_Found;
    }

    @Override
    public int deleteUser(String email) {
        if (userRepo.existsByEmail(email)) {
            userRepo.deleteByEmail((email));
            return VarList.OK;
        }
        return VarList.Not_Found;
    }

    @Override
    public UserDTO getUser(String email) {
        User user = userRepo.findByEmail((email));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public boolean userExists(String email) {
        boolean exists = userRepo.existsByEmail(email);
        return exists;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO login(String email, String password) {
        userRepo.findByEmail(email);
        return modelMapper.map(userRepo.findByEmail(email), UserDTO.class);
    }
}
