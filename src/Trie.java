
import javax.swing.Icon;

/**
 * this is our trie class for saving the number and name of contact in it
 *
 */
public class Trie {

	static TrieNode root;

	// in tabe baraye inser kardan hastesh
	public void insert(Contact contact) {

		TrieNode tmp;
		int length;
		int index;
		String name = contact.name;// insert e name
		String number = contact.number;// insert e number

		length = contact.name.length();
		tmp = root;

		// in halghe baraye ezafe kardane name mokhtab hastesh
		for (int i = 0; i < length; i++) {

			index = name.charAt(i) - 'a';// gereftan e aski code e char

			if (tmp.children[index] == null)
				tmp.children[index] = new TrieNode();

			tmp = tmp.children[index];

		}

		tmp.index = contact.index;// set kardane index e araye mokhatab dar node e derakht

		// in ghesmate baraye insert kardane shomare hastesh

		length = contact.number.length();
		tmp = root;

		for (int i = 0; i < length; i++) {
			index = 26 + number.charAt(i) - '0';

			if (tmp.children[index] == null)
				tmp.children[index] = new TrieNode();

			tmp = tmp.children[index];
		}

		tmp.index = contact.index;// set kardane index e araye mokhatab dar node e derakht

	}

	// in tabe baraye hazf kardan e mokhatab hastesh
	public void totalRemove(Contact contact) {

		TrieNode tmp;
		int index;
		String name = contact.name;// baraye hazf kardan bar asase name
		String number = contact.number;// baraye hazf kardan bar hasbe shomare
		int length;

		tmp = root;
		length = contact.name.length();

		for (int i = 0; i < length; i++) {

			index = name.charAt(i) - 'a';

			if (tmp.children[index] == null) {// agar null bood yani mokhatab nistesh
				System.out.println("this contact doesn't exist !");
				return;
			}

			tmp = tmp.children[index];
		}

		Regestring.st.push(tmp.index);// bayad tmp.index o push koni inja baraye estefade kardan az an dar marahele
										// baed

		Regestring.list[tmp.index] = null;// null kardane mokhatab dar araye
		tmp.index = -1;// indexash ra manfi kardan baraye neshane gozri

		tmp = root;// in ghesmate baraye hazf kardane shomare mokhtab hastesh
		length = contact.number.length();

		for (int i = 0; i < length; i++) {
			index = 26 + number.charAt(i) - '0';

			if (tmp.children[index] == null) {// agar null bood yani mokhatab nistesh
				System.out.println("this contact doesn't exist !");
				return;
			}

			tmp = tmp.children[index];
		}

		tmp.index = -1;// indexash ra manfi kardan baraye neshane gozri

	}

	// in tabe baraye hazf kardan bar hasbe name e mokhatab hastesh
	public void removeName(String name) {

		int index = searchName(name);// ebteda indexash ra peida mikonim

		if (index == -1) {// agar vojood nadasht
			PhoneBook.newsLabel.setText("there is no contact !");
			return;
		}

		totalRemove(Regestring.list[index]);// ferestadan be tabe total remove

	}

	// in tabe baraye hazf kardan bar hasbe shomare e mokhatab hastesh
	public void removeNumber(String number) {

		int index = searchNumber(number);

		if (index == -1) {// ebteda indexash ra peida mikonim
			PhoneBook.newsLabel.setText("there is no contact !");
			return;
		}

		totalRemove(Regestring.list[index]);// ferestadan be tabe total remove

	}

	// in tabe baraye search bar asase name hastesh va index e mokhatab ra bar
	// migardanad
	public int searchName(String name) {

		TrieNode tmp;
		int length;
		int index;

		length = name.length();
		tmp = root;

		for (int i = 0; i < length; i++) {

			index = name.charAt(i) - 'a';

			if (tmp.children[index] == null) {// agar mokhatab nabood
				return -1;
			}

			tmp = tmp.children[index];

		}

		if (tmp != null && tmp.index != -1)
			return tmp.index;

		return -1;

	}

	// in tabe baraye search bar asase shoamre hastesh va index e mokhatab ra bar
	// migardanad
	public int searchNumber(String number) {

		TrieNode tmp;
		int length;
		int index;

		length = number.length();
		tmp = root;

		for (int i = 0; i < length; i++) {
			index = 26 + number.charAt(i) - '0';

			if (tmp.children[index] == null)// agar mokhatab nabood
				return -1;

			tmp = tmp.children[index];
		}

		if (tmp != null && tmp.index != -1)
			return tmp.index;

		return -1;

	}

