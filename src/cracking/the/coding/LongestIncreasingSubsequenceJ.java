package cracking.the.coding;

public class LongestIncreasingSubsequenceJ {

	public static void main(String[] args) {
		LIS(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15});
	}
	
	public static void LIS(int[] nums) {
		
		int[] sizes = new int[nums.length];
		String[] paths = new String[nums.length];
		
		for(int i=0; i < nums.length; i++) {
			sizes[i] = 1;
			paths[i] = nums[i] + " ";
		}
		
		int maxLength = 1;
		for(int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && sizes[i] < sizes[j] + 1) {
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + nums[i] + " ";
					if (maxLength < sizes[i])
						maxLength = sizes[i];
				}
			}
		}
		
		for(int i = 1; i < nums.length; i++) {
			if (sizes[i] == maxLength)
				System.out.println("LIS: " + paths[i]);
		}
		
	}

}
