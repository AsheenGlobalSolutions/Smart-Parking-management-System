package lk.ijse.userservice.service;

import lk.ijse.userservice.dto.UserDTO;

public interface UserService {
    int addUser(UserDTO user);
    int updateUser(UserDTO user);
    int deleteUser(String email);
    UserDTO getUser(String email);
    boolean userExists(String email);
    UserDTO getUserByEmail(String email);
}
