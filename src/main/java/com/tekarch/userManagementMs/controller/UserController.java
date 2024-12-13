package com.tekarch.userManagementMs.controller;



import com.tekarch.userManagementMs.models.Account;
import com.tekarch.userManagementMs.models.User;
import com.tekarch.userManagementMs.services.interfaces.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("Received request to create user");
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        logger.info("Received request to fetch user by ID: {}", id);
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        logger.info("Received request to fetch all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("Received request to update user with ID: {}", id);
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        logger.info("Received request to delete user with ID: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/kyc")
    public ResponseEntity<User> updateKYCStatus(@PathVariable Long id, @RequestParam String kycStatus) {
        logger.info("Received request to update KYC status for user ID: {}", id);
        return ResponseEntity.ok(userService.updateKYCStatus(id, kycStatus));
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Account> createAccount(@PathVariable Long userId, @RequestBody Account account) {
        logger.info("Received request to create an account for user ID: {}", userId);
        return ResponseEntity.ok(userService.createAccount(userId, account));
    }

    @GetMapping("/{userId}/accounts")
    public ResponseEntity<List<Account>> getAccountsByUserId(@PathVariable Long userId) {
        logger.info("Received request to fetch accounts for user ID: {}", userId);
        return ResponseEntity.ok(userService.getAccountByUserId(userId));
    }
}

