package Gateways.Proxy;

import AbstractFactoryPattern.Messages.*;
import Gateways.EmailGateway;
import Gateways.SMSGateway;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class GatewayProxy implements GatewayInterfasceProxy{

    @Override
    public void sendMessage(Object message, String user) {
            EmailGateway emailGateway = new EmailGateway();
            SMSGateway smsGateway = new SMSGateway();
            // set some place holders here
        if (message instanceof TaskAddedEmailMessage ||message instanceof GradesAnnouncementEmailMessage || message instanceof DailyNewsEmailMessage){

            emailGateway.sendMessage(message,user);
        }
        else if (message instanceof TaskAddedMobileMessage ||message instanceof GradesAnnouncementMobileMessage || message instanceof DailyNewsMobileMessage){
            smsGateway.sendMessage(message,user);
        }


    }
}
