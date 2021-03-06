package com.example.demo.controlller;

import com.example.demo.domain.User;
import com.example.demo.dto.AtmDto;
import com.example.demo.domain.Atm;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.EmptyBallanceException;
import com.example.demo.exception.IncorrectUserNameException;
import com.example.demo.exception.RangeNotSatisfiableException;
import com.example.demo.service.impl.AtmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashSet;

@RestController
@RequestMapping("atm-banking-system")
@Api(value = "atm-banking-system")

public class AtmController {

    @Autowired(required = true)
    @Qualifier("atmService")
    private AtmService atmService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully l list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @ApiOperation(value = "withdraw", response = AtmDto.class)
    @RequestMapping(value = "/atms/withdraw", method = RequestMethod.PUT)
    public void withdraw(HashSet<Atm> atms, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, IncorrectUserNameException {
        atmService.withdraw(atms, money, users, name);
    }

    @ApiOperation(value = "put-cash-into", response = AtmDto.class)
    @RequestMapping(value = "/atms/put-cash-into", method = RequestMethod.PUT)
    public void putCashIntoAtm(HashSet<Atm> atms, BigDecimal money, HashSet<User> users, String name) throws RangeNotSatisfiableException, EmptyBallanceException, IncorrectUserNameException {
        atmService.putCashIntoAtm(atms, money, users, name);
    }


}
