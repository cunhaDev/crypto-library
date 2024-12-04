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
}
