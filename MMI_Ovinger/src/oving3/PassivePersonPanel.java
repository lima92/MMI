package oving3;

import java.awt.GridBagConstraints;
import java.beans.PropertyChangeEvent;

import javax.swing.JTextField;

public class PassivePersonPanel extends PersonPanel {

	JTextField passiveGender, passiveHeight;
	
	public PassivePersonPanel(){
		super();
		NamePropertyComponent.setEditable(false);
		EmailPropertyComponent.setEditable(false);
		DateOfBirthComponent.setEditable(false);
		this.remove(GenderPropertyComponent);
		this.remove(HeightPropertyComponent);
		
		passiveGender = new JTextField(30);
		passiveHeight = new JTextField(30);
		passiveGender.setEditable(false);
		passiveHeight.setEditable(false);
		
		passiveGender.setText(super.GenderPropertyComponent.getSelectedItem().toString());
		passiveHeight.setText(String.valueOf(super.HeightPropertyComponent.getValue()));
		
		add(passiveGender,GBC(new GridBagConstraints(),1,3));
		add(passiveHeight,GBC(new GridBagConstraints(),1,4));
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()){
			case Person.NAME_PROPERTY:
				NamePropertyComponent.setText(model.getName());
			case Person.EMAIL_PROPERTY:
				EmailPropertyComponent.setText(model.getEmail());
			case Person.DOB_PROPERTY:
				DateOfBirthComponent.setText(model.getDateOfBirth());
			case Person.GENDER_PROPERTY:
				passiveGender.setText(model.getGender().toString());
			case Person.HEIGHT_PROPERTY:
				passiveHeight.setText(String.valueOf(model.getHeight()));
		}
	}
}
