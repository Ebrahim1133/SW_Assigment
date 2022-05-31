package Observer.Users;

public class AbstractUser {

    protected int level;

    protected AbstractUser nextUser;


    public void setNextUser(AbstractUser nextUser){
        this.nextUser = nextUser;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextUser !=null){
            nextUser.logMessage(level, message);
        }
    }

    protected void write(String message) {

    }
}
