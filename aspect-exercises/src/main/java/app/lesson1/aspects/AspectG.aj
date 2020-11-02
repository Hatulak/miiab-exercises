package app.lesson1.aspects;

public aspect AspectG {
    //means: public methods in *Service classes in services package but not with 2 parameters
    pointcut aspectDTypeAndNotCType(): execution(public * app.lesson1.services.*Service.*(..)) && !(execution( * app.lesson1..*.*(*,*)));

    before(): aspectDTypeAndNotCType() {
        System.out.println("AspectG | kind: " + thisJoinPoint.getKind() + " | signature: " + thisJoinPoint.getSignature());
    }
}
