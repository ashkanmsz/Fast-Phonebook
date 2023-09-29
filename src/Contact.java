import javax.swing.Icon;
/**
 * this is out contact class
 *
 */
public class Contact {

	String name;
	String number;
	String address;
	String Email;
	String postCode;
	String path;
	int index;
	Icon icn;

	public Contact(String name, String number, String address, String Email,String postCode,Icon icn,String path,int index) {
		this.name = name;
		this.number = number;
		this.address = address;
		this.Email = Email;
		this.postCode=postCode;
		this.icn=icn;
		this.path=path;
		this.index=index;
	}

}
