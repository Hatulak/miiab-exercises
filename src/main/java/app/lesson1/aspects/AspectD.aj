package app.lesson1.aspects;

public aspect AspectD {

    pointcut publicMethodsInServiceClassesInServicesPackagePointcut(): execution(public * app.lesson1.services.*Service.*(..));

    before(): publicMethodsInServiceClassesInServicesPackagePointcut() {
        System.out.println("AspectD | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
