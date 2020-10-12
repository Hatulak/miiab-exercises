package app.lesson1.aspects;

public aspect AspectA {

    pointcut floatPointcut(): execution(float app.lesson1..*.*(..));

    before(): floatPointcut() {
        System.out.println("AspectA | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
