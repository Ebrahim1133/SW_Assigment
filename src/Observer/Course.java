package Observer;

import java.sql.Date;
import java.util.ArrayList;


import Gateways.EmailGateway;
import Gateways.Proxy.GatewayProxy;
import Gateways.SMSGateway;
import AbstractFactoryPattern.Messages.*;
import Observer.Users.Professor;
import Observer.Users.Student;

public class Course implements Subject {

    String name;
    String code;
    ArrayList<String> announcements;
    ArrayList<String> exams;
    ArrayList<String> grades;


    ArrayList<Observer> observerEmailNotification;
    ArrayList<Observer> observerSMSNotification;


    public Course(String name, String code) {
        super();
        this.name = name;
        this.code = code;


        announcements = new ArrayList<String>();
        exams = new ArrayList<String>();
        grades = new ArrayList<String>();
        observerEmailNotification = new ArrayList<Observer>();
        observerSMSNotification = new ArrayList<Observer>();


    }

    public void subscribeEmail(Observer observer) {
        observerEmailNotification.add(observer);


    }

    public void subscribeSms(Observer observer) {

        observerSMSNotification.add(observer);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public void notifyAllUsers(String[] placeholders) {

        // notify users by email
        //message type
        TaskAddedEmailMessage msgEmail = new TaskAddedEmailMessage();
        String notificationByEmail = msgEmail.prepareMessage(placeholders);


        // notify users by sms
        //message type
        TaskAddedMobileMessage msgSms = new TaskAddedMobileMessage();
        String notificationBySms = msgSms.prepareMessage(placeholders);

        GradesAnnouncementEmailMessage qradeEmail = new GradesAnnouncementEmailMessage();
        String notificationGradeByEmail = qradeEmail.prepareMessage(placeholders);


        // notify users by sms
        //message type
        GradesAnnouncementMobileMessage qradeSms = new GradesAnnouncementMobileMessage();
        String notificationGradeBySms = qradeSms.prepareMessage(placeholders);

        DailyNewsEmailMessage dailyEmail = new DailyNewsEmailMessage();
        String notificationDailyByEmail = dailyEmail.prepareMessage(placeholders);


        // notify users by sms
        //message type
        DailyNewsMobileMessage dailySms = new DailyNewsMobileMessage();
        String notificationDailyBySms = qradeSms.prepareMessage(placeholders);


        // open connection for Email gateway and do some configurations to the object
        //method
        EmailGateway emailGateway = new EmailGateway();
        // open connection for SMS gateway and do some configurations to the object
        //method
        SMSGateway smsGateway = new SMSGateway();


        for (Observer observer : observerEmailNotification) {
            observer.notify(notificationByEmail);
            emailGateway.sendMessage(notificationByEmail, observer.getEmail());
            emailGateway.sendMessage(notificationGradeByEmail, observer.getEmail());
            emailGateway.sendMessage(notificationDailyByEmail, observer.getEmail());

        }
        for (Observer observer : observerSMSNotification) {
            observer.notify(notificationBySms);
            smsGateway.sendMessage(notificationBySms, observer.getPhoneNumber());
            smsGateway.sendMessage(notificationGradeBySms, observer.getPhoneNumber());
            smsGateway.sendMessage(notificationDailyBySms, observer.getPhoneNumber());

        }


    }

    public void AddAssignment(String assignName, String assignBody) {
        announcements.add(assignName);
        String[] placeholders = new String[]{assignName, assignBody};
        // do some logic here

        notifyAllUsers(placeholders);
    }

    public void AddExam(String examName, String examBody) {
        announcements.add(examName);
        exams.add(examBody);

        String[] placeholders = new String[]{examName, examBody};
        // do some logic here

        notifyAllUsers(placeholders);
    }

    public void postGrades(String gradesName, String gradesBody) {
        announcements.add(gradesName);
        grades.add(gradesBody);
        String[] placeholders = new String[]{gradesName, gradesBody};
        // do some logic here

        notifyAllUsers(placeholders);
    }

    public void postAnnouncement(String announcementName, String announcementBody) {
        announcements.add(announcementName);
        String[] placeholders = new String[]{announcementName, announcementBody};
        // do some logic here

        notifyAllUsers(placeholders);
    }

    ///test
    public static void main(String[] args) {
        Date d2 = new Date(2323223232L);

        Professor professor = new Professor("ahmed", "sw", d2, "uhjh", "ahmed@gmail.com", "01166446464", 0);
        Student student = new Student("ahmed", 111, "gmail.com", "010100", 0);
        String[] place = new String[]{"ahmed", "dgdfdsa", "dfaafafa"};
        Course course = new Course("SW", "111");
        course.subscribeEmail(professor);
        course.subscribeSms(professor);
        course.subscribeEmail(student);
        course.subscribeSms(student);
        GatewayProxy gatewayProxy = new GatewayProxy();
        gatewayProxy.sendMessage(new DailyNewsEmailMessage(),professor.getEmail());
        course.notifyAllUsers(place);
    }
//	 AddExam, PostGrades, PostAnnouncement  will be the same

}
