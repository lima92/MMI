package oving3;

import oving2.Gender;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	public final static String NAME_PROPERTY = "navn";
	public final static String EMAIL_PROPERTY = "email";
	public final static String DOB_PROPERTY = "dob";
	public final static String GENDER_PROPERTY = "gender";
	public final static String HEIGHT_PROPERTY = "height"; 
	
	private String name, email, dateOfBirth;
	private int height;
	private Gender gender;
	
	private PropertyChangeSupport pcs;
	
	public Person(){
		pcs = new PropertyChangeSupport(this);
	}
	
	public Person(String name){
		this();
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldVal = getName();
		this.name = name;
		pcs.firePropertyChange(NAME_PROPERTY, oldVal, name);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		String oldVal = getEmail();
		this.email = email;
		pcs.firePropertyChange(EMAIL_PROPERTY, oldVal, email);
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		int oldVal = getHeight();
		this.height = height;
		pcs.firePropertyChange(HEIGHT_PROPERTY, oldVal, height);
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		Gender oldVal = getGender();
		this.gender = gender;
		pcs.firePropertyChange(GENDER_PROPERTY, oldVal, gender);
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		String oldVal = getDateOfBirth();
		this.dateOfBirth = dateOfBirth;
		pcs.firePropertyChange(DOB_PROPERTY, oldVal, dateOfBirth);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener){
		pcs.addPropertyChangeListener(listener);
	}

	public String toString(){
		return this.getName();
	}
	
}
