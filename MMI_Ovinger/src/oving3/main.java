package oving3;

import javax.swing.JFrame;
import javax.swing.JPanel;

import oving2.Gender;

public class main {

	/**
	 * @param args
	 */
	
	public static void main(String args[]){
		JFrame frame = new JFrame();
		PersonPanel epp = new PersonPanel();
		PassivePersonPanel ppp = new PassivePersonPanel();
		
		JPanel container = new JPanel();
		
		container.add(epp);
		container.add(ppp);
		
		
		frame.getContentPane().add(container);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Person personModel = new Person("Enter name");
		
		epp.setModel(personModel);
		ppp.setModel(personModel);

		
		
	}

}
