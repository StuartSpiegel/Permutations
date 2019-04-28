import java.util.Scanner;
/**
 * 
 * @author Stuart Spiegel
 * The number of ways to Permute a String of length N characters (specified by user): args: length of String (N)
 * The running time of this algorithm is O(N!) as there are N! possibilities. 
 *
 */
public class Permutations {

	public static void main(String[] args) {

		// read user input for n
		Scanner input = new Scanner(System.in);
		int totalSize = input.nextInt();

		Permutations obj1 = new Permutations();
		int toSolve[] = new int[totalSize];

		
		for (int k = 0; k < toSolve.length; k++) {
			toSolve[k] = k;
		}

		obj1.solvePermutations(toSolve, toSolve.length, toSolve.length);
		obj1.printArray(toSolve, toSolve.length);

	}

	public void solvePermutations(int[] permute, int size, int n) {

		// base case, if size = 1 then prints the permutation
		if (size == 1) {
			printArray(permute, n);
		} else {

			for (int i = 0; i < size - 1; i++) {
				solvePermutations(permute, size - 1, n);

				// if size is even
				if (size-1 % 2 == 0) {
					int toSwap = permute[i];
					permute[i] = permute[size - 1];
					permute[size - 1] = toSwap; //swap permute[i] and permute[size-1]

				} else {
					// if size is odd
					
					int toSwap = permute[0]; // do the swap
					permute[0] = permute[size - 1];
					permute[size - 1] = toSwap; //swap permute[0] and permute[size-1]
					
				}

			}

			solvePermutations(permute, size - 1, n);
		}

	}

	public void printArray(int[] permute, int n) {

		for (int j = 0; j < n; j++) {
			System.out.print(permute[j]);

		}
		System.out.println();

	}

}
