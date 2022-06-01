package AbstractFactoryPattern.Messages.AbstractFactory;

public interface GradeAnnouncement {
    String prepareMessage(String placeHolders[]);
    boolean verifyGrades();
}
