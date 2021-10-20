package com.example.authserver.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.authserver.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
//    private static final  String TOKEN_SECRET = "jiami";
    private static final  long TIME_OUT = 86400;  //单位:S

    public static String encode(User user) {
        Algorithm algorithm = Algorithm.HMAC256(user.getPassword());

        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        String token = JWT.create()
                .withHeader(header)
                //设置过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + TIME_OUT))
                //设置负载
                .withAudience(user.getUsername())
                .sign(algorithm);
        return token;
    }
//    public static Map<String, String> decode(String token) throws Exception {
//        DecodedJWT jwt = null;
//        Map<String, Claim> map;
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
//            jwt = verifier.verify(token);
//            map=jwt.getClaims();
//        } catch (Exception e) {
//            throw new Exception("鉴权失败");
//        }
//        Map<String, String> resultMap = new HashMap<>(map.size());
//        map.forEach((k, v) -> resultMap.put(k, v.asString()));
//        return resultMap;
//    }
}
