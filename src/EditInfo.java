
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * this class is for editing information
 */
public class EditInfo {

	private JPanel contentPane;
	static private JFrame frame = new JFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static String name;
	Trie trie = new Trie();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new EditInfo();
	}

	/**
	 * Create the frame.
	 */
	public EditInfo() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 509, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddress = new JLabel("address");
		lblAddress.setForeground(Color.YELLOW);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(25, 67, 95, 20);
		contentPane.add(lblAddress);

		JLabel lblEmail = new JLabel("email");
		lblEmail.setForeground(Color.YELLOW);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmail.setBounds(25, 138, 69, 20);
		contentPane.add(lblEmail);

		JLabel lblPostCode = new JLabel("post code");
		lblPostCode.setForeground(Color.YELLOW);
		lblPostCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPostCode.setBounds(25, 212, 86, 20);
		contentPane.add(lblPostCode);

		textField = new JTextField();
		textField.setBackground(Color.YELLOW);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(124, 65, 270, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.YELLOW);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setBounds(124, 136, 270, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBackground(Color.YELLOW);
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setBounds(126, 206, 268, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnOk = new JButton("OK");// in dokme baraye ejraye dastoorate
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				trie.editInfo(name, textField.getText(), textField_1.getText(), textField_2.getText());// seda kardane
																										// tabe
				frame.setVisible(false);
				Edit.main(null);
			}
		});
		btnOk.setFocusable(false);
		btnOk.setBackground(Color.WHITE);
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnOk.setBounds(188, 267, 115, 45);
		contentPane.add(btnOk);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}

}
