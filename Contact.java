
import java.util.HashSet;

public class Contact {

	public Contact(int id,String name, String mobile) {
		super();
		this.id=id;
		this.name = name;
		this.mobile = mobile;
	}

	public int id;
	public String name, mobile;

	public boolean validate() { 
		//if name has more than three chars then return false
		if(name.split(" ").length>3) return false;
		//list of alowed regex
		String[] phoneRegexArray = { "^[\\d]{5}$", "^\\([\\d]{3}\\)\\d{3}-\\d{4}$", "^[\\d]{3}-\\d{4}$",
				"^\\+\\d{1}\\([\\d]{3}\\)\\d{3}-\\d{4}$", "^\\+\\d{2}\\s\\([\\d]{2}\\)\\s\\d{3}-\\d{4}$",
				"^\\d{1}\\([\\d]{3}\\)\\d{3}-\\d{4}$", "^\\d{3}\\s\\d{3}\\s\\d{3}\\s\\d{4}$",
				"^\\d{3}\\s\\d{1}\\s\\d{3}\\s\\d{3}\\s\\d{4}$", "^\\d{5}\\.\\d{5}$" };
		//if name size less than 4 chars
		if (name.length() < 4)
			return false;
		String nameAllowedChars = " ,.'’-";
		boolean nameValid = true, phoneValid = false;
		String sChar = name.replaceAll("[a-zA-Z\\s]*", "");
		HashSet<Character> chars = new HashSet<>();
		//if any of the allowed special character is repeated then return false
		for (char c : sChar.toCharArray()) {
			if (chars.contains(c) || !nameAllowedChars.contains(c+"")) {
				nameValid = false;
				break;
			}
			chars.add(c);
		}

		if (nameValid) {
			//checking for the valid regex
			for (String regex : phoneRegexArray) {
				if (mobile.replaceAll(regex, "").equals("")) {
					phoneValid = true;
					break;
				}
			}
		}

		return nameValid && phoneValid;
	}
	
	public static void main(String[] args) {
		Contact contact=new Contact(1, "O’Malley, John F.", "12456");
		System.out.println(contact.validate());
	}
	
	

	

}
