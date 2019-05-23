package com.example.demo.controlller;

import com.example.demo.domain.User;
import com.example.demo.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
@RequestMapping("atm-banking-system")*/
public class UserRestController extends AbstractController<User, UserService> {
    protected UserRestController(UserService service) {
        super(service);
    }
}
