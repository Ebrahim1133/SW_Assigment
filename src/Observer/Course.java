package Observer;

import java.util.ArrayList;
import java.util.List;


import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Messages.TaskAddedEmailMessage;
import Messages.TaskAddedMobileMessage;
import Observer.Users.Professor;
import Observer.Users.Student;
import Observer.Users.TA;

public class Course implements 	Subject {
	
	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;

	List<Observer> observerList;


	ArrayList<Professor> professorsForEmailNotification;
	ArrayList<Professor> professorsForSMSNotification;
	
	ArrayList<TA> TAsForEmailNotification;
	ArrayList<TA> TAsForSMSNotification;
	
	ArrayList<Student> studentsForEmailNotification;
	ArrayList<Student> studentsForSMSNotification;


	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
		this.observerList = new ArrayList<>();
		
		announcements = new ArrayList<String>();
		exams = new ArrayList<String>();
		grades = new ArrayList<String>();
		professorsForEmailNotification = new ArrayList<Professor>();
		professorsForSMSNotification = new ArrayList<Professor>();

		TAsForEmailNotification = new ArrayList<TA>();
		TAsForSMSNotification = new ArrayList<TA>();

		studentsForEmailNotification = new ArrayList<Student>();
		studentsForSMSNotification = new ArrayList<Student>();
		

	}

	public void subscribeProfessorForEmailNotification(Professor professor ,Observer observer) {
		observerList.add(observer);

		professorsForEmailNotification.add(professor);
	}

	public void subscribeProfessorForSMSNotification(Professor professor ,Observer observer) {
		observerList.add(observer);
		professorsForSMSNotification.add(professor);
	}

	public void subscribeTAForEmailNotification(TA ta ,Observer observer) {
		observerList.add(observer);
		TAsForEmailNotification.add(ta);
	}

	public void subscribeTAForSMSNotification(TA ta,Observer observer ) {
		observerList.add(observer);
		TAsForSMSNotification.add(ta);
	}

	public void subscribeStudentForEmailNotification(Student student,Observer observer) {
		observerList.add(observer);
		studentsForEmailNotification.add(student);
	}

	public void subscribeStudentForSMSNotification(Student student,Observer observer) {
		observerList.add(observer);
		studentsForSMSNotification.add(student);
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

		// open connection for Email gateway and do some configurations to the object
		//method
		EmailGateway emailGateway = new EmailGateway();
		// open connection for SMS gateway and do some configurations to the object
		//method
		SMSGateway smsGateway = new SMSGateway();

		for (Observer observer : observerList) {


			for (Professor professor : professorsForEmailNotification) {
				observer.notify(notificationByEmail);
				emailGateway.sendMessage(notificationByEmail, professor.getEmail());
			}

			for (TA ta : TAsForEmailNotification) {
				observer.notify(notificationByEmail);
				emailGateway.sendMessage(notificationByEmail, ta.getEmail());
			}

			for (Student student : studentsForEmailNotification) {
				observer.notify(notificationByEmail);
				emailGateway.sendMessage(notificationByEmail, student.getEmail());
			}


			for (Professor professor : professorsForSMSNotification) {
				observer.notify(notificationBySms);
				smsGateway.sendMessage(notificationBySms, professor.getPhoneNumber());
			}

			for (TA ta : TAsForSMSNotification) {
				observer.notify(notificationBySms);
				smsGateway.sendMessage(notificationBySms, ta.getPhoneNumber());
			}

			for (Student student : studentsForSMSNotification) {
				observer.notify(notificationBySms);
				smsGateway.sendMessage(notificationBySms, student.getPhoneNumber());
			}
		}

	}
	
	public void AddAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here 
		
		notifyAllUsers(placeholders);
	}

	public void AddExam(String examName, String examBody) {
		announcements.add(examName);
		exams.add(examBody);

		String[] placeholders = new String[] {examName, examBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void postGrades(String gradesName, String gradesBody) {
		announcements.add(gradesName);
		grades.add(gradesBody);
		String[] placeholders = new String[] {gradesName, gradesBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void postAnnouncement(String announcementName, String announcementBody) {
		announcements.add(announcementName);
		String[] placeholders = new String[] {announcementName, announcementBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	
	// AddExam, PostGrades, PostAnnouncement  will be the same 

}
