package com.hbu.live.user.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hbu.live.user.HbuLiveUserApplication;
import com.hbu.live.user.req.LoginReq;
import com.hbu.live.user.req.Token;
import com.hbu.live.user.exception.InvalidLoginInfoException;
import com.hbu.live.user.exception.JWTTokenExpiredException;
import com.hbu.live.user.exception.JWTTokenInvalidException;
import com.hbu.live.user.model.User;
import com.hbu.live.user.repository.UserRepository;
import com.hbu.live.user.util.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;


/**
 * Created by sun on 03/01/2018.
 */
@Service
public class TokenService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HbuLiveUserApplication.Config config;


    public Token createToken(LoginReq loginReq)
            throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidLoginInfoException, UnsupportedEncodingException {
        User user = userRepository.findUserByUserId(1);

        if (user == null || !PasswordHash.validatePassword(loginReq.password, user.getPassword())) {
            throw new InvalidLoginInfoException();
        }

        userRepository.save(user);

        String token = createToken(user.getUserId(), user.getNumber()+"");

        return new Token(token, user.getUserId());
    }



    public DecodedJWT validateToken(String token)
            throws UnsupportedEncodingException, JWTTokenExpiredException, JWTTokenInvalidException {
        Algorithm algorithm = Algorithm.HMAC256(config.jwtSecret);

        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            return verifier.verify(token);

        } catch (TokenExpiredException e1) {
            throw new JWTTokenExpiredException();
        } catch (JWTVerificationException e2) {
            throw new JWTTokenInvalidException();
        }
    }


    public Token refreshToken(String oldToken) throws UnsupportedEncodingException, JWTTokenExpiredException, JWTTokenInvalidException {
        DecodedJWT decodedJWT = validateToken(oldToken);

        Integer userId = decodedJWT.getClaim("userId").asInt();
        User user = userRepository.findUserByUserId(userId);

        String token = createToken(userId, user.getNumber()+"");
        return new Token(token, userId);
    }


    private String createToken(long userId, String email)
            throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(config.jwtSecret);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);

        return JWT.create()
                .withIssuer("user_module")
                .withExpiresAt(calendar.getTime())
//                .withIssuedAt(new Date())
                .withClaim("userId", userId)
                .withClaim("email", email)
                .sign(algorithm);
    }


}
