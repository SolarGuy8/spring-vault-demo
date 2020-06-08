package io.vaultproject.service;

import io.vaultproject.model.request.AddSecretRequest;

/**
 * @author Artyom Poteshkin
 */
public interface VaultService {

    void addSecret(AddSecretRequest request);

    String getSecretValue(String secretKey);
}
