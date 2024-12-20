package com.xpe.projetoaplicado.crypto.library.service;

import com.xpe.projetoaplicado.crypto.library.infrastructure.EncryptionConfig;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Base64;

public final class CryptographyService {

    private final EncryptService encryptService = new EncryptService();
    private final DecryptService decryptService = new DecryptService();

    private final SecretKey desKey;
    private final KeyPair rsaKeyPair;

    public CryptographyService() throws Exception {
        this.desKey = EncryptionConfig.generate3DESKey();
        this.rsaKeyPair = EncryptionConfig.generateRSAKeyPair();
    }

    public String encrypt(String input) throws Exception {
        byte[] encrypted3DES = encryptService.encryptWith3DES(input, desKey);
        byte[] encryptedRSA = encryptService.encryptWithRSA(encrypted3DES, rsaKeyPair.getPublic());
        return Base64.getEncoder().encodeToString(encryptedRSA);
    }

    public String decrypt(String encryptedData) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedRSA = decryptService.decryptWithRSA(encryptedBytes, rsaKeyPair.getPrivate());
        byte[] decrypted3DES = decryptService.decryptWith3DES(decryptedRSA, desKey);
        return new String(decrypted3DES);
    }
}