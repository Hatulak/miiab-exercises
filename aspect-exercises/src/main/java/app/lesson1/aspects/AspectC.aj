package app.lesson1.aspects;

public aspect AspectC {

    pointcut twoParamsPointcut(): execution( * app.lesson1..*.*(*,*));

    before(): twoParamsPointcut() {
        System.out.println("AspectC | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
