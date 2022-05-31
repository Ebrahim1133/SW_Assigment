package Gateways;

import Messages.DailyNewsEmailMessage;
import Messages.GradesAnnouncementEmailMessage;
import Messages.TaskAddedEmailMessage;

public class Gatway {
    private  Object message;
    private  String user;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void sendMessage(Object message,String user){
        String[] placeHolders = new String[] {}; // set some place holders here

        if(message instanceof DailyNewsEmailMessage) {
            DailyNewsEmailMessage dailyNewsEmailMessage = (DailyNewsEmailMessage) message;

            dailyNewsEmailMessage.prepareMessage(placeHolders);



            // some code to send message
        }

        else if(message instanceof GradesAnnouncementEmailMessage) {
            GradesAnnouncementEmailMessage announcementEmailMessage = (GradesAnnouncementEmailMessage) message;

            announcementEmailMessage.prepareMessage(placeHolders);

            // some code to send message
        }

        else if(message instanceof TaskAddedEmailMessage) {
            TaskAddedEmailMessage addedEmailMessage = (TaskAddedEmailMessage) message;

            addedEmailMessage.prepareMessage(placeHolders);

            // some code to send message by email to u
        }
    }
}
