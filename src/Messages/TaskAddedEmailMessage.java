package Messages;

public class TaskAddedEmailMessage {

	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		
		return "Dear {x},New task added" +placeHolders[0]+"is due date "+ placeHolders[1]+ "is announced and you can find it at Email";
	}
	
	
	public void addTeamDescription() {
		
	}
}
