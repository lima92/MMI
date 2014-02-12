package oving4;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import oving3.PassivePersonPanel;
import oving3.Person;
import oving3.PersonPanel;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		PersonListPanel plp = new PersonListPanel();
		
		Person[] list = {new Person("Anders"),new Person("NIGG")};
		
		DefaultListModel<Person> model = new DefaultListModel<Person>();
		
		for(Person p:list){
			model.addElement(p);
		}
		
		plp.setModel(model);
		
		frame.getContentPane().add(plp);

		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
