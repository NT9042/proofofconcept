package designPatterns;

public class Mentor extends Connection{

	private Mentor() {
		
	}
	
	private static Mentor mentor;
	private static boolean isPro = true;
	
	public static Mentor getMentor(){
		if(mentor == null){
			mentor = new Mentor();
		}
		
		return mentor;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static final boolean isPro() {
		return isPro;
	}

	public static void setPro(boolean isPro) {
		mentor.isPro = isPro;
	}

	public static boolean isLearned() {
		return isLearned;
	}

	public static void setLearned(boolean isLearned) {
		mentor.isLearned = isLearned;
	}

	private static boolean isLearned = true;
		
	
	
	
}
