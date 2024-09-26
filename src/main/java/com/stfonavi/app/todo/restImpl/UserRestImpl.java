package com.stfonavi.app.todo.restImpl;

import com.stfonavi.app.todo.constents.TodoConstants;
import com.stfonavi.app.todo.rest.UserRest;
import com.stfonavi.app.todo.service.UserService;
import com.stfonavi.app.todo.utils.TodoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        try{
            return userService.signUp(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return TodoUtils.getResponseEntity(TodoConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try{
            return userService.login(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return TodoUtils.getResponseEntity(TodoConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
