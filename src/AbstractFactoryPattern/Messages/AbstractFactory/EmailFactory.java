package AbstractFactoryPattern.Messages.AbstractFactory;

import AbstractFactoryPattern.Messages.DailyNewsEmailMessage;
import AbstractFactoryPattern.Messages.GradesAnnouncementEmailMessage;
import AbstractFactoryPattern.Messages.TaskAddedEmailMessage;

public class EmailFactory implements AbstractMessagesFactory {
    @Override
    public TaskAdded getTaskAdded(Object message) {
        if(message instanceof TaskAddedEmailMessage){
            return new TaskAddedEmailMessage();
        }
        else return null;

    }

    @Override
    public GradeAnnouncement getGradeAnnouncement(Object message) {
        if (message instanceof GradesAnnouncementEmailMessage){
            return new GradesAnnouncementEmailMessage();
        }
        else return null;

    }

    @Override
    public DailyNews getDailyNews(Object message) {
        if (message instanceof DailyNewsEmailMessage){
            return new DailyNewsEmailMessage();
        }
        else return null;

    }
}
