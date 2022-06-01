package AbstractFactoryPattern.Messages;

import AbstractFactoryPattern.Messages.AbstractFactory.DailyNews;

public class DailyNewsEmailMessage implements DailyNews {
	
	public String prepareMessage(String placeHolders[]) {
		return "Dear "+placeHolders[0]+"New task added" +placeHolders[1]+"is due date "+ placeHolders[2]+ "is announced and you can find it at"+ placeHolders[1]+".";
	}
}
