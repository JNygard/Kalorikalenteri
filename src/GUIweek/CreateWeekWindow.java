package GUIweek;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.AdapterDay;
import DB.AdapterWeek;
import GUImain.DataView;
import GUImain.MainWindow;
import GUImain.MainWindowBuilder;
import Model.Day;
import Model.Week;

public class CreateWeekWindow extends JFrame{
	
	//String
	private static String title = "Viikkoaikataulu";
	
	
	//Dimensions
	private static int windowWidth = 300;
	private static int windowHeigth = 200;
	
	private static int fieldLength = 200;
	private static int TFheigth = 30;
	private static int TAheigth = 60;
	
	//View
	protected static JPanel inner = new JPanel();
	protected static Box contents = Box.createVerticalBox();
	
	protected static JPanel buttonPanel = new JPanel(new GridLayout(1,2));
	
	protected static JLabel Lname = new JLabel("Nimi:      ");
	protected static JLabel Ldescription = new JLabel("Kuvaus: ");
	protected static JTextField TFname = new JTextField();
	protected static JTextArea TAdescription = new JTextArea();
	
	protected static JButton BTready = new JButton("Valmis");
	protected static JButton BTcancel = new JButton("Peruuta");
	
	
	//DB
	protected static  AdapterWeek aweek= new AdapterWeek();
	protected static  AdapterDay aday = new AdapterDay();
	
	//Content
	protected static Week editWeek = null;

	public CreateWeekWindow() {
		super(title);
		
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		 buildWindow();
		 setListeners();
		
		this.getContentPane().add(inner);
		

		
	}
	
	
	//Set listeners
	private void setListeners() {
		
		//BT
		BTready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addWeek();
			}});
		//BT
		BTcancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
		
	}


	private void buildWindow() {
		Box b1 = Box.createHorizontalBox();
		TFname.setPreferredSize(new Dimension(this.fieldLength,this.TFheigth));
		b1.add(Lname);
		b1.add(TFname);
		contents.add(b1);
		
		Box b2 = Box.createHorizontalBox();
		
		TAdescription.setPreferredSize(new Dimension(this.fieldLength,this.TAheigth));
		b2.add(Ldescription);
		b2.add(TAdescription);
		contents.add(b2);
		
		inner.add(contents);
		
		buttonPanel.add(BTcancel);
		buttonPanel.add(BTready);
		inner.add(buttonPanel);
		
		
	}
	
	//Edit week
	public void editWeek(Week w) {
		editWeek = w;
		setTitle("Muokkaa viikkoaikataulun tietoja");
		
		TFname.setText(w.getName());
		TAdescription.setText(w.getDescription());
		
		
	}
	
	//New week
	public void newWeek() {
		editWeek = null;
		setTitle("Uusi viikkoaikataulu");
		
		TFname.setText("");;
		TAdescription.setText("");
		
		
	}
	
	
	
	
	//Add week
	private void addWeek() {
		String name = TFname.getText();
		String description = TAdescription.getText();
		
		if(name.length()<2) {
			showMessage("Anna vähintään 2 merkkiä pitkä nimi");
			return;
		}
		
		if(aweek.get(name)==null || editWeek!=null) {
			
			if(editWeek==null) {
				Week w = aweek.add(new Week(0,name,description)); //Create Week
				
				int x = 1;
				while(x<=7) {
					aday.add(new Day(0,x,w.getId(),null)); //Create days to week (AdapterWeek job?)
					x++;
				}
			}else {
				editWeek.setName(name);
				editWeek.setDescription(description);
				aweek.update(editWeek);
			}
			MainWindow.updateWeekView();
			emptyWeek();
			CloseFrame();
			
		}else {
			showMessage("Nimi on jo käytössä. Valitse toinen");
		}
		
		
	}
	
	//Empty week
	private void emptyWeek() {
		TFname.setText("");
		TAdescription.setText("");
		
	}
	
	//---------------------------------------------------------------------------------------------
	
	//Confirm dialog
	public static boolean confirm(String title, String msg) {
		Object[] options = {"Peruuta", "Kyllä"};
		int n = JOptionPane.showOptionDialog(inner,msg,title,
		    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
		    null,options,options[1]);
				
		if(n==1) {
			return true;
		}
		return false;
	}
	
	//Show dialog message
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(inner, msg);
	}
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}

	//Hide
	@Override
	public void hide() {
		super.hide();
		DataView.setSelectedWeek();
	}
	
	

}
