package Gateways;

import AbstractFactoryPattern.Messages.AbstractFactory.MakeFactory;
import AbstractFactoryPattern.Messages.DailyNewsMobileMessage;
import AbstractFactoryPattern.Messages.GradesAnnouncementMobileMessage;
import AbstractFactoryPattern.Messages.TaskAddedMobileMessage;
import Gateways.Proxy.GatewayInterfasceProxy;

public class SMSGateway implements GatewayInterfasceProxy {

	@Override
	public void sendMessage(Object message, String user) {
		String[] placeHolders = new String[] {};
		if(message instanceof DailyNewsMobileMessage) {
			MakeFactory.create(new SMSGateway()).getDailyNews(message);
		}

		else if(message instanceof GradesAnnouncementMobileMessage) {
			MakeFactory.create(new SMSGateway()).getGradeAnnouncement(message);
		}

		else if(message instanceof TaskAddedMobileMessage) {
			MakeFactory.create(new SMSGateway()).getTaskAdded(message);
		}
	}


}
