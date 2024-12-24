package com.xpe.projetoaplicado.crypto.library.service;

import com.xpe.projetoaplicado.crypto.library.infrastructure.EncryptionConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.crypto.SecretKey;
import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CryptographyServiceTest {

    private CryptographyService cryptographyService;

    @BeforeEach
    public void setUp() throws Exception {
        cryptographyService = new CryptographyService();
    }

    @Test
    public void shouldEncryptData() throws Exception {
        String inputData = "test-data";

        String encryptedData = cryptographyService.encrypt(inputData);

        System.out.println("Encrypted Data: " + encryptedData);
        assertEquals(false, encryptedData.isEmpty());
    }

    @Test
    public void shouldDecryptData() throws Exception {
        String inputData = "test-data";

        String encryptedData = cryptographyService.encrypt(inputData);
        String decryptedData = cryptographyService.decrypt(encryptedData);

        assertEquals(inputData, decryptedData);
    }

    @Test
    public void shouldThrowExceptionOnInvalidDecryption() throws Exception {
        String invalidEncryptedData = "invalid-data";

        assertThrows(Exception.class, () -> cryptographyService.decrypt(invalidEncryptedData));
    }

    @Test
    public void shouldHandleEmptyInputForEncryption() throws Exception {
        String emptyInput = "";

        String encryptedData = cryptographyService.encrypt(emptyInput);
        String decryptedData = cryptographyService.decrypt(encryptedData);

        assertEquals(emptyInput, decryptedData);
    }

    @Test
    public void shouldUseGeneratedKeys() throws Exception {
        SecretKey desKey = EncryptionConfig.generate3DESKey();
        KeyPair rsaKeyPair = EncryptionConfig.generateRSAKeyPair();

        assertEquals(24, desKey.getEncoded().length);
        assertEquals("RSA", rsaKeyPair.getPrivate().getAlgorithm());
    }
}
