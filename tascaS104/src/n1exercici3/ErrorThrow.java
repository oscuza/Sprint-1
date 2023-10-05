package n1exercici3;

import java.util.List;
import java.util.*;

public class ErrorThrow {
	

	private int [] nums;
	
	public ErrorThrow() {
		
		this.nums=new int[3];
		nums[0]=50;
		nums[1]=12;
		nums[2]=9;
	
		
	}

	public int[] getNums() {
		return nums;
	}

	public void setNum(int pos, int num) {
		this.nums[pos] = num;
	}



	


}
