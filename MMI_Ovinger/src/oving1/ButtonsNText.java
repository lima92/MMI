package oving1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class ButtonsNText extends JPanel{
	
	private JTextField TextLine;
	private JToggleButton UpperCaseButton, LowerCaseButton;
	private JCheckBox ContinuousButton;
	
	public ButtonsNText(){
		TextLine = new JTextField(40);
		TextLine.addKeyListener(new TextLineAction());
		TextLine.setName("TextLine");
		add(TextLine);
			
		UpperCaseButton = new JToggleButton("Upper case");
		UpperCaseButton.addActionListener(new UpperCaseButtonAction());
		UpperCaseButton.setName("UpperCaseButton");
		add(UpperCaseButton);
		
		LowerCaseButton = new JToggleButton("Lower case");
		LowerCaseButton.addActionListener(new LowerCaseButtonAction());
		LowerCaseButton.setName("LowerCaseButton");
		add(LowerCaseButton);
		
		ContinuousButton = new JCheckBox("Continuous?");
		ContinuousButton.setName("ContinuousButton");
		add(ContinuousButton);
	}
	
	
	private void toUpper(){
		int p = TextLine.getCaretPosition();
		TextLine.setText(TextLine.getText().toUpperCase());
		TextLine.setCaretPosition(p);
	}
	
	private void toLower(){
		int p = TextLine.getCaretPosition();
		TextLine.setText(TextLine.getText().toLowerCase());
		TextLine.setCaretPosition(p);
	}
	
	
	class UpperCaseButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(LowerCaseButton.isSelected()){
				LowerCaseButton.setSelected(false);
			}
			toUpper();
		}
	}
	
	class LowerCaseButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			if(UpperCaseButton.isSelected()){
				UpperCaseButton.setSelected(false);
			}
			toLower();
		}
	}
	
	class TextLineAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
				if(UpperCaseButton.isSelected()){
					toUpper();
				}else if(LowerCaseButton.isSelected()){
					toLower();
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(ContinuousButton.isSelected()){
				toUpper();
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	
	
	}
	

	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ButtonsNText());
		frame.pack();
		frame.setVisible(true);
	}

}
