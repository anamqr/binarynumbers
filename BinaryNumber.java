//Anam Qureshi
//Big-endian format is used
//While testing, whenever a method is called in main, it will
//take that new number for the next method that is called.

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryNumber {
	 private int[] data;
	 private boolean overflow = false;
	 
	 public BinaryNumber(int length) {
		 data = new int[length];
		 int i;
		 for (i = 0; i < length; i++) {
			 data[i] = 0;
		 }
	 }
	 
	 public BinaryNumber (String str) {
		 int length = str.length();
		 data = new int[length];
		 for (int i = 0; i < str.length(); i++) {
			 char letter = str.charAt(i);
			 data[i] = Character.getNumericValue(letter);
			// data[i] = convertedLetter;
		 }
	 }
	 
	public int getLength() {
		return data.length;
	}
	
	public int getDigit(int index) {
		return data[index];
	}
	
	public int toDecimal() { //Big-endian format used
		int digit = 0;
		for (int i = 0; i < data.length; i++) {
		digit += data[i] * Math.pow(2, data.length - 1 - i);
		}
		return digit;
	}
	
	public void shiftR(int amount) {
	/*	int newArray[] = Arrays.copyOf(data,amount+data.length);
		int temp, last;
		for(int i=0;i<amount;i++) {
			last = newArray[newArray.length-1];
			for(int j=0;j<newArray.length;j++) {
				temp = newArray[j];
				newArray[j] = last;
				last = temp;
			}
		}
		data = newArray;*/
		int[] amountToShift = new int[data.length + amount];
		
		//shift numbers to make room for 0s
		for (int i = 0; i < data.length; i++) {
			amountToShift[i + amount] = data[i];
		}
		//add 0s
		for (int i = 0; i < amount; i++) {
			amountToShift[i] = 0;
		}
		this.data = amountToShift;
		System.out.println(Arrays.toString(data));
		}
	
	//will add shifted binary, omit for testing
	//big endian used
	 public void add (BinaryNumber aBinaryNumber) {
		 int length = this.data.length;
		 int carry = 0;

		 if (length != aBinaryNumber.data.length) {
			throw new IllegalArgumentException ("Lengths of binary numbers do not coincide. Try again.");
		}
		//increase size
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 
		//addition
		for (int i = length - 1; i >= 0; i--) {
			int sum = getDigit(i) + aBinaryNumber.getDigit(i) + carry;
			if (sum > 1) {
				carry = 1;
				list.add(0, sum - 2);
				}
			else {
				carry = 0;
				list.add(0, sum);
				}
			}

		if (carry == 1) {
			list.add(0, 1);
		}
		
		int[] outputArray = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			outputArray[i] = list.get(i);
			}
		if (list.size() > data.length) {
			overflow = true;
		}
		this.data = outputArray;
		System.out.println(toString());
		
		
		}
	 
	 
	public String toString() { 
		if (overflow == true) {
			return "Overflow " + Arrays.toString(data);
		}
		else {
			return Arrays.toString(data);
		}
	}
	public void clearOverflow() {
		overflow = false;
	}
	
	}
	

