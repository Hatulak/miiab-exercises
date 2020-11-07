package hatulak.spring.exercises;

import hatulak.spring.exercises.lesson1.services.HashService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashServiceTests {

    private final HashService hashService;

    @Autowired
    public HashServiceTests(HashService hashService) {
        this.hashService = hashService;
    }

    @Test
    public void hashTest() {
        Assertions.assertEquals("9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08", hashService.getHash("test"));
    }
}
