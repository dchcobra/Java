import CustomObjects.Person;

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
		
		// Creamos la interfaz comun para el getString
		System.out.println(CommonPrinter.fs.format("If you want to do this, you certainly can!"));
		
		// Creamos la interfaz comun para mostrar cualquier
		CommonPrinter.po.printConsole("Any Object works!");
		CommonPrinter.po.printConsole(50);
		CommonPrinter.po.printConsole(true);
		CommonPrinter.po.printConsole(new Person("Jonh", "Smith", 48));

		//Podemos stackear varias expresiones si tienen los formatos correctos
		CommonPrinter.po.printConsole(CommonPrinter.fs.format("My first is"));
		CommonPrinter.po.printConsole("able to be formatted twice!");


	}
}
