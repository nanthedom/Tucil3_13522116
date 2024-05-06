package lib;

public class Util {
    public static int heuristicCost(String start, String end) {
		int cost = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i))
				cost ++;
		}
		return cost;
	}
}