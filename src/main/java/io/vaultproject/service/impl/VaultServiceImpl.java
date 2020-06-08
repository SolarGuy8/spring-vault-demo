package io.vaultproject.service.impl;

import io.vaultproject.model.request.AddSecretRequest;
import io.vaultproject.service.VaultService;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

/**
 * @author Artyom Poteshkin
 */
@Component
public class VaultServiceImpl implements VaultService {

    private final VaultTemplate vaultTemplate;

    public VaultServiceImpl(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    @Override
    public void addSecret(AddSecretRequest request) {
        if (Objects.nonNull(request)) {
            vaultTemplate.write(request.getSecretKey(), "request");
        }
    }

    @Override
    public String getSecretValue(String secretKey) {
        return Optional.ofNullable(vaultTemplate.read(secretKey, String.class)).map(VaultResponseSupport::getData).orElse("");
    }
}
