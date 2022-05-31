package Observer;

import Observer.Users.Professor;
import Observer.Users.Student;
import Observer.Users.TA;

public interface Subject {


    void notifyAllUsers(String[] placeholders);


}
