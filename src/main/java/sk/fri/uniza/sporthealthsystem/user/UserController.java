package sk.fri.uniza.sporthealthsystem.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sk.fri.uniza.sporthealthsystem.user.entity.ResponseUser;
import sk.fri.uniza.sporthealthsystem.user.entity.User;
import sk.fri.uniza.sporthealthsystem.user.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController  {

    protected UserService service;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/email/{email}")
    @ResponseBody
    @Transactional(readOnly = true)
    public ResponseUser getUserByEmail(@PathVariable String email) {
        logger.info("User with email + " + email + " is being searched");
        return this.service.buildResponseUser(this.service.findByEmail(email));
    }

    @PostMapping("/signUp")
    @Transactional
    public @ResponseBody
    ResponseUser signUp(@RequestBody User user) {
        User newUser = this.service.signUp(user);
        if (newUser == null) {
            return null;
        }
        logger.trace("user created with email + " + newUser.getEmail());
        return this.service.buildResponseUser(newUser);
    }

    @PostMapping("/avatar")
    @Transactional
    public ResponseUser uploadAvatarToUser(
            @RequestParam("email") String email,
            @RequestParam("replace") boolean replace,
            @RequestParam("file") MultipartFile file
    ) {
        return this.service.buildResponseUser(this.service.saveAvatarToUser(email, file, replace));
    }
}

