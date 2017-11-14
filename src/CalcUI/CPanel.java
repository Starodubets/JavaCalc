package CalcUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CalcLogic.CalcAPI;
import CalcLogic.LibI;
import CalcLogic.MockLIB;


public class CPanel extends JPanel 
{
	private int a=0;
	private String op= "+";
	JTextField text_field;
	
	public CPanel() 
	{		
		createButtons();
		setLayout(new GridLayout(4, 5));
		
		text_field = new JTextField();
		text_field.setName("result");
		add(text_field);
	}
	
	
	private void createButtons()
	{	
		ActionClass actionEvent = new ActionClass();
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		buttons.add(new JButton("+"));
		buttons.add(new JButton("-"));
		buttons.add(new JButton("*"));	
		buttons.add(new JButton("/"));
		buttons.add(new JButton("0"));	
		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));
		buttons.add(new JButton("4"));
		buttons.add(new JButton("5"));
		buttons.add(new JButton("6"));
		buttons.add(new JButton("7"));
		buttons.add(new JButton("8"));		
		buttons.add(new JButton("9"));	
		buttons.add(new JButton("C"));
		buttons.add(new JButton("="));
		
		for(JButton b : buttons)
		{
			add(b);
			b.setName(b.getText());
			b.addActionListener(actionEvent);
		}		
	}

	class ActionClass implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String caption = ((JButton) e.getSource()).getText();
	        if(caption == "+" || caption == "-" ||
	        		caption == "/" || caption == "*")
	        {
	        	a = Integer.valueOf(text_field.getText());
				op = caption;
				text_field.setText("");
	
	        }
	        else if(caption == "C")
		    {
	        	a = 0;
				op="+";
				text_field.setText("");	
		    }
	        else if(caption == "=")
	        {
	        	LibI calc = new MockLIB();
	        	int b = Integer.valueOf(text_field.getText());
				int result = calc.Calc(a,b,op);
				text_field.setText("" + result);
	        }
	        else
	        {
	        	int num = Integer.valueOf(caption);
	        	text_field.setText(text_field.getText()+num);
	        }
		}
	}
}

