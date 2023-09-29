
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

/**
 * this class is for editing the contact
 *
 */
public class Edit {

	private static JFrame frame = new JFrame();
	private JPanel contentPane;
	public static int index;
	public static JLabel lblNewsLabel;
	Trie trie = new Trie();
	static boolean h = false;// in boolean baraye jolo giri az zakhire name e tekrarie mokhtab hastesh

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Edit();
	}

	/**
	 * Create the frame.
	 */
	public Edit() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 670, 708);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblNumber = new JLabel("Number :");
		lblNumber.setForeground(Color.WHITE);
		lblNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNumber.setBounds(15, 411, 80, 20);
		contentPane.add(lblNumber);

		JLabel numberMount = new JLabel("");
		numberMount.setForeground(new Color(255, 255, 255));
		numberMount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		numberMount.setBounds(122, 407, 288, 28);
		contentPane.add(numberMount);

		JLabel lblAddress = new JLabel("Address :\r\n");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(15, 455, 80, 20);
		contentPane.add(lblAddress);

		JLabel lblEmail = new JLabel("Email :\r\n");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(15, 499, 69, 20);
		contentPane.add(lblEmail);

		JLabel addressMount = new JLabel("");
		addressMount.setForeground(Color.WHITE);
		addressMount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addressMount.setBounds(122, 451, 288, 28);
		contentPane.add(addressMount);

		JLabel emailMount = new JLabel("");
		emailMount.setForeground(Color.WHITE);
		emailMount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		emailMount.setBounds(122, 495, 288, 28);
		contentPane.add(emailMount);

		JLabel lblPostCode = new JLabel("Post Code :");
		lblPostCode.setForeground(Color.WHITE);
		lblPostCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPostCode.setBounds(10, 545, 97, 20);
		contentPane.add(lblPostCode);

		JLabel postCodeMount = new JLabel("");
		postCodeMount.setForeground(Color.WHITE);
		postCodeMount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		postCodeMount.setBounds(122, 539, 288, 32);
		contentPane.add(postCodeMount);

		JLabel nameMount = new JLabel("\r\n");
		nameMount.setForeground(Color.WHITE);
		nameMount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		nameMount.setBounds(15, 309, 384, 86);
		contentPane.add(nameMount);

		JLabel lblPhoto = new JLabel("\r\n\r\n");
		lblPhoto.setBounds(137, 16, 302, 253);
		contentPane.add(lblPhoto);

		try {// in try baraye in ast ke agar mokhtab nabood null exeption nadahad

			nameMount.setText(Regestring.list[index].name);
			numberMount.setText(Regestring.list[index].number);
			addressMount.setText(Regestring.list[index].address);
			emailMount.setText(Regestring.list[index].Email);
			postCodeMount.setText(Regestring.list[index].postCode);
			lblPhoto.setIcon(Regestring.list[index].icn);

		} catch (Exception e) {

			nameMount.setText("the contact doesn't exist !");
		}

		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				PhoneBook.main(null);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setFocusable(false);
		btnBack.setBackground(Color.YELLOW);
		btnBack.setBounds(454, 534, 136, 43);
		contentPane.add(btnBack);

		JButton btnEditName = new JButton("edit name");
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String s = JOptionPane.showInputDialog(frame, "Enter new name : ");
				trie.editName(nameMount.getText(), s);// seda kardane tabe edit name
				if (h == false) {// in haman flag e jolo giri az sabte tekrari
					frame.setVisible(false);
					Edit.main(null);
				}
			}
		});
		btnEditName.setFocusable(false);
		btnEditName.setBackground(Color.YELLOW);
		btnEditName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditName.setBounds(454, 336, 136, 38);
		contentPane.add(btnEditName);

		JButton btnEditNumber = new JButton("edit number");
		btnEditNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String s = JOptionPane.showInputDialog(frame, "Enter new number : ");
				trie.editNumber(numberMount.getText(), s);// seda kardane tabe edit number
				if (h == false) {// in haman flag e jolo giri az sabte tekrari
					frame.setVisible(false);
					Edit.main(null);
				}
			}
		});
		btnEditNumber.setBackground(Color.YELLOW);
		btnEditNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditNumber.setFocusable(false);
		btnEditNumber.setBounds(454, 406, 136, 30);
		contentPane.add(btnEditNumber);

		JButton btnEditInfo = new JButton("edit info");
		btnEditInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditInfo.name = nameMount.getText();
				EditInfo.main(null);
			}
		});
		btnEditInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditInfo.setFocusable(false);
		btnEditInfo.setBackground(Color.YELLOW);
		btnEditInfo.setBounds(454, 470, 136, 32);
		contentPane.add(btnEditInfo);

		lblNewsLabel = new JLabel("\r\n");
		lblNewsLabel.setForeground(Color.RED);
		lblNewsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewsLabel.setBounds(49, 593, 541, 43);
		contentPane.add(lblNewsLabel);

		JButton btnEditPhoto = new JButton("edit photo");// in button baraye entekhabe ax hastesh
		btnEditPhoto.addActionListener(new ActionListener() {
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
						Icon icn = new ImageIcon(image1);
						lblPhoto.setIcon(icn);

						Regestring.list[index].icn = icn;// avaz kardane icon e mokhtab dar araye

					} catch (Exception e) {
						e.getMessage();
					}
				}

			}
		});
		btnEditPhoto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditPhoto.setFocusable(false);
		btnEditPhoto.setBackground(Color.YELLOW);
		btnEditPhoto.setBounds(454, 111, 136, 43);
		contentPane.add(btnEditPhoto);

		frame.setVisible(true);

	}

}
