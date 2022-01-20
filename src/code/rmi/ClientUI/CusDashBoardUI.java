package code.rmi.ClientUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import code.rmi.Interface.RemoteInterface;
import code.rmi.Util.Email;
import code.rmi.Util.Validator;
import code.rmi.classes.FinalResult;
import code.rmi.classes.OrderDetails;
import code.rmi.classes.Questions;
import code.rmi.classes.Sugestions;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;

public class CusDashBoardUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOName;
	private JTextField txtOContact;
	private JPanel panQ;
	private JPanel panQ2;
	private JPanel panOrder;
	private JPanel panWelcome;
	private JPanel panFin;
	private JLayeredPane layer;
	private JPanel panTank;
	private JPanel panSug;
	int index = 0;
	boolean finish = false;
	static RemoteInterface localStub;
	static ArrayList<String> selectedAnswers = new ArrayList<String>();
	JRadioButton rdoOptionOne = new JRadioButton("");
	JRadioButton rdoOptionTwo = new JRadioButton("");
	JRadioButton rdoOptionThree = new JRadioButton("");
	JRadioButton rdoOptionFour = new JRadioButton("");
	JRadioButton rdoOptionFive = new JRadioButton("");
	JRadioButton rdoOptionSix = new JRadioButton("");
	JRadioButton rdoOptionSeven = new JRadioButton("");
	JRadioButton rdoOptionEight = new JRadioButton("");
	ButtonGroup radioGroup1 = new ButtonGroup();
	ButtonGroup radioGroup2 = new ButtonGroup();
	ButtonGroup radioGroup3 = new ButtonGroup();
	ButtonGroup radioGroup4 = new ButtonGroup();
	ButtonGroup radioGroup5 = new ButtonGroup();
	ButtonGroup radioGroup6 = new ButtonGroup();
	ButtonGroup radioGroup7 = new ButtonGroup();
	ButtonGroup radioGroup8 = new ButtonGroup();
	private JRadioButton radcon1;
	private JRadioButton radcon2;
	private JRadioButton radFuel4;
	private JRadioButton radFuel3;
	private JRadioButton radFuel2;
	private JRadioButton radFuel1;
	private JRadioButton radPrice4;
	private JRadioButton radPrice3;
	private JRadioButton radPrice2;
	private JRadioButton radPrice1;
	private JRadioButton radCol4;
	private JRadioButton radCol3;
	private JRadioButton radCol2;
	private JRadioButton radCol1;
	private JRadioButton radEng4;
	private JRadioButton radEng3;
	private JRadioButton radEng2;
	private JRadioButton radEng1;
	private JRadioButton radcon3;
	private JRadioButton radbody1;
	private JRadioButton radbody2;
	private JRadioButton radbody3;
	private JRadioButton raddis1;
	private JRadioButton raddis2;
	private JRadioButton radwar1;
	private JRadioButton radwar2;
	static RemoteInterface stub;
	private JTextArea txtSug;
	private JTable tabledata;
	private static String username;
	private JLabel lblerror2;
	private JLabel lblerror3;
	private JTextField txtEmailAddress;
	private JLabel lblerror;
	private JLabel lblerror6;
	private JLabel lblerror5;
	private JPanel panelEmail;
	/**
	 * Launch the application.
	 */

	public void switchPan(JPanel panel) {
		layer.removeAll();
		layer.add(panel);
		layer.repaint();
		layer.revalidate();
		
		
	}
	

	/**
	 * Create the frame.
	 */
	
	
	public CusDashBoardUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 667);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLUE, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpro = new JLabel("");
		lblpro.setIcon(new ImageIcon(new javax.swing.ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/user.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		lblpro.setBounds(10, 11, 80, 85);
		contentPane.add(lblpro);
		
		JPanel paneTopic = new JPanel();
		paneTopic.setLayout(null);
		paneTopic.setBorder(null);
		paneTopic.setBackground(new Color(0, 191, 255));
		paneTopic.setBounds(72, 28, 665, 51);
		contentPane.add(paneTopic);
		
		JLabel lblportel = new JLabel("CustomerPortal");
		lblportel.setForeground(Color.WHITE);
		lblportel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblportel.setBounds(37, 11, 193, 29);
		paneTopic.add(lblportel);
		
		layer = new JLayeredPane();
		layer.setBorder(new LineBorder(Color.BLUE));
		layer.setBounds(10, 228, 716, 428);
		contentPane.add(layer);
		layer.setLayout(new CardLayout(0, 0));
		
		panWelcome = new JPanel();
		panWelcome.setBorder(new LineBorder(Color.BLUE));
		panWelcome.setBackground(Color.WHITE);
		layer.add(panWelcome, "name_518773503330700");
		panWelcome.setLayout(null);
		
		JLabel lblWelcome = new JLabel("");
		lblWelcome.setIcon(new ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/welcome_PNG115.png")));
		lblWelcome.setBounds(142, 40, 450, 256);
		panWelcome.add(lblWelcome);
		
		panFin = new JPanel();
		panFin.setBorder(new LineBorder(Color.BLUE));
		panFin.setBackground(Color.WHITE);
		layer.add(panFin, "name_518773539156700");
		panFin.setLayout(null);
		
		JLabel lblshowresult = new JLabel("Show the results According to Your Requirements");
		lblshowresult.setForeground(Color.LIGHT_GRAY);
		lblshowresult.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblshowresult.setBounds(22, 11, 348, 21);
		panFin.add(lblshowresult);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(22, 30, 342, 2);
		panFin.add(separator_1);
		
		
		JButton btnorder = new JButton("Order");
		btnorder.setBorder(new LineBorder(Color.GREEN));
		btnorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPan(panOrder);
			}
		});
		btnorder.setBackground(Color.GREEN);
		btnorder.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnorder.setBounds(36, 335, 129, 38);
		panFin.add(btnorder);
		
		JButton btnpdf = new JButton("Download Result as a PDF");
		btnpdf.setBorder(new LineBorder(Color.GREEN));
		btnpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Document document=new Document();
					PdfWriter.getInstance(document, new FileOutputStream("FinalResultReport.pdf"));
					document.open();
					document.add(new Paragraph("----------Bike Details----------",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE)));
					document.add(new Paragraph(new Date().toString()));
					document.add(new Paragraph("-------------------------------------------------------------------------------------------------"));
					PdfPTable table=new PdfPTable(9);
					PdfPCell cell=new PdfPCell(new Paragraph("Admin Add Bike Details"));
					cell.setColspan(4);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GREEN);
					table.addCell("Bike Name");
					table.addCell("Engine");
					table.addCell("Color");
					table.addCell("Price");
					table.addCell("Fuel");
					table.addCell("Made");
					table.addCell("Body");
					table.addCell("Display");
					table.addCell("Warrenty");
					for(int i=0;i<tabledata.getRowCount();i++) {
						String BikeName=tabledata.getValueAt(i, 0).toString();
						String Engine=tabledata.getValueAt(i, 1).toString();
						String Price=tabledata.getValueAt(i, 2).toString();
						String Fuel=tabledata.getValueAt(i, 3).toString();
						String Made=tabledata.getValueAt(i, 4).toString();
						String Body=tabledata.getValueAt(i, 5).toString();
						String Color=tabledata.getValueAt(i, 6).toString();
						String Display=tabledata.getValueAt(i, 7).toString();
						String Warrenty=tabledata.getValueAt(i, 8).toString();
						
						table.addCell(BikeName);
						table.addCell(Engine);
						table.addCell(Price);
						table.addCell(Fuel);
						table.addCell(Made);
						table.addCell(Body);
						table.addCell(Color);
						table.addCell(Display);
						table.addCell(Warrenty);
					}
					document.add(table);
					
					document.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnpdf.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnpdf.setBackground(Color.GREEN);
		btnpdf.setBounds(187, 335, 213, 38);
		panFin.add(btnpdf);
		
		JButton btnsuggestions = new JButton("Suggestions");
		btnsuggestions.setBorder(new LineBorder(Color.GREEN));
		btnsuggestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPan(panSug);
			}
		});
		btnsuggestions.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnsuggestions.setBackground(Color.GREEN);
		btnsuggestions.setBounds(550, 335, 129, 38);
		panFin.add(btnsuggestions);
		
		tabledata = new JTable();
		tabledata.setBorder(new LineBorder(Color.BLUE));
		tabledata.setBounds(22, 73, 657, 231);
		panFin.add(tabledata);
		
		JButton btnresult = new JButton("Show Result");
		btnresult.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnresult.addActionListener(new ActionListener() {
			@SuppressWarnings("serial")
			public void actionPerformed(ActionEvent e) {
				clickt();
			}
		});
		btnresult.setBounds(22, 43, 160, 23);
		panFin.add(btnresult);
		
		JButton btnEmail = new JButton("Send Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPan(panelEmail);
			}
		});
		btnEmail.setBorder(new LineBorder(Color.GREEN));
		btnEmail.setBackground(Color.GREEN);
		btnEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEmail.setBounds(410, 335, 130, 38);
		panFin.add(btnEmail);
		
		panQ = new JPanel();
		panQ.setBorder(new LineBorder(Color.BLUE));
		panQ.setBackground(Color.WHITE);
		layer.add(panQ, "name_518773557147800");
		panQ.setLayout(null);
		
		JLabel lblThankyou = new JLabel("Thank you for taking the time to answer this questions ");
		lblThankyou.setForeground(Color.LIGHT_GRAY);
		lblThankyou.setBackground(Color.LIGHT_GRAY);
		lblThankyou.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblThankyou.setBounds(10, 11, 382, 28);
		panQ.add(lblThankyou);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(10, 37, 375, 2);
		panQ.add(separator);
		
		JLabel lblEngine = new JLabel("1.\tExpecting Engine Capacity");
		lblEngine.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEngine.setBounds(10, 79, 272, 20);
		panQ.add(lblEngine);
		
		radEng1 = new JRadioButton("100CC-125CC");
		radEng1.setBackground(Color.WHITE);
		radEng1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radEng1.setBounds(71, 106, 129, 23);
		radioGroup1.add(radEng1);
		panQ.add(radEng1);
		
		radEng2 = new JRadioButton("125CC-150CC");
		radEng2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radEng2.setBackground(Color.WHITE);
		radEng2.setBounds(223, 106, 129, 23);
		radioGroup1.add(radEng2);
		panQ.add(radEng2);
		
		radEng3 = new JRadioButton("150CC-200CC");
		radEng3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radEng3.setBackground(Color.WHITE);
		radEng3.setBounds(377, 107, 129, 23);
		radioGroup1.add(radEng3);
		panQ.add(radEng3);
		
		radEng4 = new JRadioButton("200CC-250CC");
		radEng4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radEng4.setBackground(Color.WHITE);
		radEng4.setBounds(532, 107, 129, 23);
		radioGroup1.add(radEng4);
		panQ.add(radEng4);
		
		JLabel lblColor = new JLabel("2.\tExpecting Color");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblColor.setBounds(10, 142, 272, 20);
		panQ.add(lblColor);
		
		radCol1 = new JRadioButton("Black");
		radCol1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radCol1.setBackground(Color.WHITE);
		radCol1.setBounds(71, 169, 129, 23);
		radioGroup2.add(radCol1);
		panQ.add(radCol1);
		
		radCol2 = new JRadioButton("Gray");
		radCol2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radCol2.setBackground(Color.WHITE);
		radCol2.setBounds(223, 169, 129, 23);
		radioGroup2.add(radCol2);
		panQ.add(radCol2);
		
		radCol3 = new JRadioButton("Red");
		radCol3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radCol3.setBackground(Color.WHITE);
		radCol3.setBounds(377, 170, 129, 23);
		radioGroup2.add(radCol3);
		panQ.add(radCol3);
		
		radCol4 = new JRadioButton("Blue");
		radCol4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radCol4.setBackground(Color.WHITE);
		radCol4.setBounds(532, 170, 129, 23);
		radioGroup2.add(radCol4);
		panQ.add(radCol4);
		
		JLabel lblPrice = new JLabel("3.\tExpecting Price");
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPrice.setBounds(10, 204, 272, 20);
		panQ.add(lblPrice);
		
		radPrice1 = new JRadioButton("LKR 200000-300000");
		radPrice1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radPrice1.setBackground(Color.WHITE);
		radPrice1.setBounds(71, 231, 150, 23);
		radioGroup3.add(radPrice1);
		panQ.add(radPrice1);
		
		radPrice2 = new JRadioButton("LKR 300000-400000");
		radPrice2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radPrice2.setBackground(Color.WHITE);
		radPrice2.setBounds(223, 231, 152, 23);
		radioGroup3.add(radPrice2);
		panQ.add(radPrice2);
		
		radPrice3 = new JRadioButton("LKR 400000-500000");
		radPrice3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radPrice3.setBackground(Color.WHITE);
		radPrice3.setBounds(377, 232, 153, 23);
		radioGroup3.add(radPrice3);
		panQ.add(radPrice3);
		
		radPrice4 = new JRadioButton("LKR 500000-600000");
		radPrice4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radPrice4.setBackground(Color.WHITE);
		radPrice4.setBounds(532, 232, 153, 23);
		radioGroup3.add(radPrice4);
		panQ.add(radPrice4);
		
		JLabel lblFuel = new JLabel("4.\tFuel efficiency");
		lblFuel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFuel.setBounds(10, 275, 272, 20);
		panQ.add(lblFuel);
		
		radFuel1 = new JRadioButton("35-40 Kmpl");
		radFuel1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radFuel1.setBackground(Color.WHITE);
		radFuel1.setBounds(71, 302, 129, 23);
		radioGroup4.add(radFuel1);
		panQ.add(radFuel1);
		
		radFuel2 = new JRadioButton("45-50 Kmpl");
		radFuel2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radFuel2.setBackground(Color.WHITE);
		radFuel2.setBounds(223, 302, 129, 23);
		radioGroup4.add(radFuel2);
		panQ.add(radFuel2);
		
		radFuel3 = new JRadioButton("55-65 Kmpl");
		radFuel3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radFuel3.setBackground(Color.WHITE);
		radFuel3.setBounds(377, 303, 129, 23);
		radioGroup4.add(radFuel3);
		panQ.add(radFuel3);
		
		radFuel4 = new JRadioButton("85-90 Kmpl");
		radFuel4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radFuel4.setBackground(Color.WHITE);
		radFuel4.setBounds(532, 303, 129, 23);
		radioGroup4.add(radFuel4);
		panQ.add(radFuel4);
		
		JButton btnNextQ = new JButton("Next Page");
		btnNextQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.rmi.Util.Validator.isSelection(radioGroup1) || Validator.isSelection(radioGroup2) || Validator.isSelection(radioGroup3) || Validator.isSelection(radioGroup4)) {
					lblerror2.setText("Please Answer The All Question Re-Check The Questions!");
				}else {
					switchPan(panQ2);
				}
			}
		});
		btnNextQ.setBackground(Color.GREEN);
		btnNextQ.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnNextQ.setBounds(545, 347, 116, 28);
		panQ.add(btnNextQ);
		
		lblerror2 = new JLabel("");
		lblerror2.setForeground(Color.RED);
		lblerror2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblerror2.setBounds(10, 50, 375, 18);
		panQ.add(lblerror2);
		
		panQ2 = new JPanel();
		panQ2.setBackground(Color.WHITE);
		layer.add(panQ2, "name_518773576620200");
		panQ2.setLayout(null);
		
		JLabel lblMade = new JLabel("5.\tMade in Country");
		lblMade.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMade.setBounds(10, 50, 272, 20);
		panQ2.add(lblMade);
		
		radcon1 = new JRadioButton("India");
		radcon1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radcon1.setBackground(Color.WHITE);
		radcon1.setBounds(71, 77, 129, 23);
		radioGroup5.add(radcon1);
		panQ2.add(radcon1);
		
		radcon2 = new JRadioButton("Japan");
		radcon2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radcon2.setBackground(Color.WHITE);
		radcon2.setBounds(223, 77, 129, 23);
		radioGroup5.add(radcon2);
		panQ2.add(radcon2);
		
		radcon3 = new JRadioButton("China");
		radcon3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radcon3.setBackground(Color.WHITE);
		radcon3.setBounds(377, 78, 129, 23);
		radioGroup5.add(radcon3);
		panQ2.add(radcon3);
		
		JLabel lblBody = new JLabel("6.\tBody Type");
		lblBody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBody.setBounds(10, 113, 272, 20);
		panQ2.add(lblBody);
		
		radbody1 = new JRadioButton("Naked");
		radbody1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radbody1.setBackground(Color.WHITE);
		radbody1.setBounds(71, 140, 129, 23);
		radioGroup6.add(radbody1);
		panQ2.add(radbody1);
		
		radbody2 = new JRadioButton("Commuter");
		radbody2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radbody2.setBackground(Color.WHITE);
		radbody2.setBounds(223, 140, 129, 23);
		radioGroup6.add(radbody2);
		panQ2.add(radbody2);
		
		radbody3 = new JRadioButton("Cruiser");
		radbody3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radbody3.setBackground(Color.WHITE);
		radbody3.setBounds(377, 141, 129, 23);
		radioGroup6.add(radbody3);
		panQ2.add(radbody3);
		
		JLabel lblDisplay = new JLabel("7.\tDisplay Type");
		lblDisplay.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDisplay.setBounds(10, 175, 272, 20);
		panQ2.add(lblDisplay);
		
		raddis1 = new JRadioButton("Analog");
		raddis1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		raddis1.setBackground(Color.WHITE);
		raddis1.setBounds(71, 202, 150, 23);
		radioGroup7.add(raddis1);
		panQ2.add(raddis1);
		
		raddis2 = new JRadioButton("Digital");
		raddis2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		raddis2.setBackground(Color.WHITE);
		raddis2.setBounds(223, 202, 152, 23);
		radioGroup7.add(raddis2);
		panQ2.add(raddis2);
		
		JLabel lblWarranty = new JLabel("8.\tWarranty");
		lblWarranty.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblWarranty.setBounds(10, 246, 272, 20);
		panQ2.add(lblWarranty);
		
		radwar1 = new JRadioButton("Yes");
		radwar1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radwar1.setBackground(Color.WHITE);
		radwar1.setBounds(71, 273, 129, 23);
		radioGroup8.add(radwar1);
		panQ2.add(radwar1);
		
		radwar2 = new JRadioButton("No");
		radwar2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		radwar2.setBackground(Color.WHITE);
		radwar2.setBounds(223, 273, 129, 23);
		radioGroup8.add(radwar2);
		panQ2.add(radwar2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.rmi.Util.Validator.isSelection(radioGroup5) || Validator.isSelection(radioGroup6) || Validator.isSelection(radioGroup7) || Validator.isSelection(radioGroup8)) {
					lblerror3.setText("Please Answer The All Question Re-Check The Questions!");
				}else {
					radclick();
					saveToDataBase();
					switchPan(panTank);
					clean();
				}
			}
		});
		btnSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSubmit.setBackground(Color.GREEN);
		btnSubmit.setBounds(10, 325, 116, 28);
		panQ2.add(btnSubmit);
		
		lblerror3 = new JLabel("");
		lblerror3.setForeground(Color.RED);
		lblerror3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblerror3.setBounds(10, 11, 420, 28);
		panQ2.add(lblerror3);
		
		panTank = new JPanel();
		panTank.setBackground(Color.WHITE);
		layer.add(panTank, "name_518773599119100");
		panTank.setLayout(null);
		
		JLabel lblThankYou = new JLabel("");
		lblThankYou.setIcon(new ImageIcon(new javax.swing.ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/pngwing.com.png")).getImage().getScaledInstance(450, 280, Image.SCALE_SMOOTH)));
		lblThankYou.setBounds(164, 45, 426, 286);
		panTank.add(lblThankYou);
		
		JLabel lblGiving = new JLabel("For Giving Your Valuble Time!");
		lblGiving.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblGiving.setBounds(371, 259, 224, 26);
		panTank.add(lblGiving);
		
		panOrder = new JPanel();
		panOrder.setBorder(new LineBorder(Color.BLUE));
		panOrder.setBackground(Color.WHITE);
		layer.add(panOrder, "name_518773623320700");
		panOrder.setLayout(null);
		
		JLabel lblPlace = new JLabel("Place Order");
		lblPlace.setBackground(Color.LIGHT_GRAY);
		lblPlace.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPlace.setBounds(10, 11, 87, 29);
		panOrder.add(lblPlace);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(10, 38, 87, 2);
		panOrder.add(separator_2);
		
		JLabel lblOName = new JLabel("Name");
		lblOName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblOName.setBounds(346, 83, 82, 29);
		panOrder.add(lblOName);
		
		txtOName = new JTextField();
		txtOName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtOName.setBounds(346, 110, 302, 36);
		panOrder.add(txtOName);
		txtOName.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(346, 144, 302, 2);
		panOrder.add(separator_3);
		
		JLabel lblOContact = new JLabel("Contct Details");
		lblOContact.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblOContact.setBounds(346, 167, 150, 29);
		panOrder.add(lblOContact);
		
		txtOContact = new JTextField();
		txtOContact.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtOContact.setColumns(10);
		txtOContact.setBounds(346, 194, 302, 36);
		panOrder.add(txtOContact);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(346, 228, 302, 2);
		panOrder.add(separator_3_1);
		
		JButton btnOSubmit = new JButton("Submit");
		btnOSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				if (code.rmi.Util.Validator.requiredFeildValidator(txtOName.getText())
						|| Validator.requiredFeildValidator(txtOContact.getText())) {
					lblerror5.setText("Please Fill The All Fields!");
				}
				else {
					String remoteHostName = "127.0.0.1";
					int remotePort = 1091;
					String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Server";
					System.setSecurityManager(new RMISecurityManager());
					try {
						stub = (RemoteInterface) Naming.lookup(connectLocation);
						String username=txtOName.getText();
						String contact=txtOContact.getText();
						
						OrderDetails add=new OrderDetails();
						add.setName(username);
						add.setContact(contact);
						stub.add_order(add);
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					switchPan(panTank);
					clean();
				}
		}});
		btnOSubmit.setBackground(Color.GREEN);
		btnOSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnOSubmit.setBounds(346, 259, 302, 29);
		panOrder.add(btnOSubmit);
		
		JLabel lblOrderPic = new JLabel("");
		lblOrderPic.setIcon(new ImageIcon(new javax.swing.ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/37781.jpg")).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
		lblOrderPic.setBounds(32, 92, 240, 200);
		panOrder.add(lblOrderPic);
		
		lblerror5 = new JLabel("");
		lblerror5.setForeground(Color.RED);
		lblerror5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblerror5.setBounds(346, 50, 302, 22);
		panOrder.add(lblerror5);
		
		panSug = new JPanel();
		panSug.setBackground(Color.WHITE);
		layer.add(panSug, "name_518773647612800");
		panSug.setLayout(null);
		
		JLabel lblAddSuggesstions = new JLabel("Add Sugesstions");
		lblAddSuggesstions.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblAddSuggesstions.setBackground(Color.LIGHT_GRAY);
		lblAddSuggesstions.setBounds(10, 11, 122, 29);
		panSug.add(lblAddSuggesstions);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBackground(Color.LIGHT_GRAY);
		separator_2_1.setBounds(10, 38, 111, 2);
		panSug.add(separator_2_1);
		
		JLabel lblSug = new JLabel("Suggestion");
		lblSug.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblSug.setBounds(346, 83, 82, 29);
		panSug.add(lblSug);
		
		JButton btnSug = new JButton("Submit");
		btnSug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
				if (code.rmi.Util.Validator.requiredFeildValidator(txtSug.getText())) {
					lblerror6.setText("Please Fill The All Fields!");
				}else {
					String remoteHostName = "127.0.0.1";
					int remotePort = 1091;
					String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Server";
					System.setSecurityManager(new RMISecurityManager());
					try {
						stub = (RemoteInterface) Naming.lookup(connectLocation);
						String sug=txtSug.getText();
						
						Sugestions add=new Sugestions();
						add.setCusSug(sug);
						stub.add_suge(add);
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					switchPan(panTank);
					clean();
				}
			}
		});
		btnSug.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSug.setBackground(Color.GREEN);
		btnSug.setBounds(346, 259, 302, 29);
		panSug.add(btnSug);
		
		txtSug = new JTextArea();
		txtSug.setBorder(new LineBorder(Color.BLUE));
		txtSug.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSug.setBounds(346, 109, 302, 139);
		panSug.add(txtSug);
		
		JLabel lblSugPic = new JLabel("");
		lblSugPic.setIcon(new ImageIcon(new javax.swing.ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/sug.png")).getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH)));
		lblSugPic.setBounds(41, 83, 240, 205);
		panSug.add(lblSugPic);
		
		lblerror6 = new JLabel("");
		lblerror6.setForeground(Color.RED);
		lblerror6.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblerror6.setBounds(346, 59, 302, 22);
		panSug.add(lblerror6);
		
		panelEmail = new JPanel();
		panelEmail.setBackground(Color.WHITE);
		layer.add(panelEmail, "name_234019715992700");
		panelEmail.setLayout(null);
		
		JLabel lblemail = new JLabel("Email Sender");
		lblemail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblemail.setBackground(Color.LIGHT_GRAY);
		lblemail.setBounds(10, 11, 122, 29);
		panelEmail.add(lblemail);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBackground(Color.LIGHT_GRAY);
		separator_2_1_1.setBounds(10, 38, 111, 2);
		panelEmail.add(separator_2_1_1);
		
		JLabel lblEmailPic = new JLabel("");
		lblEmailPic.setIcon(new ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/gmail (1).png")));
		lblEmailPic.setBounds(41, 83, 256, 205);
		panelEmail.add(lblEmailPic);
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblEmailAddress.setBounds(346, 83, 122, 29);
		panelEmail.add(lblEmailAddress);
		
		JButton btnEmailSender = new JButton("Send Email");
		btnEmailSender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (code.rmi.Util.Validator.requiredFeildValidator(txtEmailAddress.getText())) {
					lblerror.setText("Please Fill Field!");
				}else {
					String mail=txtEmailAddress.getText();
					Email a=new Email();
					try {
						a.sendMail(mail);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					switchPan(panTank);
					clean();
				}
			}
		});
		btnEmailSender.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnEmailSender.setBackground(Color.GREEN);
		btnEmailSender.setBounds(346, 182, 302, 29);
		panelEmail.add(btnEmailSender);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEmailAddress.setBorder(new LineBorder(Color.BLUE));
		txtEmailAddress.setBounds(346, 114, 302, 29);
		panelEmail.add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		lblerror = new JLabel("");
		lblerror.setForeground(Color.RED);
		lblerror.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblerror.setBounds(346, 149, 302, 22);
		panelEmail.add(lblerror);
		
		JPanel panelstart = new JPanel();
		panelstart.setBorder(new LineBorder(Color.BLUE));
		panelstart.setBackground(Color.WHITE);
		panelstart.setBounds(87, 107, 153, 110);
		contentPane.add(panelstart);
		panelstart.setLayout(null);
		
		JLabel lblpic1 = new JLabel("");
		lblpic1.setBounds(44, 11, 64, 67);
		panelstart.add(lblpic1);
		lblpic1.setIcon(new ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/questionnaire (3).png")));
		
		JButton btnQuestionnair = new JButton("Start Questionnair");
		btnQuestionnair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPan(panQ);
			}
		});
		btnQuestionnair.setBounds(10, 84, 139, 23);
		panelstart.add(btnQuestionnair);
		btnQuestionnair.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnQuestionnair.setBorder(null);
		btnQuestionnair.setBackground(new Color(250, 240, 230));
		
		JPanel panelreport = new JPanel();
		panelreport.setLayout(null);
		panelreport.setBorder(new LineBorder(Color.BLUE));
		panelreport.setBackground(Color.WHITE);
		panelreport.setBounds(316, 107, 153, 110);
		contentPane.add(panelreport);
		
		JLabel lplpic2 = new JLabel("");
		lplpic2.setIcon(new ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/report (1).png")));
		lplpic2.setBounds(44, 11, 64, 67);
		panelreport.add(lplpic2);
		
		JButton btnFinal = new JButton("Final Report");
		btnFinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPan(panFin);
			}
		});
		btnFinal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnFinal.setBorder(null);
		btnFinal.setBackground(new Color(250, 240, 230));
		btnFinal.setBounds(10, 84, 139, 23);
		panelreport.add(btnFinal);
		
		JPanel panelexit = new JPanel();
		panelexit.setLayout(null);
		panelexit.setBorder(new LineBorder(Color.BLUE));
		panelexit.setBackground(Color.WHITE);
		panelexit.setBounds(545, 107, 153, 110);
		contentPane.add(panelexit);
		
		JLabel lblpic3 = new JLabel("");
		lblpic3.setIcon(new ImageIcon(CusDashBoardUI.class.getResource("/code/rmi/Resources/exit (2).png")));
		lblpic3.setBounds(44, 11, 64, 67);
		panelexit.add(lblpic3);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CusDashBoardUI.this.dispose();
			}
		});
		btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnExit.setBorder(null);
		btnExit.setBackground(new Color(250, 240, 230));
		btnExit.setBounds(10, 84, 139, 23);
		panelexit.add(btnExit);
		setLocationRelativeTo(null);
		setUndecorated(true);
	}
	
	public static void showwindow(String name,RemoteInterface stub) {
		try {
			localStub = stub;
			username=name;
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CusDashBoardUI frame = new CusDashBoardUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void saveToDataBase() {
		try {
			String result = localStub.saveAnswer(selectedAnswers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void radclick() {
		Questions q = new Questions();
		String Cusname=null, Engine = null, Color = null,Price= null,Fuel= null,Made= null,Body= null,Display= null,Warranty= null;
		if(radEng1.isSelected()) {
			Engine="100-125";
		}
		else if(radEng2.isSelected()) {
			Engine="125-150";
		}
		else if(radEng3.isSelected()) {
			Engine="150-200";
		}
		else if(radEng4.isSelected()) {
			Engine="200-250";
		}
		q.setCusname(username);
		q.setAnswer1(Engine);
		
		//------------------------------------
		
		if(radCol1.isSelected()) {
			Color="Black";
		}
		if(radCol2.isSelected()) {
			Color="Gray";
		}
		if(radCol3.isSelected()) {
			Color="Red";
		}
		if(radCol4.isSelected()) {
			Color="Blue";
		}
		
		q.setAnswer2(Color);
		
		if(radPrice1.isSelected()) {
			Price="200000-300000";
		}
		if(radPrice2.isSelected()) {
			Price="300000-400000";
		}
		if(radPrice3.isSelected()) {
			Price="400000-500000";
		}
		if(radPrice4.isSelected()) {
			Price="500000-600000";
		}
		
		q.setAnswer3(Price);
		
		if(radFuel1.isSelected()) {
			Fuel="35-40";
		}
		if(radFuel2.isSelected()) {
			Fuel="45-50";
		}
		if(radFuel3.isSelected()) {
			Fuel="55-65";
		}
		if(radFuel4.isSelected()) {
			Fuel="85-90";
		}
		q.setAnswer4(Fuel);
		
		if(radcon1.isSelected()) {
			Made="India";
		}
		if(radcon2.isSelected()) {
			Made="Japan";
		}
		if(radcon3.isSelected()) {
			Made="China";
		}
		q.setAnswer5(Made);
		
		if(radbody1.isSelected()) {
			Body="Naked";
		}
		if(radbody2.isSelected()) {
			Body="Commuter";
		}
		if(radbody3.isSelected()) {
			Body="Cruiser";
		}
		q.setAnswer6(Body);
		if(raddis1.isSelected()) {
			Display="Analog";
		}
		if(raddis2.isSelected()) {
			Display="Digital";
		}
		q.setAnswer7(Display);
		if(radwar1.isSelected()) {
			Warranty="Yes";
		}
		if(radwar2.isSelected()) {
			Warranty="No";
		}
		q.setAnswer8(Warranty);
		
		
		//-------------------------------
		selectedAnswers.add(q.getCusname());
		selectedAnswers.add(q.getAnswer1());
		selectedAnswers.add(q.getAnswer2());
		selectedAnswers.add(q.getAnswer3());
		selectedAnswers.add(q.getAnswer4());
		selectedAnswers.add(q.getAnswer5());
		selectedAnswers.add(q.getAnswer6());
		selectedAnswers.add(q.getAnswer7());
		selectedAnswers.add(q.getAnswer8());
	}
	public void clean() {
		radioGroup1.clearSelection();
		radioGroup2.clearSelection();
		radioGroup3.clearSelection();
		radioGroup4.clearSelection();
		radioGroup5.clearSelection();
		radioGroup6.clearSelection();
		radioGroup7.clearSelection();
		radioGroup8.clearSelection();
		txtOContact.setText("");
		txtOName.setText("");
		txtSug.setText("");
		txtEmailAddress.setText("");
	}
	@SuppressWarnings("serial")
	public void clickt() {
		try {
			String remoteHostName = "127.0.0.1";
			int remotePort = 1091;
			String connectLocation = "//" + remoteHostName + ":" + remotePort + "/Server";
			System.setSecurityManager(new RMISecurityManager());
			stub = (RemoteInterface) Naming.lookup(connectLocation);
			
			
			String a=stub.QuestionGetResult(username);
			ArrayList<FinalResult> result=stub.GetResult();
			System.out.println(result);
			DefaultTableModel model=(DefaultTableModel) tabledata.getModel();
			model.addColumn("Name");
			model.addColumn("Engine");
			model.addColumn("Color");
			model.addColumn("Price");
			model.addColumn("Fuel");
			model.addColumn("Made");
			model.addColumn("Body");
			model.addColumn("Color");
			model.addColumn("Display");
			model.addColumn("Warrenty");
			
			
			String[] row=new String[10];
			for(int i=0;i<result.size();i++){
		            row[0]=result.get(i).getName();
		            row[1]=result.get(i).getEngine();
		            row[2]=result.get(i).getColor();
		            row[3]=result.get(i).getPrice();
		            row[4]=result.get(i).getFuel();
		            row[5]=result.get(i).getMade();
		            row[6]=result.get(i).getBody();
		            row[7]=result.get(i).getDisplay();
		            row[8]=result.get(i).getWarranty();
		            model.addRow(row);
		        }
			tabledata.setAutoResizeMode(5);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
