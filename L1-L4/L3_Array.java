import java.util.Scanner;

public class L3_Array {
    /* [Array-1 > firstLast6] */
    public static boolean firstLast6(int[] nums) {
        return nums[0] == 6 || nums[nums.length-1] == 6;
    }

    /* [Array-1 > commonEnd] */
    public static boolean commonEnd(int[] a, int[] b) {
        return a[0] == b[0] || a[a.length-1] == b[b.length-1];
    }

    /* [Array-1 > sum3] */
    public static int sum3(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        } return sum;
    }

    /* [Array-3 > maxSpan] */
    public static int maxSpan(int[] nums) {
        int span = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >= i; j--) {
                if (nums[i] == nums[j]) {
                    int count = j - i + 1;
                    if (span < count) {
                        span = count;
                    }
                }
            }
        }

        return span;
    }

    public static void guestList() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sveciu kiekis?: ");
        int guestsCount = Integer.parseInt(scanner.nextLine());

        String[] guests = new String[guestsCount];
        String[] blackList = {"Paulius", "Tadas"};

        for (int i = 0; i < guests.length; i++) {
            System.out.print(i+1 + "-ojo svecio vardas?: ");
            guests[i] = scanner.nextLine();
        }

        System.out.println("\nSveciai: ");
        for (int i = 0; i < guests.length; i++) {
            System.out.print(i+1 + ": " + guests[i]);

            for (int j = 0; j < blackList.length; j++) {
                if (blackList[j].equalsIgnoreCase(guests[i])) {
                    System.out.print(" (blacklisted)");
                }
            }
            System.out.println();
        }
    }
}
