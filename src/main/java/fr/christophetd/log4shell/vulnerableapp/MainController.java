package fr.christophetd.log4shell.vulnerableapp;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private static final Logger log = LogManager.getLogger(MainController.class);

    @PostMapping("/lowercase")
    public String lowercase(@RequestHeader("X-Api-Version") String apiVersion, @RequestBody Message body) {
        log.debug("Received POST /lowercase lowercase. API version: {}", apiVersion);
        return body.message.toLowerCase();
    }

    static class Message {
        public String message;
    }

}