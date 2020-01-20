package com.example.demoemp.employee.controller;

import com.example.demoemp.config.ApplicationConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "version", description = "Endpoint providing current information about the version of the running service; used only for testing and information wise;")
public class VersionController {

    @Autowired
    private ApplicationConfig applicationConfig;

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the current version of the running service endpoint; also additional information is displayed, such as the application name;")
    public String version() {
        String result = "Application name: " + applicationConfig.getApplicationName() + "\n" +
                "Version name: " + applicationConfig.getVersionName() + "\n" +
                "Version number: " + applicationConfig.getVersionNumber();
        return result;
    }
}
