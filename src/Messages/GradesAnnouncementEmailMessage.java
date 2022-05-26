package Messages;

public class GradesAnnouncementEmailMessage {

	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		return "Dear {x},The grades of task" +placeHolders[1]+ "is announced and you can find it at"+ placeHolders[2]+".";
	}
	
	public boolean verifyGrades() {
		// code to verify Grades before announcement
		
		return true;
	}
}
