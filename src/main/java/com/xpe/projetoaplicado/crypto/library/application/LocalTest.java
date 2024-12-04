package com.xpe.projetoaplicado.crypto.library.application;

import com.xpe.projetoaplicado.crypto.library.service.CryptographyService;

public class LocalTest {

    //TODO JUST change value of this variable to test the encrypt and decrypt flow.
    static String input = "your data to encrypt";

    public static void main(String[] args) throws Exception {
        CryptographyService cryptographyFacade = new CryptographyService();

        String encryptedText = cryptographyFacade.encrypt(input);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = cryptographyFacade.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
