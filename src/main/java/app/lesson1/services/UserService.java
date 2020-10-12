package app.lesson1.services;

public class UserService {

    public boolean verify(String username, String pasword) {
        System.out.println("UserService.verify called");
        return false;
    }

    public void addUser(String username, String password, String email) {
        System.out.println("UserService.add called");
    }


}
