package code.rmi.ClientUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import code.rmi.Interface.RemoteInterface;
import code.rmi.Server.ServerStart;
import code.rmi.ServerImp.DBFunctions;
import code.rmi.Util.Validator;
import code.rmi.ServerImp.DBFunctions;
import code.rmi.classes.Clientloging;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.rmi.*;

public class CusWelcomeUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtemail;
	static RemoteInterface stub;
	private JLabel lblerror;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException, MarshalException {
		String remoteHostName = "127.0.0.1";
		int remotePort = 1091;
		String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Server";
		try {
			stub = (RemoteInterface) Naming.lookup(connectLocation);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		} catch (NotBoundException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusWelcomeUI frame = new CusWelcomeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CusWelcomeUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 288);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblpic = new JLabel("");
		lblpic.setIcon(
				new ImageIcon(new javax.swing.ImageIcon(CusWelcomeUI.class.getResource("/code/rmi/Resources/44190.jpg"))
						.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
		lblpic.setBounds(306, 27, 231, 227);
		contentPane.add(lblpic);

		JButton btnlogin = new JButton("Questionnair Dashboard");
		btnlogin.addActionListener(new ActionListener() {
			public String username;

			public void actionPerformed(ActionEvent e) {
				repaint();
				String remoteHostName = "127.0.0.1";
				int remotePort = 1091;
				String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Server";
				System.setSecurityManager(new RMISecurityManager());

				if (code.rmi.Util.Validator.requiredFeildValidator(txtusername.getText())
						|| Validator.requiredFeildValidator(txtemail.getText())) {
					lblerror.setText("Please Fill The All Fields!");
				}else {
					try {
						stub = (RemoteInterface) Naming.lookup(connectLocation);
						username = txtusername.getText();
						String email = txtemail.getText();

						Clientloging add = new Clientloging();
						add.setUsername(username);
						add.setEmail(email);
						stub.add_client(add);
						if (txtemail.getText() != null && txtusername.getText() != null) {
							CusWelcomeUI.this.dispose();
							CusDashBoardUI.showwindow(username, stub);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnlogin.setForeground(Color.WHITE);
		btnlogin.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnlogin.setBackground(new Color(65, 105, 225));
		btnlogin.setBounds(24, 221, 272, 34);
		contentPane.add(btnlogin);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.GRAY);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmail.setBounds(24, 159, 76, 14);
		contentPane.add(lblEmail);

		txtusername = new JTextField();
		txtusername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtusername.setColumns(10);
		txtusername.setBounds(24, 114, 272, 34);
		contentPane.add(txtusername);

		JLabel lblusername = new JLabel("Username");
		lblusername.setForeground(Color.GRAY);
		lblusername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblusername.setBounds(24, 92, 76, 17);
		contentPane.add(lblusername);

		JLabel lblsubtopic = new JLabel("Continue to Face Questionnair");
		lblsubtopic.setForeground(Color.LIGHT_GRAY);
		lblsubtopic.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblsubtopic.setBounds(24, 51, 185, 14);
		contentPane.add(lblsubtopic);

		JLabel lblwelcome = new JLabel("Welcome Back!");
		lblwelcome.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblwelcome.setBounds(24, 27, 174, 24);
		contentPane.add(lblwelcome);

		txtemail = new JTextField();
		txtemail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtemail.setColumns(10);
		txtemail.setBounds(24, 176, 272, 34);
		contentPane.add(txtemail);

		JSeparator separator = new JSeparator();
		separator.setBounds(24, 146, 272, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 208, 272, 2);
		contentPane.add(separator_1);

		JLabel lblexit = new JLabel("X");
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure to close this programme", "Conformation",
						JOptionPane.YES_NO_OPTION) == 0) {
					CusWelcomeUI.this.dispose();
				}
			}
		});
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setForeground(Color.BLUE);
		lblexit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblexit.setBounds(515, 0, 22, 16);
		contentPane.add(lblexit);
		
		lblerror = new JLabel("");
		lblerror.setForeground(Color.RED);
		lblerror.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblerror.setBounds(24, 76, 272, 14);
		contentPane.add(lblerror);
		setUndecorated(true);
	}
}
