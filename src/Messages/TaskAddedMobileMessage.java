package Messages;

public class TaskAddedMobileMessage {

	public String prepareMessage(String placeHolders[]) {


		return "Dear {x},New task added" +placeHolders[0]+"is due date "+ placeHolders[1]+ "is announced and you can find it at Mobile SMS";
	}
	
	
	public void addTeamDescription() {
		
	}
}
