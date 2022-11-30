import java.util.*;

public class Water {
    public static void main(String[] args) {

        // Get Inputs
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length == 0) return;
        int[] heights = new int[length];
        while (length-- > 0)
            heights[length] = scanner.nextInt();

        // Calculate all water storage capacity blindly
        int maxHeight = Arrays.stream(heights).max().getAsInt();
        int heightsSum = Arrays.stream(heights).sum();
        int capacity = heights.length * maxHeight - heightsSum;

        // Reduce the left overflow water
        int edgeHeight = 0;
        for (int height : heights) {
            edgeHeight = Math.max(height, edgeHeight);
            int diff = maxHeight - edgeHeight;
            if (diff == 0)
                break;
            capacity -= diff;
        }

        // Reduce the right overflow water
        edgeHeight = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            edgeHeight = Math.max(heights[i], edgeHeight);
            int diff = maxHeight - edgeHeight;
            if (diff == 0)
                break;
            capacity -= diff;
        }

        System.out.println(capacity);
    }

}