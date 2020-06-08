package io.vaultproject.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Artyom Poteshkin
 */
@Getter
@Setter
public class AddSecretRequest {

    private String secretKey;
    private String secretValue;
}
