
public class CommonPrinter {
	//Creamos el "run" estatico
	public static Runnable r1 = () -> System.out.println("This is my first functional expression (2)"); 
	// definimos la interfaz para el "FormatString"
	interface FormatString {String format(String value); }
	// Creamos la expresion para el tipo de interfaz
	public static FormatString fs = (String value) -> {
		return "From my first functional service: " + value;
	};
}
