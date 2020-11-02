package app.lesson1.services;


import java.util.List;

public class ExerciseOneService {

    public float getFloatNumber(){
        System.out.println("inside getFloatNumber");
        return (float) Math.random();
    }

    public int getIntNumber(){
        System.out.println("inside getIntNumber");
        return (int) Math.random();
    }

    public void methodWithOnlyOneStringParameter(String string){
        System.out.println("inside methodWithOnlyOneStringParameter");
    }

    public String methodWithOnlyOneStringParameterAndReturn(String string){
        System.out.println("inside methodWithOnlyOneStringParameterAndReturn");
        return string;
    }

    public void methodWithTwoParameters(Integer integer, String string){
        System.out.println("inside methodWithTwoParameters");
    }

    public void secondMethodWithTwoParameters(List<Boolean> booleanList, Double value){
        System.out.println("inside secondMethodWithTwoParameters");
    }

    @Deprecated
    public void deprecatedPublicMethod(){
        System.out.println("inside deprecatedPublicMethod");
        this.secondDeprecatedPublicMethod();
    }

    @Deprecated
    private void secondDeprecatedPublicMethod(){
        System.out.println("inside secondDeprecatedPublicMethod");
    }



}
