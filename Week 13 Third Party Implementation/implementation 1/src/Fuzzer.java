
import java.util.ArrayList;


import java.util.Random;

public class Fuzzer {
	public static String simple(){
		
		// strings of any length between 0 and 1024
		RANDOM.setSeed(System.currentTimeMillis());
		int stringLength = (RANDOM.nextInt() & Integer.MAX_VALUE) % 1_024;
		//printf("input length = %d\n", string_length);

		//allocate memory for the input
		System.out.print("fuzzer string length:");
		System.out.print(stringLength);
		System.out.print("\n");
        //ArrayList<String> input = new ArrayList<>(stringLength+1);
        String input="";
		//generate a random character at each location of the string
		for(int index = 0; index < stringLength; index++) {
			double between0And1 = (double)(RANDOM.nextInt() & Integer.MAX_VALUE) / (double)Integer.MAX_VALUE;
			//generate a character between ASCII 32 and 128
            String c= Character.toString((char)((int)(between0And1 * 96 + 32)));
			input+=c;
		}
		input+="\0";
		// here is the input string to fuzz
		return(input);
	}

	public final static Random RANDOM = new Random(1);

	

}
