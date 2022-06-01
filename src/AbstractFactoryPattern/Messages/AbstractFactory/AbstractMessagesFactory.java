package AbstractFactoryPattern.Messages.AbstractFactory;

import AbstractFactoryPattern.Messages.AbstractFactory.DailyNews;
import AbstractFactoryPattern.Messages.AbstractFactory.GradeAnnouncement;
import AbstractFactoryPattern.Messages.AbstractFactory.TaskAdded;

public interface AbstractMessagesFactory {

    TaskAdded getTaskAdded(Object message);
    GradeAnnouncement getGradeAnnouncement (Object message);
    DailyNews getDailyNews(Object message);
}
