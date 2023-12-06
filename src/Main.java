import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {

/*		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);*/

		// ***************************** FUNCTIONAL INTERFACE CUSTOM ****************************
		// Se StringModifier è un'interfaccia funzionale, ho 2 opzioni: o il metodo tradizionale che
		// consiste nell'implementare tale interfaccia con una classe concreta, definendo il comportamento
		// del metodo all'interno di tale classe. Oppure con una singola riga di codice scrivo una LAMBDA FUNCTION
		// che definirà il comportamento dell'unico metodo definito all'interno dell'interfaccia


/*		StringModifier wrapper = stringa -> "---" + stringa + "---";

		StringModifier inverter = str -> {
			String[] splitted = str.split("");
			String inverted = "";
			for (int i = splitted.length - 1; i >= 0; i--) {
				inverted += splitted[i];
			}
			return inverted;
		};*/

/*		InverterClass inverterClass = new InverterClass(); // Soluzione "Old style"
		System.out.println((inverterClass.modify("CIAO")));

		System.out.println(wrapper.modify("CIAO"));
		System.out.println(inverter.modify("CIAO"));*/

		// ********************************** PREDICATES *****************************
/*		Predicate<Integer> isMoreThanZero = num -> num > 0;
		Predicate<Integer> isLessThanHundred = num -> num < 100;

		Predicate<Integer> isMoreThanZeroAndLessThanHundred = isMoreThanZero.and(isLessThanHundred);

		System.out.println(isMoreThanZeroAndLessThanHundred.test(aldo.getAge()));*/

		// ************************************ SUPPLIER *****************************

/*		Supplier<Integer> integerSupplier = () -> {
			// Il supplier ci consente di definire una funzione che ci fornisce oggetti, numeri, stringhe create secondo un certo criterio all'occorrenza
			Random rndm = new Random();
			return rndm.nextInt(1, 101);
		};

		List<Integer> interiRandom = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			interiRandom.add(integerSupplier.get()); // .get() è il metodo dell'interfaccia Supplier che ci fornisce in questo caso un numero intero random
		}

		System.out.println(interiRandom);

		Supplier<User> userSupplier = () -> new User("NOME", "COGNOME", integerSupplier.get());

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			users.add(userSupplier.get());
		}

		users.forEach(user -> System.out.println(user));*/
		// users.forEach(System.out::println); // identica a sopra però un pelo più compatta

		// ****************************************************** STREAMS *****************************************************

		Supplier<Integer> integerSupplier = () -> {
			Random rndm = new Random();
			return rndm.nextInt(1, 101);
		};
/*
		List<Integer> interiRandom = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			interiRandom.add(integerSupplier.get());
		}

		interiRandom.forEach(System.out::println);

		System.out.println("---------------------------------- FILTER --------------------------------------");
		// System.out.println(interiRandom.stream().filter(num -> num < 20)); // Non serve a molto stampare a video uno Stream
		interiRandom.stream().filter(num -> num < 20).forEach(System.out::println); // Anche il foreach è un'operazione terminale per gli stream

		System.out.println("------------------------------ FILTER & PREDICATES ------------------------------");
		Predicate<Integer> isMoreThanTen = num -> num > 10;
		Predicate<Integer> isLessThanTwenty = num -> num < 20;

		interiRandom.stream().filter(isMoreThanTen.and(isLessThanTwenty)).forEach(System.out::println);*/

/*
		System.out.println("---------------------------------- MAP --------------------------------------");

		Supplier<User> userSupplier = () -> new User("NOME", "COGNOME", integerSupplier.get());

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			users.add(userSupplier.get());
		}

		users.stream().map(user -> user.getAge()).forEach(età -> System.out.println(età));
		// users.stream().map(User::getAge).forEach(System.out::println);

		System.out.println(" -------------------------------- MAP & FILTER --------------------------------");

		users.stream().map(user -> user.getAge()).filter(età -> età < 18).forEach(età -> System.out.println(età));

		List<Integer> etàDegliUserMinorenni = users.stream().map(user -> user.getAge()).filter(età -> età < 18).toList();
		// toList() chiude lo Stream restituendomi una Lista. toList è un'alternativa più pratica del .collect quando siamo sicuri di voler fare confluire il tutto in una lista
		List<String> nomiDeiMinorenni = users.stream().filter(user -> user.getAge() < 18).map(user -> user.getName()).toList();
		nomiDeiMinorenni.forEach(user -> System.out.println(user));


		System.out.println(" -------------------------------- REDUCE --------------------------------");
		int totalAge = users.stream().map(user -> user.getAge()).reduce(0, (partialSum, currentElem) -> partialSum + currentElem);
		System.out.println("Età totale degli user: " + totalAge);


		System.out.println(" -------------------------------- ALLMATCH & ANYMATCH --------------------------------");
		// .some() .every() di JavaScript corrispondono a .allMatch e .anyMatch di Java

		// Controllo se tutti gli utenti sono maggiorenni
		if (users.stream().allMatch(user -> user.getAge() >= 18)) {// allMatch mi torna true/false a seconda se la condizione è soddisfatta per TUTTI gli elementi
			System.out.println("Sono tutti maggiorenni");
		} else {
			System.out.println("C'è qualche minorenne");
		}
		// Controllo se gli utenti filtrati sono maggiorenni
		if (users.stream().filter(user -> user.getAge() >= 18).allMatch(user -> user.getAge() >= 18)) {// allMatch mi torna true/false a seconda se la condizione è soddisfatta per TUTTI gli elementi
			System.out.println("Sono tutti maggiorenni");
		} else {
			System.out.println("C'è qualche minorenne");
		}

		if (users.stream().anyMatch(user -> user.getAge() >= 99)) {
			System.out.println("C'è ALMENO uno che ha 99 anni");
		} else {
			System.out.println("Non ce n'è nessuno");
		}
*/

		// ****************************************************** DATE *************************************************
		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalDate tomorrow = today.plusDays(1);
		System.out.println(tomorrow);

		LocalDate yesterday = today.minusDays(1);
		System.out.println(yesterday);

		LocalDate nextYear = today.plusYears(1);
		System.out.println(nextYear);

		System.out.println(yesterday.isBefore(tomorrow));

		LocalDate date = LocalDate.parse("2023-10-31");
		System.out.println(date);

		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date));
		System.out.println(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

	}

}