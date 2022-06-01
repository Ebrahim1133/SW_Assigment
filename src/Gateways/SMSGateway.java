package Gateways;

import AbstractFactoryPattern.Messages.AbstractFactory.MakeFactory;
import AbstractFactoryPattern.Messages.DailyNewsMobileMessage;
import AbstractFactoryPattern.Messages.GradesAnnouncementMobileMessage;
import AbstractFactoryPattern.Messages.TaskAddedMobileMessage;
import Gateways.Proxy.GatewayInterfasceProxy;

public class SMSGateway implements GatewayInterfasceProxy {
MakeFactory makeFactory =  MakeFactory.getInstance();
	@Override
	public void sendMessage(Object message, String user) {
		String[] placeHolders = new String[] {};
		if(message instanceof DailyNewsMobileMessage) {
			makeFactory.create(new SMSGateway()).getDailyNews(message);
		}

		else if(message instanceof GradesAnnouncementMobileMessage) {
			makeFactory.create(new SMSGateway()).getGradeAnnouncement(message);
		}

		else if(message instanceof TaskAddedMobileMessage) {
			makeFactory.create(new SMSGateway()).getTaskAdded(message);
		}
	}


}
