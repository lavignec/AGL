package ihm;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

import bdd.BddAccess;
import org.eclipse.swt.widgets.List;

public class Login {
	private static Text loginfield;
	private static Text pwdfield;
	private static BddAccess bdd = new BddAccess ();

	/**
	 * Launch the application.
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(948, 512);
		shell.setText("SYGIME");
		    
		
		    final Composite composite = new Composite(shell, SWT.NONE);
		    composite.setBounds(0, 0, 932, 473);
		    
		    loginfield = new Text(composite,  SWT.BORDER);
		    loginfield.setBounds(140, 190, 137, 21);
		    
		    pwdfield = new Text(composite, SWT.PASSWORD | SWT.BORDER);
		    pwdfield.setLocation(140, 220);
		    pwdfield.setSize(137, 21);
		    pwdfield.setText("");
		    
		    final Label logintext = new Label(composite, SWT.NONE);
		    logintext.setBounds(58, 193, 55, 15);
		    logintext.setText("Login");
		    
		    final Label mdptext = new Label(composite, SWT.NONE);
		    mdptext.setBounds(58, 220, 76, 34);
		    mdptext.setText("Mot de passe");
		    
		    Button btnNewButton_1 = new Button(composite, SWT.NONE);
		    btnNewButton_1.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseDown(MouseEvent arg0) {
		    		
		    		String sqlQuery = "select (utilisateur_nom, utilisateur_mdp) from utilisateur where utilisateur_nom ='" + loginfield.getText() + "' and utilisateur_mdp ='" + pwdfield.getText()+"'" ;
		    		System.out.println(sqlQuery);
		    		ResultSet rs = null;
					try {
						rs = bdd.select(sqlQuery);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		try {
						if (rs.next())
						{
							composite.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, this,"mauvais mot de passe ou nom d'utilisateur", 0);
							
						}
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    });
		    btnNewButton_1.setBounds(140, 250, 75, 25);
		    btnNewButton_1.setText("Connexion");
		    
		    //Tab folder onglet
		    TabFolder folder = new TabFolder(shell, SWT.NONE);
		    folder.setLocation(0, 0);
		    folder.setSize(932, 473);
		    
		    //Onglet Vols
		    TabItem ongletvol = new TabItem(folder, SWT.NONE);
		    ongletvol.setText("Vols");
		    
		    Group vols_groupe = new Group(folder, SWT.NONE);
		    ongletvol.setControl(vols_groupe);
		    
		    Button btnDconnexion = new Button(vols_groupe, SWT.NONE);
		    btnDconnexion.setLocation(850, 420);
		    btnDconnexion.setSize(75, 25);
		    btnDconnexion.setText("D\u00E9connexion");
		    
		    //Onglet Escros
		    TabItem  ongletescroc = new TabItem(folder, SWT.NONE);
		    ongletescroc.setText("Escroc");
		    

		     Group escroc_groupe = new Group(folder, SWT.NONE);
		     
		    Label label = new Label(escroc_groupe, SWT.BORDER);
		    label.setText("Label in Tab 2");
		    label.setBounds(10, 26, 391, 79);
		    
		    Text text = new Text(escroc_groupe, SWT.NONE);
		    text.setText("Text in Tab 2");
		    text.setBounds(10, 200, 100, 100);
		    
		    ongletescroc.setControl(escroc_groupe);
		    
		    Button button = new Button(escroc_groupe, SWT.NONE);
		    button.setText("D\u00E9connexion");
		    button.setBounds(850, 420, 75, 25);
		    
		    TabItem ongletoeuvreart = new TabItem(folder, SWT.NONE);
		    ongletoeuvreart.setText("Oeuvre d'art");
		    
		    Group oeuvreart_group = new Group(folder, SWT.NONE);
		    ongletoeuvreart.setControl(oeuvreart_group);
		    
		    List list = new List(oeuvreart_group, SWT.BORDER);
		    list.setBounds(0, 0, 924, 113);
		    
		    Button ajouterbutton = new Button(oeuvreart_group, SWT.NONE);
		    ajouterbutton.addMouseListener(new MouseAdapter() {
		    	@Override
		    	public void mouseDown(MouseEvent arg0) {
		    		AddOeuvre ajout = new AddOeuvre();
		    		ajout.open();
		    	}
		    });
		    ajouterbutton.setLocation(850, 120);
		    ajouterbutton.setSize(75, 25);
		    ajouterbutton.setText("Ajouter");

		shell.open();
		shell.layout();
		

		
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
