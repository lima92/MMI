package oving2;


public class Person {
	private String name, email, dateOfBirth;
	private int height;
	private Gender gender;
	
	
	public Person(){
		
	}
	
	public Person(String name){
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {

		this.name = name;

	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {

		this.email = email;

	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {

		this.height = height;

	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {

		this.gender = gender;

	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {

		this.dateOfBirth = dateOfBirth;

	}

}
