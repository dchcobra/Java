package HelloWorld;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctxt = 
				new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld hw = (HelloWorld) ctxt.getBean("helloWorld");
		hw.getMessage();
	}
}
