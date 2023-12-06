import entities.InverterClass;
import entities.User;
import functional_interfaces.StringModifier;

public class Main {
	public static void main(String[] args) {

		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		// ***************************** FUNCTIONAL INTERFACE CUSTOM ****************************
		// Se StringModifier è un'interfaccia funzionale, ho 2 opzioni: o il metodo tradizionale che
		// consiste nell'implementare tale interfaccia con una classe concreta, definendo il comportamento
		// del metodo all'interno di tale classe. Oppure con una singola riga di codice scrivo una LAMBDA FUNCTION
		// che definirà il comportamento dell'unico metodo definito all'interno dell'interfaccia


		StringModifier wrapper = stringa -> "---" + stringa + "---";

		StringModifier inverter = str -> {
			String[] splitted = str.split("");
			String inverted = "";
			for (int i = splitted.length - 1; i >= 0; i--) {
				inverted += splitted[i];
			}
			return inverted;
		};

		InverterClass inverterClass = new InverterClass(); // Soluzione "Old style"
		System.out.println((inverterClass.modify("CIAO")));

		System.out.println(wrapper.modify("CIAO"));
		System.out.println(inverter.modify("CIAO"));

	}
}