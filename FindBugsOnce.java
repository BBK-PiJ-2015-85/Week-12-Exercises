public class FindBugsOnce {
	public String getInitials(String fullName) {
		String result = "";
		String[] words = fullName.split(" ");
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (words[i].charAt(j) != ' ') {
					String nextInitial = "" + words[i].charAt(j);
					result = result + nextInitial.toUpperCase();
					break;
				}				
			}			
		}
		return result;
	}
}