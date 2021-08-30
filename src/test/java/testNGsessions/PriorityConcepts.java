package testNGsessions;

import org.testng.annotations.Test;

public class PriorityConcepts {

	@Test
	public void a_test() {
		System.out.println("a test");
	}
	@Test(priority=0)
	public void b_test() {
		System.out.println("b test");
	}
	@Test(priority=2)
	public void c_test() {
		System.out.println("c test");
	}
	@Test(priority=-1)
	public void d_test() {
		System.out.println("d test");
	}
	@Test
	public void e_test() {
		System.out.println("e test");
	}

}
