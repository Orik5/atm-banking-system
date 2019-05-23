package com.example.demo.controlller;

import com.example.demo.dto.AtmDto;
import com.example.demo.domain.User;
import com.example.demo.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    @ApiOperation(value = "Get users", response = AtmDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public void findAll() {
        userService.list();
    }

    @ApiOperation(value = "Get user by id", response = AtmDto.class)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public void findById(@PathVariable Integer id) {
        userService.findById(id);

    }

    @ApiOperation(value = "Add user", response = AtmDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.create(user);
    }

    @ApiOperation(value = "Update user", response = AtmDto.class)
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.saveOrUpdate(user);
    }

    @ApiOperation(value = "Send money to another user", response = AtmDto.class)
    @RequestMapping(value = "/users/send-to-user", method = RequestMethod.POST)
    public void sendMoneyToAnotherUser(User user, BigDecimal money) {
        userService.sendMoneyToAnotherUser(user, money);
    }

    @ApiOperation(value = "Delete user", response = AtmDto.class)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

    @ApiOperation(value = "Find by username", response = AtmDto.class)

    @RequestMapping(value = "/users/{user-name}", method = RequestMethod.GET)
    public void findByUserName(String name) {
        userService.findByName(name);
    }
}
