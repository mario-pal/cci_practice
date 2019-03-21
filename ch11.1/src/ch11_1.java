public class ch11_1 {
	public static void main(String[] args) {
		//Find the mistake in the following piece of C code
		unsigned int i;
		for(i = 100; i>=0; --1)
			printf("%d\n", i);

		
		//Solution
		/*Because i is an unsigned int, the for loop condition will always
		 * be true. Therefore the loop above is an infinite loop.
		 * Furthermore, it appears that the intent is to print the list
		 * of numbers from 100 to 1.
		 * The format specifier %d will print the signed decimal integer.
		 * %u should be used instead.
		 */
		unsigned int i;
		for(i = 100; i > 0; i--) {
			printf("%u\n", i);
		}
	}

}
