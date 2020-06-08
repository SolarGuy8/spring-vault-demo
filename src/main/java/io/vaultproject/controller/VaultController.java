package io.vaultproject.controller;

import io.vaultproject.model.request.AddSecretRequest;
import io.vaultproject.service.VaultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artyom Poteshkin
 */
@RestController
@RequestMapping("/vault")
public class VaultController {

    private final VaultService vaultService;

    public VaultController(VaultService vaultService) {
        this.vaultService = vaultService;
    }

    @GetMapping("/getSecret/{secretPath}")
    public String getSecret(@PathVariable String secretPath) {
        return vaultService.getSecretValue(secretPath);
    }

    @PostMapping("/addSecret")
    public void addSecret(@RequestBody AddSecretRequest request) {
        vaultService.addSecret(request);
    }
}
