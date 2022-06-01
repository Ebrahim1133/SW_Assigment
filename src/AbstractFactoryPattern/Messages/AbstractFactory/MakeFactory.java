package AbstractFactoryPattern.Messages.AbstractFactory;

import Gateways.EmailGateway;
import Gateways.SMSGateway;

public class MakeFactory {


  public static AbstractMessagesFactory create(Object message) {

        if (message instanceof EmailGateway) {
            return new EmailFactory();
        } else if (message instanceof SMSGateway) {

            return new SmsFactory();

        }
        else {
            return null;
        }

    }
}
