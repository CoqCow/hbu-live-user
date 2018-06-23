package com.hbu.live.user.controller;

import com.hbu.live.user.req.LoginReq;
import com.hbu.live.user.req.Token;
import com.hbu.live.user.exception.InvalidLoginInfoException;
import com.hbu.live.user.exception.JWTTokenExpiredException;
import com.hbu.live.user.exception.JWTTokenInvalidException;
import com.hbu.live.user.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class TokenController {

    @Autowired
    private TokenService tokenService;


    @RequestMapping(path = "/tokens", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createToken(@RequestBody @Validated LoginReq loginReq)
            throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            System.out.println("执行到这里了吗");//
            Token token = tokenService.createToken(loginReq);
            return ResponseEntity.ok(token);
        } catch (InvalidLoginInfoException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResultModel(ReturnMsg.EMAIL_OF_PASSWORD_ERROR, "/tokens [POST]"));
        }
    }


    @RequestMapping(path = "/tokens/refresh", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity refreshToken(@RequestParam(name = "oldToken") String oldToken)
            throws UnsupportedEncodingException {

        try {
            Token token = tokenService.refreshToken(oldToken);
            return ResponseEntity.ok(token);

        } catch (JWTTokenExpiredException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResultModel(ReturnMsg.TOKEN_EXPIRED, "tokens/refresh"));
        } catch (JWTTokenInvalidException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ResultModel(ReturnMsg.TOKEN_INVALID, "tokens/refresh"));
        }
    }

}
