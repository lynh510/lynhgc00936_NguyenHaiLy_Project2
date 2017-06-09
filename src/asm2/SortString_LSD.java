package asm2;

public class SortString_LSD {
	
	public static void main(String[] args) 
	{
		String[] a = {"158", "124", "238", "707", "608", "250", "888"};
		try {
			sort(a, 3);
//			sort(a, 4);
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("String index out of range! Maximum index in this string is 3.");
//			sort(a, 3);			or other number is less than 4
			System.exit(0);
		}
		
		System.out.println("String is sorted:");
		for (String string : a) {
			System.out.println(string);
		}
	}
	
	private static void sort(String[] a, int t) {
		int R = 256;
		int N = a.length;
		//Sort character from right to left 
		for(int d = t - 1; d >= 0; d-- ) {
			//Step1: count frequency
			int[] count = new int [R+1];
			for(int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			//Step 2: transform count to indices
			for(int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}
			//Step3: Access cumulates
			String aux[] = new String [N];
			for(int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			//Steps 4: copyback to original array
			System.arraycopy(aux, 0, a, 0, N);
		}
	}
}


