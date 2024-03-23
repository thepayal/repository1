package commonUtiles;

import java.util.Random;

public class JavaUtil {

	public int randomnumber(String[] args) {
		Random r=new Random();
		int run =r.nextInt(500);
		return run;
	}

}
