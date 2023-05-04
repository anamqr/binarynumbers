
public class mainMethod {

	public static void main (String[] args) {
		
		BinaryNumber b1 = new BinaryNumber("0001101011111000111010111010101");
		BinaryNumber b2 = new BinaryNumber("1001010101111110101100110101011");
		
		b1.add(b2);
		//b1 to decimal #
		System.out.println("b1 converts to: " + b1.toDecimal());
		
		//get length
		System.out.println("Length of b1: " + b1.getLength());
		
		//get digit
		System.out.println("Get digit: " + b1.getDigit(0));
		
		//shift
		b1.shiftR(3);
		b2.shiftR(3);
		System.out.println("b1 shifted right by 2: " + b1.toString());
		
		//add
		System.out.println("b1: " + b1.toString());
		System.out.println("b2: " + b2.toString());
				
		b1.add(b2);

	}
}
