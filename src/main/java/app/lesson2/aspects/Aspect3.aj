package app.lesson2.aspects;

import org.aspectj.lang.reflect.CodeSignature;

public aspect Aspect3 {

    pointcut nonNullFields(): set(* app.lesson2.model.*.*);

    before(): nonNullFields() {
        for (int i = 0; i < thisJoinPoint.getArgs().length; i++) {
            if (thisJoinPoint.getArgs()[i] == null) {
                throw new NullPointerException("Cannot set null value on @NonNull field");
            }
        }
    }
}
