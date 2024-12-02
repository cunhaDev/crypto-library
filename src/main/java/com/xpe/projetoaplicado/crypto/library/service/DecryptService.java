package com.xpe.projetoaplicado.crypto.library.service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.PrivateKey;

public class DecryptService {

    public byte[] decryptWith3DES(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("DESede");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public byte[] decryptWithRSA(byte[] data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }
}
