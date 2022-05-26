import java.util.ArrayList;

import Gateways.EmailGateway;
import Gateways.SMSGateway;
import Messages.TaskAddedEmailMessage;
import Messages.TaskAddedMobileMessage;
import Users.Professor;
import Users.Student;
import Users.TA;

public class Course {
	
	String name;
	String code;
	ArrayList<String> announcements;
	ArrayList<String> exams;
	ArrayList<String> grades;
	
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
	
	public void subscribeProfessorForEmailNotification(Professor professor) {
		professorsForEmailNotification.add(professor);
	}
	
	public void subscribeProfessorForSMSNotification(Professor professor) {
		professorsForSMSNotification.add(professor);
	}
	
	public void subscribeTAForEmailNotification(TA ta) {
		TAsForEmailNotification.add(ta);
	}
	
	public void subscribeTAForSMSNotification(TA ta) {
		TAsForSMSNotification.add(ta);
	}
	
	public void subscribeStudentForEmailNotification(Student student) {
		studentsForEmailNotification.add(student);
	}
	
	public void subscribeStudentForSMSNotification(Student student) {
		studentsForSMSNotification.add(student);
	}
	
	
	
	public void AddAssignment(String assignName, String assignBody) {
		announcements.add(assignName);
		String[] placeholders = new String[] {assignName, assignBody};
		// do some logic here 
		
		notifyAllUsers(placeholders);
	}

	public void AddExam(String examName, String examBody) {
		announcements.add(examName);
		String[] placeholders = new String[] {examName, examBody};
		// do some logic here

		notifyAllUsers(placeholders);
	}

	public void postGrades(String gradesName, String gradesBody) {
		announcements.add(gradesName);
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

	private void notifyAllUsers(String[] placeholders) {
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
		
		
		for (Professor professor : professorsForEmailNotification) {
			professor.notifyProfessor(notificationByEmail);
			emailGateway.sendMessage(notificationByEmail, professor.getEmail());
		}
		
		for (TA ta : TAsForEmailNotification) {
			ta.notifyTA(notificationByEmail);
			emailGateway.sendMessage(notificationByEmail, ta.getEmail());
		}
		
		for (Student student : studentsForEmailNotification) {
			student.notifyStudent(notificationByEmail);
			emailGateway.sendMessage(notificationByEmail, student.getEmail());
		}


		for (Professor professor : professorsForSMSNotification) {
			professor.notifyProfessor(notificationBySms);
			smsGateway.sendMessage(notificationBySms, professor.getPhoneNumber());
		}

		for (TA ta : TAsForSMSNotification) {
			ta.notifyTA(notificationBySms);
			smsGateway.sendMessage(notificationBySms, ta.getPhoneNumber());
		}

		for (Student student : studentsForSMSNotification) {
			student.notifyStudent(notificationBySms);
			smsGateway.sendMessage(notificationBySms, student.getPhoneNumber());
		}
	}
	
	
	
	
}
