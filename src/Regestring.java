
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

/**
 * this progrma is a fast phone book
 * 
 * @author ashkan
 * @since 12/22/2018
 */
public class Regestring {

	private JPanel contentPane;
	private static JFrame frame = new JFrame();
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JLabel lblNewsLabel;
	public static Icon icn;
	public static String path;
	static Contact list[] = new Contact[100];// in araye ee az mokhtabas
	static Stack st = new Stack();
	static Trie trie = new Trie();
	static boolean f = false;
	static boolean h = false;
	private JButton btnBrows;
	private JLabel lblPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Regestring();
		f = true;// in flag baraye ye bar ejra kardane dastoore sakht araye va pop kardan az
					// stack hastesh
	}

	/**
	 * Create the frame.
	 */
	public Regestring() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 488, 727);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);

		if (f == false) {

			for (int i = 99; i >= 0; i--)// tamam e index haro daroon e stack push mikonim
				st.push(i);
			Trie.root = new TrieNode();

			String read = "";// in ghesmate baraye khoondan az file va gereftan info e mokhatabaye ghabli
			String dir= System.getProperty("user.dir");
			
								// hast
			File file = new File(dir+"/ashkan.txt");
			try {

				BufferedReader br = new BufferedReader(new FileReader(file));

				while ((read = br.readLine()) != null) {

					String name = read;
					String number = br.readLine();
					String address = br.readLine();
					String email = br.readLine();
					String postCode = br.readLine();
					String path = br.readLine();
					if (path.equals(""))
						path = dir+"\\photos\\contact.png";
					icn = new ImageIcon(path);
					int index = (int) st.pop().data;

					br.readLine();

					list[index] = new Contact(name, number, address, email, postCode, icn, path, index);// sakhte
																										// contact
					trie.insert(list[index]);// insert kardane mokhatb be trie
				}

				br.close();

			} catch (Exception e) {
				e.getMessage();

			}

		}
		String dir= System.getProperty("user.dir");
		icn = new ImageIcon(dir+"\\photos\\contact.png");// defult image

		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(169, 376, 191, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setBounds(169, 418, 191, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setBounds(169, 460, 191, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_3.setBounds(169, 502, 191, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_4.setBounds(168, 544, 191, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblName = new JLabel("name");
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBounds(85, 376, 54, 26);
		contentPane.add(lblName);

		JLabel lblNumber = new JLabel("number");
		lblNumber.setForeground(Color.YELLOW);
		lblNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNumber.setBounds(85, 421, 69, 20);
		contentPane.add(lblNumber);

		JLabel lblAddress = new JLabel("address");
		lblAddress.setForeground(Color.YELLOW);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(85, 463, 69, 20);
		contentPane.add(lblAddress);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.YELLOW);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(85, 505, 69, 20);
		contentPane.add(lblEmail);

		JLabel lblPostCode = new JLabel("Post Code");
		lblPostCode.setForeground(Color.YELLOW);
		lblPostCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPostCode.setBounds(76, 547, 93, 20);
		contentPane.add(lblPostCode);

		JButton btnSave = new JButton("Save");// in button baraye zakhire etelaat va raftan be safe baed hastesh
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.setVisible(false);
				PhoneBook.main(null);

			}
		});
		btnSave.setBackground(Color.YELLOW);
		btnSave.setFocusable(false);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSave.setBounds(272, 614, 115, 41);
		contentPane.add(btnSave);

		JButton btnAdd = new JButton("Add");// in button baraye add kardane mokhatab be araye hastesh
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				add();
				if (h == false) {// in boolean baraye in ast ke mokhatabe tekrari nadashte bashim ke bere safe
									// baed
					frame.setVisible(false);
					Regestring.main(null);
				}
			}
		});
		btnAdd.setBackground(Color.YELLOW);
		btnAdd.setFocusable(false);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdd.setBounds(107, 614, 115, 41);
		contentPane.add(btnAdd);

		lblNewsLabel = new JLabel("");
		lblNewsLabel.setForeground(Color.RED);
		lblNewsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewsLabel.setBounds(15, 319, 436, 41);
		contentPane.add(lblNewsLabel);

		btnBrows = new JButton("Brows Photo\r\n");// in button baraye entekhabe ax hastesh
		btnBrows.setBackground(Color.YELLOW);
		btnBrows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser jf = new JFileChooser();
				jf.setFont(new Font("Simplified Arabic", Font.PLAIN, 21));
				int flag = jf.showOpenDialog(null);
				if (flag == JFileChooser.APPROVE_OPTION) {
					File file = jf.getSelectedFile();
					try {
						Image image;
						image = ImageIO.read(file);
						Image image1 = image.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
						icn = new ImageIcon(image1);
						lblPhoto.setIcon(icn);

						path = file.getPath();

					} catch (Exception e) {
						e.getMessage();
					}
				}

			}
		});
		btnBrows.setFocusable(false);
		btnBrows.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBrows.setBounds(151, 272, 151, 41);
		contentPane.add(btnBrows);

		lblPhoto = new JLabel("");
		lblPhoto.setBounds(118, 16, 253, 240);
		contentPane.add(lblPhoto);

		lblPhoto.setIcon(icn);
		path = icn.toString();

		frame.setVisible(true);
	}

	public static void add() {// in func baraye add kardane

		String name = textField.getText();
		int nameIndex = trie.searchName(name);

		if (nameIndex != -1) {// agar mokhtabe ba esme tekrari dashtim
			lblNewsLabel.setText("there is same contact with this name !");
			h = true;
			return;
		}

		String number = textField_1.getText();
		int numberIndex = trie.searchNumber(number);

		if (numberIndex != -1) {// agar mokhatabe ba shomare tekrari dashtim
			lblNewsLabel.setText("there is same contact with this number !");
			h = true;
			return;
		}

		String address = textField_2.getText();
		String email = textField_3.getText();
		String postCode = textField_4.getText();
		int index = (int) st.pop().data;

		list[index] = new Contact(name, number, address, email, postCode, icn, path, index);// sakhte contact
		trie.insert(list[index]);// ezafe kardan be trie
		h = false;

	}
}
