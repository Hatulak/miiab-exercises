package app.lesson2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.logging.Logger;

public aspect Aspect2 {

    pointcut annotatedClasses(): within(@app.lesson2.services.PublicsLogger *);
    pointcut publicMethods(): execution(public * *.*(..));


    before(): publicMethods() && annotatedClasses() {
        Logger logger = Logger.getLogger(thisJoinPointStaticPart.getSignature().getDeclaringTypeName());
        logger.finest(() -> {
            StringBuilder sb = new StringBuilder();

            sb.append(thisJoinPointStaticPart.getSignature()).append(", args: ");

            for (Object arg : thisJoinPoint.getArgs()) {
                sb.append(arg).append(", ");
            }
            return "Public method called: " + sb.toString();
        });
    }

    after() throwing (Exception e): publicMethods() && annotatedClasses() {
        Logger logger = Logger.getLogger(thisJoinPointStaticPart.getSignature().getDeclaringTypeName());
        logger.severe(() -> {
            StringBuilder sb = new StringBuilder();

            sb.append(thisJoinPointStaticPart.getSignature()).append(", args: ");

            for (Object arg : thisJoinPoint.getArgs()) {
                sb.append(arg).append(", ");
            }
            sb.append(e);
            return "Method has thrown an exception: " + sb.toString();
        });
    }


}
