package TwilightCultist.util;

public class SanityCountUtils {
    public static int sanityCount;
    public static int getSanityCount() {
        return sanityCount;
    }

    public static void setSanityCount(int amount) {
        sanityCount = amount;
    }

    public static void addSanityCount(int amount) {
        sanityCount += amount;
    }
}