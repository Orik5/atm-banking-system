package com.example.demo.controlller;

import com.example.demo.domain.Atm;
import com.example.demo.dto.AtmDto;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashSet;

@RestController
@RequestMapping("atm-banking-system")
@Api(value = "atm-banking-system")
public class UserController {
    @Autowired
    UserService userService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully l list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ApiOperation(value = "Get users", response = UserDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public void findAll() {
        userService.list();

    }

    @ApiOperation(value = "Get user by id", response = UserDto.class)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public void findById(@PathVariable Integer id) {
        userService.findById(id);

    }

    @ApiOperation(value = "Add user", response = UserDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.create(user);
    }

    @ApiOperation(value = "Update user", response = UserDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
    }

    @ApiOperation(value = "Send money to another user", response = UserDto.class)
    @RequestMapping(value = "/users/send-to-user", method = RequestMethod.PUT)
    public void sendMoneyToAnotherUser(User user, BigDecimal money, HashSet<User> users, String myName, String username) {
        userService.sendMoneyToAnotherUser(money, users, myName, username);
    }

    @ApiOperation(value = "Delete user", response = UserDto.class)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }


}
