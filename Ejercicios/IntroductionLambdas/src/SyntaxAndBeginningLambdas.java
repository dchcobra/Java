
public class SyntaxAndBeginningLambdas {
	public static void main(String[] args) {
		//Expresion simple de lambda
		Runnable r1 = () -> System.out.println("This is my first functional expression");
		r1.run();
		r1.run();
		r1.run();
		
		//Usando CommonPrinter
		CommonPrinter.r1.run();
		CommonPrinter.r1.run();
		CommonPrinter.r1.run();

		System.out.println(CommonPrinter.fs.format("If you want to do this, you certainly can!"));
		
	}
}
