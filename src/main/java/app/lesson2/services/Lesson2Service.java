package app.lesson2.services;

import java.util.List;

@PublicsLogger
public class Lesson2Service {

    @NonNullArgs
    public void nonNullArgsMethod(Boolean bool, List<String> stringList){
        System.out.println("inside nonNullArgsMethod");
    }

    public void exceptionText() throws RuntimeException {
        throw new RuntimeException("test message");
    }

}
