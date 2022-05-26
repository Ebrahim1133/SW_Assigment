package Messages;

import Users.Professor;

public class TaskAddedMobileMessage {

	public String prepareMessage(String placeHolders[]) {


		return "Dear {x},The grades of task" +placeHolders[1]+ "is announced and you can find it at"+ placeHolders[2]+".";
	}
	
	
	public void addTeamDescription() {
		
	}
}
