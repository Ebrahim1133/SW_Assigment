package Gateways;


import AbstractFactoryPattern.Messages.AbstractFactory.MakeFactory;
import AbstractFactoryPattern.Messages.DailyNewsEmailMessage;
import AbstractFactoryPattern.Messages.GradesAnnouncementEmailMessage;
import AbstractFactoryPattern.Messages.TaskAddedEmailMessage;
import Gateways.Proxy.GatewayInterfasceProxy;

public class EmailGateway implements GatewayInterfasceProxy {




    @Override
    public void sendMessage(Object message, String user) {
        String[] placeHolders = new String[] {};
        if(message instanceof DailyNewsEmailMessage) {
            System.out.println("hello");
            MakeFactory.create(new EmailGateway()).getDailyNews(message);

        }

        else if(message instanceof GradesAnnouncementEmailMessage) {
            MakeFactory.create(new EmailGateway()).getGradeAnnouncement(message);

        }

        else if(message instanceof TaskAddedEmailMessage) {
            MakeFactory.create(new EmailGateway()).getTaskAdded(message);
        }
    }




}
