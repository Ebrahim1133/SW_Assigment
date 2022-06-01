package AbstractFactoryPattern.Messages;

import AbstractFactoryPattern.Messages.AbstractFactory.TaskAdded;

public class TaskAddedEmailMessage implements TaskAdded {

	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		
		return "Dear "+placeHolders[0]+"New task added" +placeHolders[1]+"is due date "+ placeHolders[2]+ "is announced and you can find it at Email";
	}
	
	
	public void addTeamDescription() {
		
	}
}
