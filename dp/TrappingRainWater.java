package dp;

public class TrappingRainWater {

	
	
	public int trap(int[] height) {
		int max1 = 0;
		int left[] = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			if (max1 < height[i]) {
				max1 = height[i];
			}
			left[i] = max1;
		}

		int max2 = 0;
		int right[] = new int[height.length];
		for (int i = height.length - 1; i >= 0; i--) {
			if (max2 < height[i]) {
				max2 = height[i];
			}
			right[i] = max2;
		}

		int trap = 0;
		for (int i = 0; i < height.length; i++) {
			trap += Math.min(left[i], right[i]) - height[i];
		}
		return trap;
	}
}
