package com.example.demo.controlller;

import com.example.demo.dto.AtmDto;
import com.example.demo.entity.Atm;
import com.example.demo.service.impl.AtmServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("atm-banking-system")
@Api(value = "atm-banking-system")

public class AtmContoller {


    @Autowired
    private AtmServiceImpl atmService;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully l list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ApiOperation(value = "Get atm by id", response = AtmDto.class)
    @RequestMapping(value = "/atm's/{id}", method = RequestMethod.GET)
    public void findById(Integer id) {
        atmService.findById(id);

    }

    @ApiOperation(value = "Updaye atm", response = AtmDto.class)
    @RequestMapping(value = "/atm's", method = RequestMethod.PUT)
    public void updateAtm(Atm atm) {
        atmService.saveOrUpdate(atm);
    }

    @ApiOperation(value = "withdraw", response = AtmDto.class)
    @RequestMapping(value = "/atm's/withdraw", method = RequestMethod.POST)
    public void withdraw(Atm atm, BigDecimal money) {
        atmService.withdraw(atm, money);
    }

    @ApiOperation(value = "put-cash-into", response = AtmDto.class)
    @RequestMapping(value = "/atm's/put-cash-into", method = RequestMethod.POST)
    public void putCashIntoAtm(Atm atm, BigDecimal money) {
        atmService.putCashIntoAtm(atm, money);
    }


}
