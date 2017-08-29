package drivers;

public class TestReturn {

	public static void main(String[] args) {
		System.out.println(getNumber1());
	}

	@SuppressWarnings("finally")
	public static int getNumber() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
	
	@SuppressWarnings("finally")
	public static int getNumber1() {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
}
