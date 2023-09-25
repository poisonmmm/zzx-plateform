package com.association.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.util.Arrays;
import java.util.Objects;

public class AuthTool {

    public static final String USERNAME_Code="auth:";

    //签名
    private static final String signature="";

    //用户token生效时间
    public static final Long EFFECTIVE_TIME=60*60*3L;

    //用户名加密
    public static String toSecretUsername(String username){
        return USERNAME_Code+username;
    }

    //用户名解密
    public static String toLawUsername(String usernameAuth){
        return usernameAuth.replace(USERNAME_Code,"");
    }

    //密钥
    private static final byte[] key={16, 113, -1, 127, -104, -125, -77, -101, -112, 2, 68, -118, -116, 111, -78, -75};

    //生成密钥
    public static void main(String[] args) {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        System.out.println(Arrays.toString(key));
    }


    private static final SymmetricCrypto AES = new SymmetricCrypto(SymmetricAlgorithm.AES, key);



    //加密
    public static String value(String username){
        return value(0L,username,UserRole.USER);
    }

    //加密
    public static String value(String username,String role){
        return value(0L,username,role);
    }

    //加密
    public static String value(Long userId,String username,String role){
        //生成token时，加入两个随机数 增加结果的随机性
        String content=signature+":"+ RandomUtil.getRandom().nextInt(1,101)+","+userId+","+username+","+role+","+ RandomUtil.getRandom().nextInt(2,102);
//       String content=signature+":"+123+","+userId+","+username+","+role+","+ 123;
        return AES.encryptHex(content);
    }

    //验证
    public static boolean verify(String token){
        try {
            String sign = parseToken(token)[0].split(":")[0];
            if (!Objects.equals(sign, signature)){
                return false;
            }

            return true;
        }catch (Exception e){
            return false;
        }
    }

    //解密
    public static String[] parseToken(String token){
        String decrypt = AES.decryptStr(token);
        return decrypt.split(",");
    }

    public static String getUserIdByToken(String token){
        return parseToken(token)[1];
    }

    public static String getUsernameByToken(String token){
        return parseToken(token)[2];
    }
    public static String getRoleByToken(String token){
        return parseToken(token)[3];
    }

}
