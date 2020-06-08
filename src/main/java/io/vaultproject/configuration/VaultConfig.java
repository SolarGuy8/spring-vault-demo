package io.vaultproject.configuration;

import java.net.URI;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

/**
 * @author Artyom Poteshkin
 */
@Configuration
public class VaultConfig extends AbstractVaultConfiguration {

    @Value("${vault.uri}")
    private String uri;

    @Value("${vault.token}")
    private String rootToken;

    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(rootToken);
    }

    @SneakyThrows
    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(new URI(uri));
    }

}
