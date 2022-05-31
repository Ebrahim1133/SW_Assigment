package Observer.Users;

import Observer.Observer;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class TA extends AbstractUser implements Observer {
	String name;
	String department;
	String email;
	String phoneNumber;
	
	

	public TA(String name, String department, String email, String phoneNumber,int level) {
		super();
		this.name = name;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.level =level;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}



	@Override
	public void notify(String message) {
		write(message);
	}

	@Override
	protected void write(String message) {
		System.out.println( message);
	}
}
