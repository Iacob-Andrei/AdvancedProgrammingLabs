
public class Main {

	public static int sumOfDigits(int number) {
		
		int sum = 0;
		
		System.out.println(number);
		
		do {
			while(number > 9) {
				sum += number%10;
				number /= 10;
			}
			
			number += sum;
			sum = 0;
		}while(number > 9);
		
		System.out.println(number);
		
		return number;
	}
	
	public static int add(int number, String binary, int base) {
		
		int decimal = Integer.parseInt(binary, base);
		number += decimal;
		
		return number;
	}
	
	public static int create () {
		
		int n = (int) (Math.random() * 1_000_000);
		
		n *= 3;
		n = add( n, "10101", 2);	
		n = add( n, "FF"  , 16);
		n *= 6;
		n = sumOfDigits(n);
		
		return n;
	}
	
	public static void main(String[] args) {
		
		String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
		
		System.out.println("Willy-nilly, this semester I will learn " + languages[create()]);
	}
	
}
