package AbstractFactoryPattern.Messages.AbstractFactory;

public interface TaskAdded {
    String prepareMessage(String placeHolders[]);
    void addTeamDescription();
}
