package hatulak.spring.exercises.lesson1.services;

import org.springframework.stereotype.Service;

@Service
public interface HashService {
    String getHash(String s);
}