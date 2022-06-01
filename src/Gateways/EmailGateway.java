package Gateways;


import AbstractFactoryPattern.Messages.AbstractFactory.MakeFactory;
import AbstractFactoryPattern.Messages.DailyNewsEmailMessage;
import AbstractFactoryPattern.Messages.GradesAnnouncementEmailMessage;
import AbstractFactoryPattern.Messages.TaskAddedEmailMessage;
import Gateways.Proxy.GatewayInterfasceProxy;

public class EmailGateway implements GatewayInterfasceProxy {

    MakeFactory makeFactory =  MakeFactory.getInstance();


    @Override
    public void sendMessage(Object message, String user) {
        String[] placeHolders = new String[] {};
        if(message instanceof DailyNewsEmailMessage) {

            makeFactory.create(new EmailGateway()).getDailyNews(message);

        }

        else if(message instanceof GradesAnnouncementEmailMessage) {
            makeFactory.create(new EmailGateway()).getGradeAnnouncement(message);

        }

        else if(message instanceof TaskAddedEmailMessage) {
            makeFactory.create(new EmailGateway()).getTaskAdded(message);
        }
    }




}
