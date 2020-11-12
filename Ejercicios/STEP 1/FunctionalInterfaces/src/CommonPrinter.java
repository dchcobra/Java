
public class CommonPrinter {
	//Creamos el "run" estatico
	public static Runnable r1 = () -> System.out.println("This is my first functional expression (2)"); 
	
	// definimos la interfaz para el "FormatString"
	interface FormatString {String format(String value); }

	// Creamos la expresion para el tipo de interfaz
	public static FormatString fs = (String value) -> {
		return "From my first functional formatter: " + value;
	};
	
	//Deinimos la interfaz para mostrar el objeto
	interface PrintObject {void printConsole(Object value);}
	
	//Creamos para mostrar el objeto usando typeinterface
	public static PrintObject po = (value) -> {
		System.out.println("From my first functional service: " + value.toString());
	};
}
