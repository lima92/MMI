package oving4;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import oving3.Person;
import oving3.PersonPanel;

public class PersonListPanel extends JPanel {
	
	private DefaultListModel<Person> listModel;
	private JList<Person> personList;
	private PersonPanel personPanel;
	private JButton newPersonButton, deletePersonButton;
	
	public PersonListPanel() {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.CENTER;
		
		this.personList = new JList<Person>();
		this.personPanel = new PersonPanel();
		this.listModel = new DefaultListModel<Person>();
		this.newPersonButton = new JButton("Add New Person");
		this.deletePersonButton = new JButton("Delete Person");
		
		newPersonButton.addActionListener(new ButtonListener());
		deletePersonButton.addActionListener(new ButtonListener());
		
		personList.addListSelectionListener(new SelectionHandler());
		personList.setPreferredSize(new Dimension(175,400));
		
		this.personList.setName("PersonList");
		this.personPanel.setName("PersonPanel");
		this.newPersonButton.setName("NewPersonButton");
		this.deletePersonButton.setName("DeletePersonButton");
		
		this.setModel(listModel);
		
		this.add(personList,GBC(c,0,0));
		this.add(personPanel,GBC(c,1,0));
		this.add(newPersonButton,GBC(c,0,1));
		this.add(deletePersonButton,GBC(c,0,2));
	}
	
	
	public void setModel(DefaultListModel<Person> dlm){
		this.listModel = dlm;
		personList.setModel(listModel);
	}
	
	public DefaultListModel<Person> getModel(){
		return this.listModel;
	}
	
	private void newPerson(){
		Person newP = new Person("Enter Name");
		this.listModel.addElement(newP);
		personList.setSelectedValue(newP, true);
	}
	
	private void deletePerson(){
		Person delP = personList.getSelectedValue();
		int lastIndex = personList.getMaxSelectionIndex();
		if(lastIndex==-1){
			newPerson();
		}else{
			personList.setSelectedIndex(personList.getMaxSelectionIndex()-1);
		}
		listModel.removeElement(delP);
	}
	
	class SelectionHandler implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			personPanel.setModel(personList.getSelectedValue());
			personPanel.updateView();
		}
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource().equals(newPersonButton)){
				newPerson();
			}else if(arg0.getSource().equals(deletePersonButton)){
				deletePerson();
			}
			
		}

		
	}
	
	private GridBagConstraints GBC (GridBagConstraints c, int x, int y){
		c.gridx = x;
		c.gridy = y;
		return c;
	}
}
