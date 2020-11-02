package app.lesson1.aspects;

public aspect Aspect4 {

    pointcut compilationPointcut(): withincode( * set*(..)) && within(@jdk.nashorn.internal.ir.annotations.Immutable *);

    declare error: compilationPointcut(): "Set method is not allowed in @Immutable class";

}
