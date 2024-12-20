package com.xpe.projetoaplicado.crypto.library.application;

import com.xpe.projetoaplicado.crypto.library.service.CryptographyService;

public class CryptographyFacade {

    private final CryptographyService service = new CryptographyService();

    public CryptographyFacade() throws Exception {
    }

    public String encrypt(String data) throws Exception {
        return service.encrypt(data);
    }

    public String decrypt(String data) throws Exception {
        return service.decrypt(data);
    }
}
