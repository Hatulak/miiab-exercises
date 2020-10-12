package app.lesson1.aspects;

public aspect AspectE {

    pointcut nonPublicSetMethodsInModelPackagePointcut(): execution(!public * app.lesson1.model.*.set*(..));

    before(): nonPublicSetMethodsInModelPackagePointcut() {
        System.out.println("AspectE | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
