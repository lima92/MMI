package oving2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class PersonPanel extends JPanel{
	
	private JLabel name,email,birthday,gender,height;
	protected JTextField NamePropertyComponent, EmailPropertyComponent, DateOfBirthComponent;
	protected JComboBox<Gender> GenderPropertyComponent;
	protected JSlider HeightPropertyComponent;
	private BoundedRangeModel rangeModel;
	private Person person;
	
	public PersonPanel() {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,5,5,10);
		c.anchor = GridBagConstraints.LINE_START;
		
		rangeModel = new DefaultBoundedRangeModel(180,0,120,240);
		
		this.person = new Person();
		
		this.name = new JLabel("Name:");
		this.email = new JLabel("Email:");
		this.birthday = new JLabel("Birthday:");
		this.gender = new JLabel("Gender:");
		this.height = new JLabel("Height:");

		this.NamePropertyComponent = new JTextField(30);
		this.NamePropertyComponent.setName("NamePropertyComponent");
		this.EmailPropertyComponent = new JTextField(30);
		this.EmailPropertyComponent.setName("EmailPropertyComponent");
		this.DateOfBirthComponent = new JTextField(30);
		this.DateOfBirthComponent.setName("DateOfBirthPropertyComponent");
		this.GenderPropertyComponent = new JComboBox<Gender>(Gender.values());
		this.GenderPropertyComponent.setName("GenderPropertyComponent");
		this.HeightPropertyComponent = new JSlider(rangeModel);
		this.HeightPropertyComponent.setName("HeightPropertyComponent");
		
		this.NamePropertyComponent.addKeyListener(new TextChangeHandler());
		this.EmailPropertyComponent.addKeyListener(new TextChangeHandler());
		this.DateOfBirthComponent.addKeyListener(new TextChangeHandler());
		this.GenderPropertyComponent.addActionListener(new GenderChangeHandler());
		this.HeightPropertyComponent.addChangeListener(new HeightChangeHandler());
		
		add(name,GBC(c,0,0));
		add(NamePropertyComponent, GBC(c,1,0));
		
		add(email,GBC(c,0,1));
		add(EmailPropertyComponent, GBC(c,1,1));
		
		add(birthday,GBC(c,0,2));
		add(DateOfBirthComponent,GBC(c,1,2));
		
		GenderPropertyComponent.setSelectedIndex(1);
		add(gender,GBC(c,0,3));
		add(GenderPropertyComponent, GBC(c,1,3));
		
		add(height,GBC(c,0,4));
		HeightPropertyComponent.setPreferredSize(new Dimension(500,50));
		HeightPropertyComponent.setMajorTickSpacing(10);
		HeightPropertyComponent.setMinorTickSpacing(1);
		HeightPropertyComponent.setPaintTicks(true);
		HeightPropertyComponent.setPaintLabels(true);
		add(HeightPropertyComponent, GBC(c,1,4));

	}

	public void setModel(Person p){
		person = p;
		updateView();
	}
	
	private void updateView(){
		NamePropertyComponent.setText(person.getName());
		EmailPropertyComponent.setText(person.getEmail());
		DateOfBirthComponent.setText(person.getDateOfBirth());
		GenderPropertyComponent.setSelectedItem(person.getGender());
		HeightPropertyComponent.setValue(person.getHeight());
	}
		
	private void updateModel(){
		person.setName(NamePropertyComponent.getText());
		person.setEmail(EmailPropertyComponent.getText());
		person.setDateOfBirth(DateOfBirthComponent.getText());
		person.setGender((Gender) GenderPropertyComponent.getSelectedItem());
		person.setHeight(HeightPropertyComponent.getValue());
	}
	
	public Person getModel(){
		updateModel();
		return person;
	}
	
	private GridBagConstraints GBC (GridBagConstraints c, int x, int y){
		c.gridx = x;
		c.gridy = y;
		return c;
	}
	
	class TextChangeHandler implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
				updateModel();				
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class HeightChangeHandler implements ChangeListener{

		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			updateModel();
		}

	}
	
	class GenderChangeHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateModel();		
		}

		
	}
}
