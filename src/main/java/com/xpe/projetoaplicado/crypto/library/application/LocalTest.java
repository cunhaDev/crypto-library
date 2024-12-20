package com.xpe.projetoaplicado.crypto.library.application;

public class LocalTest {

    static String input = "your data to encrypt";

    public static void main(String[] args) throws Exception {
        CryptographyFacade cryptographyFacade = new CryptographyFacade();

        String encryptedText = cryptographyFacade.encrypt(input);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = cryptographyFacade.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
