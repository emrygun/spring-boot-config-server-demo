package dev.emreuygun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClient {

    @Value("#{user.role}")
    private String role;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
    @GetMapping(
            value = "/whoami/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User whoAmI(@PathVariable String username) {
        return new User(username, role);
    }

    public record User(String username, String role) {}
}