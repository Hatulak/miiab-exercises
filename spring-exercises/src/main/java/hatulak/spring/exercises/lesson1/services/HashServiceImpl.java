package hatulak.spring.exercises.lesson1.services;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class HashServiceImpl implements HashService {

    @Override
    public String getHash(String s) {
        return Hashing.sha256()
                .hashString(s, StandardCharsets.UTF_8)
                .toString();
    }
}
