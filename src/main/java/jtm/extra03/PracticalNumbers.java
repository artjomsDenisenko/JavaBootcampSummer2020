package jtm.extra03;

import java.util.ArrayList;

public class PracticalNumbers {

	// Read article https://en.wikipedia.org/wiki/Practical_number
	// Implement method, which returns practical numbers in given range
	// including
	public String getPracticalNumbers(int from, int to) {
		ArrayList <Integer> practicalNumbers = new ArrayList<Integer>();
		
		for(int num = from; num<=to; num++){
			if(isPractical(num)){
				practicalNumbers.add(num);
			}
		}
		return practicalNumbers.toString();
	}

	public static boolean isPractical(int num)
	{
		ArrayList <Integer> factorList = new ArrayList<Integer>();

		for(int i=1;i<num;i++){
			if(num%i == 0){
				factorList.add(i);
			}
		}

		int[] factors = new int[factorList.size()];
		for(int i =0;i<factors.length;i++) {
			factors[i] = factorList.get(i).intValue();
		}

		for(int i = num-1;i>0;i--) {
			int temp = i;
			for(int j= factors.length-1;j>=0;j--) {
				if(temp>0)
					temp -= factors[j];
				if(temp <0)
					temp+= factors[j];
				if(temp == 0)
					break;
			}
			if(temp!= 0 )
				return false;
		}
		return true;
	}

}