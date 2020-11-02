package app.lesson2.aspects;

import org.aspectj.lang.reflect.CodeSignature;

public aspect Aspect1 {

    pointcut nonNullArgsPointcut(): @annotation(app.lesson2.services.NonNullArgs);

    before() throws IllegalArgumentException : nonNullArgsPointcut() {
        String[] parameterNames = ((CodeSignature) thisJoinPoint.getSignature()).getParameterNames();
        Class[] parameterTypes = ((CodeSignature) thisJoinPoint.getSignature()).getParameterTypes();
        for (int i = 0; i < thisJoinPoint.getArgs().length; i++) {
            if (thisJoinPoint.getArgs()[i] == null) {
                throw new IllegalArgumentException(
                        "Type: " + parameterTypes[i] + " Name: " + parameterNames[i] + " Cannot be null");
            }
        }
    }
}
