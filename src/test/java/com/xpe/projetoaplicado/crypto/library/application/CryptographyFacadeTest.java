//package com.xpe.projetoaplicado.crypto.library.application;
//
//import com.xpe.projetoaplicado.crypto.library.service.CryptographyService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class CryptographyFacadeTest {
//
//    @Mock
//    private CryptographyService cryptographyService;
//
//    @InjectMocks
//    private CryptographyFacade cryptographyFacade;
//
//    @Test
//    public void shouldEncrypt() throws Exception {
//        String inputData = "test-data";
//
//        String result = cryptographyFacade.encrypt(inputData);
//
//        assertNotNull(result);
//    }
//
//    @Test
//    public void shouldDecrypt() throws Exception {
//        String encryptedData = "eRLPzCNwu2tt8Q4cWoADm4C4XuZU/zc2rlTzxTc0ObCDZDUODKlK/fi3keIT4MdrAnXXd+UEUASbGgMnl+U2Vg==";
//        String decryptedData = "test-data";
//
//        Mockito.when(cryptographyService.encrypt(encryptedData)).thenReturn(decryptedData);
//        Mockito.when(cryptographyService.decrypt(encryptedData)).thenReturn(decryptedData);
//
//        String result = cryptographyFacade.decrypt(encryptedData);
//
//        assertEquals(decryptedData, result);
//    }
//
//    @Test
//    public void shouldEncryptWithError() throws Exception {
//        String inputData = "test-data";
//        Mockito.when(cryptographyService.encrypt(inputData)).thenThrow(new Exception("Encryption error"));
//
//        Exception exception = assertThrows(Exception.class, () -> {
//            cryptographyFacade.encrypt(inputData);
//        });
//        assertEquals("Encryption error", exception.getMessage());
//    }
//
//    @Test
//    public void shouldDecryptWithError() throws Exception {
//        String encryptedData = "encrypted-test-data";
//        Mockito.when(cryptographyService.decrypt(encryptedData)).thenThrow(new Exception("Decryption error"));
//
//        Exception exception = assertThrows(Exception.class, () -> {
//            cryptographyFacade.decrypt(encryptedData);
//        });
//        assertEquals("Decryption error", exception.getMessage());
//    }
//
//}