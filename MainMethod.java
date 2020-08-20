import java.util.List;

public class MainMethod {

	public static void main(String[] args) {
		DatabaseHealper service = new DatabaseHealper();
		if (args.length == 0 || args.length > 3) {
			System.out.println("please read the read me file"); 
			return;
		}
		String key = args[0];
		switch (key) {
		case "ADD"://to add a person
			Contact p = new Contact(1, args[1], args[2]);
			if (p.validate()) {//to validate
				service.Add(p);
			}

			else {
				System.out.println("incorrect data");
			}
			break;
		case "DEL":
			System.out.println(service.delete(args[1]));
			break;
		case "LIST":
			List<Contact> persons = service.getPeople();
			for (Contact person : persons) {
				System.out.println(person.id + "     " + person.name + "     " + person.mobile);
			}
			break;
		default:
			System.out.println("PLEASE READ THE README FILE");

		}
	}

}
