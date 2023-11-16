package dp;

public class TrappingRainWater {

	
	
	public int trap(int[] height) {
		//left[]左边能support的最大高度
		int max1 = 0;
		int left[] = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			if (max1 < height[i]) {
				max1 = height[i];
			}
			left[i] = max1;
		}
		//right[]右边能support的最大高度
		int max2 = 0;
		int right[] = new int[height.length];
		for (int i = height.length - 1; i >= 0; i--) {
			if (max2 < height[i]) {
				max2 = height[i];
			}
			right[i] = max2;
		}
		//某一个节点短板效应，左右谁短谁决定高度，再减去自身原本高度，就是蓄水量
		int trap = 0;
		for (int i = 0; i < height.length; i++) {
			trap += Math.min(left[i], right[i]) - height[i];
		}
		return trap;
	}
}
