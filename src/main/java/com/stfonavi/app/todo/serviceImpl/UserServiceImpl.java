package com.stfonavi.app.todo.serviceImpl;

import com.stfonavi.app.todo.service.UserService;
import com.stfonavi.app.todo.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        return null;
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
}
