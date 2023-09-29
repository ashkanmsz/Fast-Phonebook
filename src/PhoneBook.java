
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.input.KeyCode;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * 
 * this class is for showing the list of contacts
 */
public class PhoneBook {

	private JPanel contentPane;
	private static JFrame frame = new JFrame();
	private JTextField textField;
	private JTextArea textArea;
	public static JLabel newsLabel;
	public static DefaultListModel<String> l1;
	public static JList<String> list;
	Trie trie = new Trie();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new PhoneBook();
	}

	/**
	 * Create the frame.
	 */
	public PhoneBook() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 486, 875);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 325, 460, 239);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));

		JButton btnSearchName = new JButton("Search Name");// in button baraye search bar hasbe name hastesh
		btnSearchName.setBackground(Color.WHITE);
		btnSearchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = trie.searchName(textField.getText());
				frame.setVisible(false);
				Edit.index = index;// indexe mokhtab ra dar safe Edit moshkhas mikonim ke oonja estefade konim
				Edit.main(null);

			}
		});
		btnSearchName.setFocusable(false);
		btnSearchName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnSearchName);

		JButton btnSearchNumb = new JButton("Search Numb");// in button baraye search bar hasbe shomare hastesh
		btnSearchNumb.setBackground(Color.WHITE);
		btnSearchNumb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int index = trie.searchNumber(textField.getText());
				frame.setVisible(false);
				Edit.index = index;// moshakhas kardane indexe mokhtab dar class e edit
				Edit.main(null);

			}
		});
		btnSearchNumb.setFocusable(false);
		btnSearchNumb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnSearchNumb);

		JButton btnRemoveName = new JButton("Remove Name");// in button baraye hazf kardan bar hasbe name hastesh
		btnRemoveName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				trie.removeName(textField.getText());

				textArea.setText("");
				int counter = 0;
				for (int i = 0; counter != Regestring.list.length - Regestring.st.size(); i++) {// in ghesmate baraye
																								// update kardane text
																								// area hastesh

					if (Regestring.list[i] == null) {
						continue;
					}
					textArea.append("  " + Regestring.list[i].name);
					textArea.append("\n");
					counter++;
				}

			}
		});
		btnRemoveName.setBackground(Color.WHITE);
		btnRemoveName.setFocusable(false);
		btnRemoveName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnRemoveName);

		JButton btnRemoveNumb = new JButton("Remove Numb");// in button baraye hazf kardan bar hasbe shomare hastesh
		btnRemoveNumb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				trie.removeNumber(textField.getText());

				textArea.setText("");
				int counter = 0;
				for (int i = 0; counter != Regestring.list.length - Regestring.st.size(); i++) {// in ghesmate baraye
																								// update kardane text
																								// area hastesh

					if (Regestring.list[i] == null) {
						continue;
					}
					textArea.append("  " + Regestring.list[i].name);
					textArea.append("\n");
					counter++;
				}
			}
		});
		btnRemoveNumb.setBackground(Color.WHITE);
		btnRemoveNumb.setFocusable(false);
		btnRemoveNumb.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnRemoveNumb);

		JButton btnAddMore = new JButton("Add More");// in button baraye ezafe kardane mokhtabe jadid hastesh
		btnAddMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Regestring.main(null);
			}
		});
		btnAddMore.setBackground(Color.WHITE);
		btnAddMore.setFocusable(false);
		btnAddMore.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnAddMore);

		JButton btnSave = new JButton("Save");// in dokme baraye save kardane etelaate mokhatab dar text hastesh
		btnSave.setBackground(Color.WHITE);
		btnSave.setFocusable(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					PrintWriter writer = new PrintWriter("ashkan.txt", "UTF-8");

				} catch (Exception e) {

					e.printStackTrace();
				}

				try {
					FileWriter fw = new FileWriter("ashkan.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw);

					int counter = 0;
					for (int i = 0; counter != Regestring.list.length - Regestring.st.size(); i++) {

						if (Regestring.list[i] == null) {
							continue;
						}

						out.println(Regestring.list[i].name);
						out.println(Regestring.list[i].number);
						out.println(Regestring.list[i].address);
						out.println(Regestring.list[i].Email);
						out.println(Regestring.list[i].postCode);
						out.println(Regestring.list[i].path);
						out.println("*********************");

						counter++;
					}

					out.close();
				} catch (Exception e) {
					e.getMessage();
				}

			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(btnSave);

		newsLabel = new JLabel("");
		newsLabel.setForeground(Color.YELLOW);
		newsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		newsLabel.setBounds(10, 16, 450, 38);
		contentPane.add(newsLabel);

		textField = new JTextField();
		textField.setForeground(Color.YELLOW);
		textField.setBackground(Color.BLACK);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(5, 64, 455, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		frame.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 563, 462, 256);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setForeground(Color.YELLOW);
		textArea.setBackground(Color.BLACK);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));

		textArea.setText("");
		int counter = 0;
		for (int i = 0; counter != Regestring.list.length - Regestring.st.size(); i++) {// in ghesmate baraye update
																						// kardane text area hastesh

			if (Regestring.list[i] == null) {
				continue;
			}
			textArea.append("  " + Regestring.list[i].name);
			textArea.append("\n");
			counter++;
		}

		l1 = new DefaultListModel<>();// sakhte JList

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 118, 460, 202);
		contentPane.add(scrollPane_1);

		list = new JList<>(l1);
		list.setBackground(Color.BLACK);
		list.setForeground(Color.YELLOW);
		scrollPane_1.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane_1.setVisible(false);

		textField.addKeyListener(new KeyAdapter() {// in ghesmat barye suggest kardane mokhtab hastesh

			public void keyTyped(KeyEvent e) {

				l1.clear();
				if (!textField.getText().equals("")) {
					trie.suggest(textField.getText());// tabe e suggest
					scrollPane_1.setVisible(true);
				} else
					scrollPane_1.setVisible(false);

			}

			public void keyPressed(KeyEvent e) {

				l1.clear();
				if (!textField.getText().equals("")) {
					trie.suggest(textField.getText());// tabe e suggest
					scrollPane_1.setVisible(true);
				} else
					scrollPane_1.setVisible(false);
			}

			public void keyReleased(KeyEvent e) {

				l1.clear();
				if (!textField.getText().equals("")) {
					trie.suggest(textField.getText());// tabe e suggest
					scrollPane_1.setVisible(true);
				} else
					scrollPane_1.setVisible(false);

			}

		});

		list.addMouseListener(new MouseAdapter() {// in ghesmate baraye ghabeliate click bar rooye JList hastesh
			public void mouseClicked(MouseEvent arg0) {

				textField.setText(list.getSelectedValue());
				l1.clear();
				scrollPane_1.setVisible(false);
			}
		});

		frame.setVisible(true);
	}
}
