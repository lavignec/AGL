package ihm;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import ihm.Login;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class AddOeuvre {
	private Text nomtext;
	private Text statuttext;
	private ResultSet rs = null;
	private String imageoeuvre = null;
	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent arg0) {
				Login.shell.setEnabled(true);
			}
		});
		shell.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Login.shell.setEnabled(false);
			}
		});
		shell.setSize(565, 296);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		Group addoeuvreart = new Group(shell, SWT.NONE);
		FormData fd_addoeuvreart = new FormData();
		fd_addoeuvreart.bottom = new FormAttachment(0, 382);
		fd_addoeuvreart.right = new FormAttachment(0, 259);
		fd_addoeuvreart.top = new FormAttachment(0);
		fd_addoeuvreart.left = new FormAttachment(0);
		addoeuvreart.setLayoutData(fd_addoeuvreart);
		addoeuvreart.setLayout(new GridLayout(2, false));
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		
		Label lblNom = new Label(addoeuvreart, SWT.NONE);
		lblNom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNom.setText("Nom");
		
		nomtext = new Text(addoeuvreart, SWT.BORDER);
		nomtext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPrnom = new Label(addoeuvreart, SWT.NONE);
		lblPrnom.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false, 1, 1));
		lblPrnom.setText("Statut");
		
		statuttext = new Text(addoeuvreart, SWT.BORDER);
		statuttext.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label epoque = new Label(addoeuvreart, SWT.NONE);
		epoque.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		epoque.setText("Epoque");
		
		final Combo epoquecombo = new Combo(addoeuvreart, SWT.READ_ONLY);
		epoquecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label Ecole = new Label(addoeuvreart, SWT.NONE);
		Ecole.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		Ecole.setText("Ecole");
		
		final Combo ecolecombo = new Combo(addoeuvreart, SWT.READ_ONLY);
		ecolecombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				ecolecombo.setText(ecolecombo.getText());
			}
		});
		ecolecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		final Label image = new Label(shell, SWT.NONE);
		FormData fd_image = new FormData();
		fd_image.top = new FormAttachment(0, 10);
		fd_image.right = new FormAttachment(addoeuvreart, 283, SWT.RIGHT);
		fd_image.left = new FormAttachment(addoeuvreart, 3);
		
		Label lblType = new Label(addoeuvreart, SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setText("Type");
		
		final Combo typecombo = new Combo(addoeuvreart, SWT.READ_ONLY);
		typecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		new Label(addoeuvreart, SWT.NONE);
		
		Button addoeuvre = new Button(addoeuvreart, SWT.NONE);
		addoeuvre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez vous vraiment ajouter cette oeuvre d'art à la base de données ?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION)
				{
					String epoque_id = "";
					String ecole_id = "";
					String type_id = "";
					
					//epoque ID
					try {
						rs = Login.bdd.select("select epoque_id from EpoqueObjet where epoque_valeur = '" + epoquecombo.getText() + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						epoque_id = rs.getString(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					//ecole ID
					try {
						rs = Login.bdd.select("select ecole_id from EcoleObjet where ecole_valeur = '" + ecolecombo.getText() + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						ecole_id = rs.getString(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					//type ID
					try {
						rs = Login.bdd.select("select type_id from TypeObjet where type_valeur = '" + typecombo.getText() + "'");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						type_id = rs.getString(1);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
					try {
						Login.bdd.insert("insert into Oeuvre (epoque_id, ecole_id, type_id, oeuvre_nom, oeuvre_photo, oeuvre_statut, oeuvre_proprietaire) values (" + epoque_id + ",'" + ecole_id + "','"+ type_id +"', " + nomtext.getText() + ", '"+ imageoeuvre+"', '"+statuttext+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		GridData gd_addoeuvre = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_addoeuvre.widthHint = 199;
		addoeuvre.setLayoutData(gd_addoeuvre);
		addoeuvre.setText("Ajouter");
		image.setLayoutData(fd_image);
		
		try {
			rs = Login.bdd.select("select ecole_valeur from EcoleObjet");
			while (rs.next())
			{
				ecolecombo.add(rs.getString(1));
			}
			rs = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		
		Button filepicker = new Button(shell, SWT.NONE);
		fd_image.bottom = new FormAttachment(filepicker, -6);
		filepicker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				
				FileDialog dialog = new FileDialog(shell, SWT.OPEN);

				  dialog.setText("Load project");
				  dialog.setFilterPath("");
				  dialog.setFilterExtensions(new String[] { "*.png", "*.bmp", "*.jpg", "*.jpeg" });
				  String filename = dialog.open();

				  if (filename != null)
				  {
					Image img = new Image(display, filename);
					image.setImage(img);
					imageoeuvre = filename;
					
				  }
			}
		});
		FormData fd_filepicker = new FormData();
		fd_filepicker.bottom = new FormAttachment(100, -10);
		fd_filepicker.right = new FormAttachment(100, -10);
		filepicker.setLayoutData(fd_filepicker);
		filepicker.setText("Choisissez votre image");
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
