package app.lesson1;

import app.lesson1.aspects.Aspect3;
import app.lesson1.model.Animal;
import app.lesson1.model.Car;
import app.lesson1.services.ExerciseOneService;
import app.lesson1.services.UserService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


public class Application {
    public static void main(String[] args) {

        ExerciseOneService exerciseOneService = new ExerciseOneService();
        UserService userService = new UserService();

        //a)
        System.out.println("----------------------A)--------------------------");
        System.out.println("returned float: " + exerciseOneService.getFloatNumber());
        System.out.println("returned int: " + exerciseOneService.getIntNumber());
        System.out.println("------------------------------------------------\n\n");

        //b)
        System.out.println("----------------------B)--------------------------");
        exerciseOneService.methodWithOnlyOneStringParameter("Parameter");
        exerciseOneService.methodWithOnlyOneStringParameterAndReturn("Param to be returned");
        System.out.println("------------------------------------------------\n\n");

        //c)
        System.out.println("----------------------C)--------------------------");
        exerciseOneService.methodWithTwoParameters(1,"String");
        exerciseOneService.secondMethodWithTwoParameters(Arrays.asList(true,false,true), 3.2);
        System.out.println("------------------------------------------------\n\n");

        //d)
        System.out.println("----------------------D)--------------------------");
        exerciseOneService.getIntNumber();
        userService.addUser("x","pass","x@gmail.com");
        System.out.println("------------------------------------------------\n\n");

        //e)
        System.out.println("----------------------E)--------------------------");
        Animal animal = new Animal(1L, "Cat");
        animal.changeName("Dog");
        animal.changeId(2L);
        System.out.println("------------------------------------------------\n\n");

        //f)
        System.out.println("----------------------F)--------------------------");
        exerciseOneService.deprecatedPublicMethod();
        System.out.println("------------------------------------------------\n\n");

        //g)
        System.out.println("----------------------G)--------------------------");
        exerciseOneService.deprecatedPublicMethod();
        exerciseOneService.getIntNumber();
        userService.verify("x","abcd");
        System.out.println("------------------------------------------------\n\n");

        //2
        System.out.println("----------------------2)--------------------------");
        Animal animal2 = new Animal(123L, "Dog");
        animal2.getName();
        animal2.changeName("Good dog");
        System.out.println("------------------------------------------------\n\n");

        //3
        System.out.println("----------------------3)--------------------------");
        System.out.println("Last time changeName method was used: "+ Aspect3.getLastChange(animal2));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animal2.changeName("Better dog");
        System.out.println("Last time changeName method was used: "+ Aspect3.getLastChange(animal2));
        System.out.println("------------------------------------------------\n\n");
        //4
        Car car = new Car();
        car.setColor("blue");

    }
}
