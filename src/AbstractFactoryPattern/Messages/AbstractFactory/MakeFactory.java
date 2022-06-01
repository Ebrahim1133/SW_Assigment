package AbstractFactoryPattern.Messages.AbstractFactory;

import Gateways.EmailGateway;
import Gateways.SMSGateway;

public class MakeFactory {

    private static MakeFactory instance;

    private MakeFactory() {

    }

    public static MakeFactory getInstance() {
        if (instance == null) {
            instance = new MakeFactory();
        }
        return instance;
    }

    public  AbstractMessagesFactory create(Object message) {

        if (message instanceof EmailGateway) {
            return new EmailFactory();
        } else if (message instanceof SMSGateway) {

            return new SmsFactory();

        } else {
            return null;
        }

    }
}
