package lib;

public class Util {
	public static String ANSI_RED = "\u001B[31m";
	public static String ANSI_YELLOW = "\u001B[33m";
	public static String ANSI_GREEN = "\u001B[32m";
	public static String ANSI_RESET = "\u001B[0m";

    public static int heuristicCost(String start, String end) {
		int cost = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i))
				cost ++;
		}
		return cost;
	}

	public static String colorMatchingCharacters(String text, String end) {
        int minLength = Math.min(text.length(), end.length());
        StringBuilder coloredText = new StringBuilder();

        for (int i = 0; i < minLength; i++) {
            if (text.charAt(i) == end.charAt(i)) {
                coloredText.append(ANSI_GREEN).append(text.charAt(i)).append(ANSI_RESET);
            } else {
                coloredText.append(text.charAt(i));
            }
        }

        if (text.length() > end.length()) {
            coloredText.append(text.substring(minLength));
        } else if (end.length() > text.length()) {
            coloredText.append(end.substring(minLength));
        }

        return coloredText.toString();
    }
}