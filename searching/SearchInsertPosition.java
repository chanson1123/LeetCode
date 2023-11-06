package searching;

public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		int[] nums = {1,3,5,6};
		System.out.println(s.searchInsert(nums, 7));
	}
	
	public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(nums[left] >= target) {
        	return left;
        }else {
        	return left + 1;
        }
    }
	
}
