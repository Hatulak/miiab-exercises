package app.lesson1.aspects;

public aspect Aspect2 {

    pointcut timeAspect(): execution(public * app.lesson1.model.*.*(..)) && !(execution(public * app.lesson1.model.*.set*(..)) || execution(public * app.lesson1.model.*.get*(..)));

    Object around(): timeAspect() {
        long time = System.nanoTime();
        Object ret = proceed();
        System.out.println("Aspect2 | " + (System.nanoTime() - time) + " ns");
        return ret;
    }
}
