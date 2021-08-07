package br.com.baylei.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags ={"Configuration service"} )
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    private Environment environment;

    @ApiOperation("Get profile")
    @GetMapping("profile-active")
    public ResponseEntity getConfiguration() {
        String[] activeProfiles = environment.getActiveProfiles();
        return ResponseEntity.ok(activeProfiles);
    }


}
