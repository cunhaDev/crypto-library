package com.xpe.projetoaplicado.crypto.library.application;

import com.xpe.projetoaplicado.crypto.library.service.CryptographyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CryptographyFacadeTest {

    private CryptographyService cryptographyService;
    private CryptographyFacade cryptographyFacade;

    @BeforeEach
    public void setUp() throws Exception {
        cryptographyFacade = new CryptographyFacade();

        cryptographyService = mock(CryptographyService.class);

        Field serviceField = CryptographyFacade.class.getDeclaredField("service");
        serviceField.setAccessible(true);
        serviceField.set(cryptographyFacade, cryptographyService);
    }

    @Test
    public void shouldEncrypt() throws Exception {
        String inputData = "test-data";
        String expectedEncryptResult = "eno5GHVvXBXZ/d7V4bbRaSxy8+mqX/7nhmYlTFR8GqsSFVGZ6w4D9u+lBvnUAdf+P6kLIEl4tc/5+oLZnxNqmQ==";
        when(cryptographyService.encrypt(inputData)).thenReturn(expectedEncryptResult);
        String result = cryptographyFacade.encrypt(inputData);
        assertEquals(expectedEncryptResult, result);
        verify(cryptographyService, times(1)).encrypt(inputData);
    }

    @Test
    public void shouldDecrypt() throws Exception {
        String decryptResult = "test-data";
        String encryptResult = "eno5GHVvXBXZ/d7V4bbRaSxy8+mqX/7nhmYlTFR8GqsSFVGZ6w4D9u+lBvnUAdf+P6kLIEl4tc/5+oLZnxNqmQ==";
        when(cryptographyService.decrypt(encryptResult)).thenReturn(decryptResult);
        String result = cryptographyFacade.decrypt(encryptResult);
        assertEquals(decryptResult, result);
        verify(cryptographyService, times(1)).decrypt(encryptResult);
    }

    @Test
    public void shouldEncryptWithError() throws Exception {
        String inputData = "test-data";
        when(cryptographyService.encrypt(inputData)).thenThrow(new Exception("Encryption error"));

        Exception exception = assertThrows(Exception.class, () -> {
            cryptographyFacade.encrypt(inputData);
        });
        assertEquals("Encryption error", exception.getMessage());
    }

    @Test
    public void shouldDecryptWithError() throws Exception {
        String encryptedData = "encrypted-test-data";
        when(cryptographyService.decrypt(encryptedData)).thenThrow(new Exception("Decryption error"));

        Exception exception = assertThrows(Exception.class, () -> {
            cryptographyFacade.decrypt(encryptedData);
        });
        assertEquals("Decryption error", exception.getMessage());
    }

}