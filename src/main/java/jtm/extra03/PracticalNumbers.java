package jtm.extra03;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticalNumbers {

	// TODO Read article https://en.wikipedia.org/wiki/Practical_number
	// Implement method, which returns practical numbers in given range
	// including
	public String getPracticalNumbers(int from, int to) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int num=from; num<=to;num++) {
			boolean isPractical = false;
			ArrayList <Integer> factorList = new ArrayList <Integer>();

			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					factorList.add(i);
				}
			}

			int[] factors = new int[factorList.size()];
			for (int i = 0; i < factors.length; i++) {
				factors[i] = factorList.get(i);
			}

			for (int i = num - 1; i > 0; i--) {
				int temp = i;
				for (int j = factors.length - 1; j >= 0; j--) {
					if (temp > 0) {
						temp -= factors[j];
					}else if (temp < 0) {
						temp += factors[j];
					}else if (temp == 0){
						break;
					}
				}
				if (temp != 0) {
					isPractical = false;
				}else {
					isPractical = true;
				}
			}
			if(isPractical=true){
				result.add(num);}
		}

		return result.toString();
	}
}