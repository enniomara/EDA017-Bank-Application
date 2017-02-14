
public class Util {
	public static boolean isInt(String text){
		// Regex for all the numbers. Tested on http://regexr.com/
		String regex = "\\d+";
		
		// If text is not a valid integer
		if(!text.matches(regex)){
			return false;
		}
		
		return true;
		
	}
}
