package AbstractFactoryPattern.Messages.AbstractFactory;

import AbstractFactoryPattern.Messages.*;

public class SmsFactory implements AbstractMessagesFactory {
    @Override
    public TaskAdded getTaskAdded(Object message) {
        if(message instanceof TaskAddedMobileMessage){
            return new TaskAddedMobileMessage();
        }
        else return null;

    }

    @Override
    public GradeAnnouncement getGradeAnnouncement(Object message) {
        if (message instanceof GradesAnnouncementMobileMessage){
            return new GradesAnnouncementMobileMessage();
        }
        else return null;

    }

    @Override
    public DailyNews getDailyNews(Object message) {
        if (message instanceof DailyNewsMobileMessage){
            return new DailyNewsMobileMessage();
        }
        else return null;

    }
}
