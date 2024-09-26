package com.stfonavi.app.todo.serviceImpl;

import com.stfonavi.app.todo.JWT.CustomerUserDetailsService;
import com.stfonavi.app.todo.JWT.JwtUtil;
import com.stfonavi.app.todo.POJO.User;
import com.stfonavi.app.todo.constents.TodoConstants;
import com.stfonavi.app.todo.dao.UserDao;
import com.stfonavi.app.todo.service.UserService;
import com.stfonavi.app.todo.utils.TodoUtils;
import com.stfonavi.app.todo.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        log.info("Inside signup {}", requestMap);
        try {
            if(validateSignUpMap(requestMap)){
                User user = getUserFromMap(requestMap);
                //Validar el objeto user
                ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
                Validator validator = factory.getValidator();
                Set<ConstraintViolation<User>> violations = validator.validate(user);

                if(!violations.isEmpty()){
                    StringBuilder errorMessage = new StringBuilder();
                    for(ConstraintViolation<User> violation: violations){
                        errorMessage.append(violation.getMessage()).append(", ");
                    }
                    errorMessage.setLength(errorMessage.length()-2);
                    return TodoUtils.getResponseEntity(errorMessage.toString(),HttpStatus.BAD_REQUEST);
                }

                //Encriptamos la contraseña
                user.setPassword(passwordEncoder.encode(user.getPassword()));

                User existingUser = userDao.findByEmailId(requestMap.get("email"));
                if(Objects.isNull(existingUser)){
                    userDao.save(user);
                    return TodoUtils.getResponseEntity("Successfully Registered",HttpStatus.OK);
                }else{
                    return TodoUtils.getResponseEntity("Email already exits", HttpStatus.BAD_REQUEST);
                }
            }else{
                return TodoUtils.getResponseEntity(TodoConstants.INVALID_DATA,HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            log.error("Error during signup: {}", ex.getMessage(), ex);
            return TodoUtils.getResponseEntity(TodoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
        return null;
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> checkToken() {
        return null;
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
        return null;
    }

    @Override
    public ResponseEntity<String> forgotPassword(Map<String, String> requestMap) {
        return null;
    }

    /**
     * Metodos
     */
    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if (requestMap.containsKey("name") &&
            requestMap.containsKey("contactNumber") &&
            requestMap.containsKey("email") &&
            requestMap.containsKey("password")) {
            return true;
        }
        return false;
    }

    private User getUserFromMap(Map<String, String> requestMap) {

        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;

    }

}
