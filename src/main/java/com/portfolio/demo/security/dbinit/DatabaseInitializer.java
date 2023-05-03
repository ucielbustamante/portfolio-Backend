package com.portfolio.demo.security.dbinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.portfolio.demo.security.entity.Rol;
import com.portfolio.demo.security.enums.RolName;
import com.portfolio.demo.security.service.RolService;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    
    @Autowired
    private RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
    }

    private void createRoles() {
        for (RolName rolName : RolName.values()) {
            if (!rolService.getRolByName(rolName).isPresent()) {
                Rol rol = new Rol();
                rol.setRolName(rolName);
                rolService.save(rol);
            }
        }
    }
}