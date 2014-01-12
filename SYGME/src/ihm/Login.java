package ihm;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Login {
	private static Text loginfield;
	private static Text pwdfield;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(528, 414);
		shell.setText("SYGIME");
		    
		    final Composite composite = new Composite(shell, SWT.NONE);
		    composite.setBounds(0, 0, 512, 375);
		    
		    loginfield = new Text(composite,  SWT.BORDER);
		    loginfield.setBounds(140, 190, 137, 21);
		    
		    pwdfield = new Text(composite, SWT.PASSWORD | SWT.BORDER);
		    pwdfield.setLocation(140, 220);
		    pwdfield.setSize(137, 21);
		    pwdfield.setText("");
		    
		    Label lblNewLabel = new Label(composite, SWT.NONE);
		    lblNewLabel.setBounds(58, 193, 55, 15);
		    lblNewLabel.setText("Login");
		    
		    Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		    lblNewLabel_1.setBounds(58, 220, 76, 34);
		    lblNewLabel_1.setText("Mot de passe");
		    
		    Button btnNewButton_1 = new Button(composite, SWT.NONE);
		    btnNewButton_1.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseDown(MouseEvent arg0) {
		    		composite.dispose();
		    	}
		    });
		    btnNewButton_1.setBounds(140, 250, 75, 25);
		    btnNewButton_1.setText("Connexion");
		    
		    //Tab folder onglet
		    TabFolder folder = new TabFolder(shell, SWT.NONE);
		    folder.setSize(512, 375);
		    
		    //Onglet Vols
		    TabItem ongletvol = new TabItem(folder, SWT.NONE);
		    ongletvol.setText("Vols");
		    
		    //Onglet Escros
		    TabItem  ongletescroc = new TabItem(folder, SWT.NONE);
		    ongletescroc.setText("Escroc");
		    

		     Group group = new Group(folder, SWT.NONE);
		     group.setText("Group in Tab 2");
		     
		    Label label = new Label(group, SWT.BORDER);
		    label.setText("Label in Tab 2");
		    label.setBounds(10, 26, 391, 79);
		    
		    Text text = new Text(group, SWT.NONE);
		    text.setText("Text in Tab 2");
		    text.setBounds(10, 200, 100, 100);
		    
		    ongletescroc.setControl(group);
		    
		    Button btnNewButton = new Button(group, SWT.NONE);
		    btnNewButton.setBounds(167, 142, 75, 25);
		    btnNewButton.setText("New Button");

		shell.open();
		shell.layout();
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
