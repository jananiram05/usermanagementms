package com.tekarch.userManagementMs.services.interfaces;



import com.tekarch.userManagementMs.models.Account;
import com.tekarch.userManagementMs.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user); // Create a new user
    Optional<User> getUserById(Long id); // Retrieve a user by ID
    List<User> getAllUsers(); // Get all users
    User updateUser(Long id, User user); // Update user details
    void deleteUser(Long id); // Delete user by ID
    User updateKYCStatus(Long id, String kycStatus);// Update KYC Status

    Account createAccount(Long userId,Account account);
    List<Account>getAccountByUserId(Long userId);
}

