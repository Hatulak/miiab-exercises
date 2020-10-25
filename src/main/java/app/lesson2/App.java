package app.lesson2;

import app.lesson2.model.TestModel;
import app.lesson2.services.Lesson2Service;

import java.util.Arrays;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        Lesson2Service lesson2Service = new Lesson2Service();

        //Test aspect 1
        lesson2Service.nonNullArgsMethod(true, new LinkedList<>(Arrays.asList("test", "test2")));
        try {
            lesson2Service.nonNullArgsMethod(null, new LinkedList<>(Arrays.asList("test", "test2")));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Test aspect 2, uncomment to test
//        lesson2Service.exceptionText();

        //Test aspect 3, comment test aspect 2 to test
        TestModel testModel = new TestModel();
        testModel.setName(null);
        testModel.setId(null);
    }
}
