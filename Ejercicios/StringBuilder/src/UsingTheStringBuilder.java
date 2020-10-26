
public class UsingTheStringBuilder {
	public static void main(String[] args) {
		String one = "Welcome to";
		String two = "Java programming";
		String result1 = one + " " + two;
		System.out.println(result1);
		
		String result2 = String.format("%s %s"
										, one
										, two);
		System.out.println(result2);
		
		StringBuilder sb = new StringBuilder();
		sb.append(one);
		sb.append(" ");
		sb.append(two);
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append("] ");
			sb.append("completed");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
