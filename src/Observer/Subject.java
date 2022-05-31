package Observer;

import Observer.Users.Professor;
import Observer.Users.Student;
import Observer.Users.TA;

public interface Subject {

    void subscribeEmail(Observer observer);
    void subscribeSms(Observer observer);
    void notifyAllUsers(String[] placeholders);


}
