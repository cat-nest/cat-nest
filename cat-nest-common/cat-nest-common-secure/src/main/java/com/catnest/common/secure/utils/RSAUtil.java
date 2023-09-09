package com.catnest.common.secure.utils;

import com.catnest.common.secure.entity.KeyPairEntity;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Slf4j
public class RSAUtil {


    /**
     * 密钥长度 于原文长度对应 以及越长速度越慢
     */
    private final static int KEY_SIZE = 1024;

    /**
     * 加密算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 245;
    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 256;


    public static KeyPairEntity generaterKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey aPrivate = keyPair.getPrivate();

        PublicKey aPublic = keyPair.getPublic();

        return new KeyPairEntity(encryptBase64(aPrivate.getEncoded()), encryptBase64(aPublic.getEncoded()));
    }


    private static String encryptBase64(byte[] key) {
        return Base64.getEncoder().encodeToString(key);
    }

    private static byte[] decryptBase64(String key) throws IOException {
        return Base64.getDecoder().decode(key);
    }

    /**
     * 获取公钥
     */
    public static PublicKey getPublicKey(String publicKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException {
        byte[] publicKeyByte = decryptBase64(publicKeyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyByte);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }


    /**
     * 获取私钥
     */
    public static PrivateKey getPrivateKey(String privateKeyString) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] privateKeyByte = decryptBase64(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }


    /**
     * 加密工具
     *
     * @param plainText    需要加密内容
     * @param publicKeyStr 公钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, String publicKeyStr) throws Exception {

        byte[] plainTextArray = plainText.getBytes();
        PublicKey publicKey = getPublicKey(publicKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        int inputLen = plainTextArray.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        int i = 0;
        byte[] cache;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(plainTextArray, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(plainTextArray, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptText = out.toByteArray();
        out.close();
        return Base64.getEncoder().encodeToString(encryptText);
    }


    /**
     * 解密工具
     *
     * @param encryptTextHex 解密
     * @param privateKeyStr  私钥
     * @return 解密明文
     */
    public static String decrypt(String encryptTextHex, String privateKeyStr) throws Exception {
        byte[] encryptText = Base64.getDecoder().decode(encryptTextHex);
        PrivateKey privateKey = getPrivateKey(privateKeyStr);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        int inputLen = encryptText.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptText, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptText, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        out.close();
        return out.toString();
    }


}
