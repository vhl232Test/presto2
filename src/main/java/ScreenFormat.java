public class ScreenFormat {

	public static void main(String[] args) {
		int a = 127;
		int z = 7;

		String q = "";

		q = String.format("my var = %06d;   %012d%%", a, z);
		System.out.println(q);

		int zzz = 5;
		System.out.println(zzz++);
		zzz = 100;
		System.out.println(++zzz);
	}
}
