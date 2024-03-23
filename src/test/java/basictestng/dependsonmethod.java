package basictestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsonmethod {

	@Test(dependsOnMethods="Signin")
	public void Signup() {
		System.out.println("Signup");
	}
	@Test()
	public void Signin() {
		System.out.println("Signup");
		Assert.assertEquals("Pune", "Mumbai");
	}
	@Test()
	public void Signout() {
		System.out.println("Signout");
	}
	

}
