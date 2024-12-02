package com.xpe.projetoaplicado.crypto.library.service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.PublicKey;

public class EncryptService {

    public byte[] encryptWith3DES(String data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data.getBytes());
    }

    public byte[] encryptWithRSA(byte[] data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }
}