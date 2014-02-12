package oving4;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import oving2.Gender;
import oving3.Person;

public class PersonRendrer extends JLabel implements ListCellRenderer{
    final static ImageIcon maleIcon = new ImageIcon("male.png");
    final static ImageIcon femaleIcon = new ImageIcon("female.png");
	
	
	@Override
	public Component getListCellRendererComponent(
			JList list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus) 
	{
        String s = value.toString();
        setText(s+"..");
        setIcon((((Person) value.getClass().cast(Person.class)).getGender() == Gender.MALE) ? maleIcon : femaleIcon);
        
        if (isSelected) {
            setBackground(list.getSelectionBackground());
              setForeground(list.getSelectionForeground());
          }
        else {
              setBackground(list.getBackground());
              setForeground(list.getForeground());
          }
        setEnabled(list.isEnabled());
        setFont(list.getFont());
        setOpaque(true);
        return this;
	}



}
