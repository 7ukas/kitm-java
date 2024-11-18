public class Arrays3 {
    public int maxSpan(int[] nums) {
        if (nums.length < 1) return 0;
        int max = 1;

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if ((j-i+1) > max) max = j-i+1;
                }
            }
        }

        return max;
    }

    public int[] fix34(int[] nums) {
        int[] fours = new int[nums.length]; // Indexes of 4s
        int index = 0;

        // Find indexes
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                fours[index] = i;
                index++;
            }
        }
        index = 0;

        // Swap
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 3) {
                nums[fours[index]] = nums[i+1];
                nums[i+1] = 4;
                index++;
            }
        }

        return nums;
    }

    public int[] fix45(int[] nums) {
        if (nums.length < 1) return new int[]{};

        int[] fives = new int[nums.length];
        int index = 0;

        if (nums[0] == 5) index++;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != 4 && nums[i] == 5) {
                fives[index] = i;
                index++;
            }
        }
        index = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 4 && nums[i+1] != 5) {
                nums[fives[index]] = nums[i+1];
                nums[i+1] = 5;
                index++;
            }
        }

        return nums;
    }

    public boolean canBalance(int[] nums) {
        int firstHalf = 0;
        int secondHalf = 0;

        for (int i = 0; i < nums.length-1; i++) {
            firstHalf += nums[i];

            for (int j = i+1; j < nums.length; j++) {
                secondHalf += nums[j];
            }

            if (firstHalf == secondHalf) return true;
            secondHalf = 0;
        }

        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < outer.length; i++) {
            if (j == inner.length) break;

            if (outer[i] == inner[j]) {
                count++;
                j++;
            }
        }

        return count == inner.length;
    }

    public int[] squareUp(int n) {
        int[] arr = new int[n*n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n-(n-i-1); j++) {
                arr[((i+1)*n)-j] = j;
            }
        }

        return arr;
    }

    public int[] seriesUp(int n) {
        int[] arr = new int[n*(n+1)/2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i+1; j++) {
                arr[index] = j;
                index++;
            }
        }

        return arr;
    }

    public int maxMirror(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++){
            int index = i;
            int count = 0;

            for (int j = nums.length-1; j >= i; j--){
                if (nums[index] == nums[j]) {
                    index++;
                    count++;
                } else {
                    if (count > max) max = count;
                    count = 0;
                    index = i;
                }
            }

            if (count > max) max = count;
        }

        return max;
    }

    public int countClumps(int[] nums) {
        int count = 0;
        boolean isClump = false;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                isClump = true;
            }

            if (nums[i] != nums[i+1] || (i+2) == nums.length) {
                if (isClump) {
                    count++;
                    isClump = false;
                }
            }
        }

        return count;
    }
}