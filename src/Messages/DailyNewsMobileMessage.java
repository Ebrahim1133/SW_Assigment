package Messages;

public class DailyNewsMobileMessage {
	
	public String prepareMessage(String placeHolders[]) {
		// code to replace place holders of this type
		return "Dear {x},The grades of task" +placeHolders[0]+ "is announced and you can find it at"+ placeHolders[1]+".";
	}
}
