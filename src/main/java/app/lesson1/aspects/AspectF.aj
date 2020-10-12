package app.lesson1.aspects;

public aspect AspectF {

    pointcut deprecatedMethodsPointcut(): execution(@Deprecated * app.lesson1..*.*(..));

    before(): deprecatedMethodsPointcut() {
        System.out.println("AspectF | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
