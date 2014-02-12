package oving2;

import java.io.IOException;

import javax.swing.JFrame;

public class main {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		JFrame frame = new JFrame();
		PersonPanel pp = new PersonPanel();
		frame.getContentPane().add(pp);
		frame.pack();
		frame.setVisible(true);
		
		Person monica = new Person();
		
		monica.setName("Testperson");
		monica.setEmail("test@gmail.com");
		monica.setDateOfBirth("18.08.1990");
		monica.setGender(Gender.FEMALE);
		monica.setHeight(171);
		
		pp.setModel(monica);
		
		Person anders = new Person();
		
		anders.setName("Anders Lima");
		anders.setEmail("anders92lima@gmail.com");
		anders.setDateOfBirth("19.11.1992");
		anders.setGender(Gender.MALE);
		anders.setHeight(178);
		
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pp.setModel(anders);
		
	}

}
