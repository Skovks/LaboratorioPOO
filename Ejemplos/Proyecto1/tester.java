
public class tester {

	public static void main(String[] args) {
		Ejemplo1 instancia = new Ejemplo1("Ramon",22);
		Ejemplo2 instancia2 = new Ejemplo2("Raul",26,"Masculino");
		System.out.println(instancia.toString());
		System.out.println(instancia2.toString());
		System.out.println(Ejemplo2.suma(4,6));
	}

}
