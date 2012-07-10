package game.minipatapon.util;

public class PathHelper {
	public static String combine(String base, String relative) {
		if (base.endsWith("/") || base.endsWith("\\")) {
		} else {
			base = base + "/";
		}
		return base + relative;
	}
}
