package com.xpe.projetoaplicado.crypto.library.application;

import com.xpe.projetoaplicado.crypto.library.service.CryptographyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CryptographyFacade {

    private CryptographyService service;

    public String encrypt(String data) throws Exception {
        return service.encrypt(data);
    }

    public String decrypt(String data) throws Exception {
        return service.decrypt(data);
    }

//TODO class to test encrypt and decrypt methods
//    public static void main(String[] args) throws Exception {
//        CryptographyService cryptographyFacade = new CryptographyService();
//
//        String encryptedText = cryptographyFacade.encrypt("test-data");
//        System.out.println("Encrypted Text: " + encryptedText);
//
//        String decryptedText = cryptographyFacade.decrypt(encryptedText);
//        System.out.println("Decrypted Text: " + decryptedText);
//    }
}
