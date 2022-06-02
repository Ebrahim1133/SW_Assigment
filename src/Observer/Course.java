package Observer;

import java.sql.Date;
import java.util.ArrayList;


import AbstractFactoryPattern.Messages.AbstractFactory.MakeFactory;
import Gateways.EmailGateway;
import Gateways.Proxy.GatewayProxy;
import Gateways.SMSGateway;
import AbstractFactoryPattern.Messages.*;
import Observer.Users.Professor;
import Observer.Users.Student;

public class Course implements Subject {
    MakeFactory makeFactory =  MakeFactory.getInstance();
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

        makeFactory.create(new EmailGateway()).getDailyNews(dailyEmail);

        makeFactory.create(new EmailGateway()).getGradeAnnouncement(qradeEmail);
        makeFactory.create(new EmailGateway()).getTaskAdded(msgEmail);
        // notify users by sms
        //message type
        makeFactory.create(new SMSGateway()).getDailyNews(dailySms);
        makeFactory.create(new SMSGateway()).getGradeAnnouncement(qradeSms);
        makeFactory.create(new SMSGateway()).getTaskAdded(msgSms);


        GatewayProxy gatewayProxy = new GatewayProxy();



        for (Observer observer : observerEmailNotification) {
            observer.notify(notificationByEmail);
            gatewayProxy.sendMessage(new DailyNewsEmailMessage(),observer.getEmail());
            gatewayProxy.sendMessage(new TaskAddedEmailMessage(),observer.getEmail());
            gatewayProxy.sendMessage(new GradesAnnouncementEmailMessage(),observer.getEmail());

        }
        for (Observer observer : observerSMSNotification) {
            observer.notify(notificationBySms);
            gatewayProxy.sendMessage(new DailyNewsMobileMessage(),observer.getPhoneNumber());
            gatewayProxy.sendMessage(new TaskAddedMobileMessage(),observer.getPhoneNumber());
            gatewayProxy.sendMessage(new GradesAnnouncementMobileMessage(),observer.getPhoneNumber());

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
