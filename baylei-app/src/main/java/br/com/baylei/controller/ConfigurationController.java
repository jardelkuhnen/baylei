package br.com.baylei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private Environment environment;

    @GetMapping("profile-active")
    public ResponseEntity getConfiguration() {
        String[] activeProfiles = environment.getActiveProfiles();
        return ResponseEntity.ok(activeProfiles);
    }


}
