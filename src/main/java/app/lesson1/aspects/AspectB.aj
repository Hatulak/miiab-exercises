package app.lesson1.aspects;

public aspect AspectB {

    pointcut oneStringParamPointcut(): execution(* app.lesson1..*.*(String));

    before(): oneStringParamPointcut() {
        System.out.println("AspectB | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