	// in tabe baraye edite e info hastesh
	public void editInfo(String name, String newAddress, String newEmail, String newPostCode) {

		int index = searchName(name);// ebteda index e mokhatab

		if (newAddress.equals(""))// agar etelaate jadidi ezafe nashod haman ghabli bemand
			newAddress = Regestring.list[index].address;

		if (newEmail.equals(""))// agar etelaate jadidi ezafe nashod haman ghabli bemand
			newEmail = Regestring.list[index].Email;

		if (newPostCode.equals(""))// agar etelaate jadidi ezafe nashod haman ghabli bemand
			newPostCode = Regestring.list[index].postCode;

		Contact contact = new Contact(name, Regestring.list[index].number, newAddress, newEmail, newPostCode,
				Regestring.list[index].icn, Regestring.list[index].path, index);

		Regestring.list[index] = contact;

	}

	// in tabe baraye edit bar hasbe name hastesh
	public void editName(String oldName, String newName) {

		int nameIndex = searchName(newName);// baraye adame vojood esme tekrari

		if (nameIndex != -1) {// agar in esm vojood dasht
			Edit.lblNewsLabel.setText("there is same contact with this name !");
			Edit.h = true;
			return;
		}

		int index = searchName(oldName);// peida kardane indexe mokhtab

		String number = Regestring.list[index].number;
		String address = Regestring.list[index].address;
		String email = Regestring.list[index].Email;
		String postCode = Regestring.list[index].postCode;
		Icon icn = Regestring.list[index].icn;
		String path = Regestring.list[index].path;

		removeName(oldName);// hazf kardane mokhatabe ghabli

		index = (int) Regestring.st.pop().data; // indexo baedan bayad az stack begiri baed az hazf

		Contact contact = new Contact(newName, number, address, email, postCode, icn, path, index);

		Regestring.list[index] = contact;

		insert(contact);
		Edit.h = false;

	}

	// in tabe baraye edit bar hasbe shomare hastesh
	public void editNumber(String oldNumber, String newNumber) {

		int numberIndex = searchNumber(newNumber);// baraye adame vojood shomare tekrari

		if (numberIndex != -1) {// agar in shomare vojood dasht
			Edit.lblNewsLabel.setText("there is same contact with this number !");
			Edit.h = true;
			return;
		}

		int index = searchNumber(oldNumber);// peida kardane indexe mokhtab

		String name = Regestring.list[index].name;
		String address = Regestring.list[index].address;
		String email = Regestring.list[index].Email;
		String postCode = Regestring.list[index].postCode;
		Icon icn = Regestring.list[index].icn;
		String path = Regestring.list[index].path;

		removeNumber(oldNumber);// hazf kardane mokhatabe ghabli

		index = (int) Regestring.st.pop().data;// indexo baedan bayad az stack begiri baed az hazf

		Contact contact = new Contact(name, newNumber, address, email, postCode, icn, path, index);

		Regestring.list[index] = contact;

		insert(contact);
		Edit.h = false;
	}

	// in tabe baraye suggest e lahze ee esm va name mokhatab hateah
	public void suggest(String s) {

		TrieNode tmp = root;
		int length = s.length();
		int index = 0;
		String s2 = "";

		for (int i = 0; i < length; i++) {// in halghe baraye residan be araye childrene kalame morede naz hastesh

			index = s.charAt(i) - 'a';

			if (index < 0)// agar vorudi shomare bood
				index = 26 + (s.charAt(i) - '0');

			if (tmp.children[index] == null)
				return;

			tmp = tmp.children[index];
		}

		if (tmp.index != -1)// agar mokhatab peida shod
			PhoneBook.l1.addElement(s);

		for (int i = 0; i < 36; i++) {// pas az yaftane children peimayesh bar rooye an va peida kardane sub horoof ha

			if (index >= 26 && tmp.children[i] != null) {// agar adad bood
				char c = (char) (i - 26 + '0');// adad aski ra be char tabdil mikond
				s2 = s + c;// ba harfe ghabli jame mikond
				suggest(s2);
			}

			if (index <= 25 && tmp.children[i] != null) {// agar name bood
				char c = (char) (i + 'a');// adad aski ra be char tabdil mikond
				s2 = s + c;// ba harfe ghabli jame mikond
				suggest(s2);
			}
		}
	}
}
