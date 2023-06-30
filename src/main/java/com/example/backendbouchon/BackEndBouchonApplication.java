package com.example.backendbouchon;

import com.example.backendbouchon.service.repository.signature.IDBTestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndBouchonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackEndBouchonApplication.class, args);
    }
    private IDBTestService idbTestService;

    public BackEndBouchonApplication(IDBTestService idbTestService) {
        this.idbTestService = idbTestService;
    }

    @Override
    public void run(String... args) throws Exception {

        idbTestService.cleanDataBase();
        idbTestService.alimDataBase();

    }
}
