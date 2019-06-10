package sablony;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SablonatorTest {

	@Test
	public void basic() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("jmeno", "Pepa");
		assertEquals("Jmeno: Pepa \n", Sablonator.ryplejs(new Scanner("Jmeno: {{ jmeno }}"), map));
	}
	
	@Test
	public void twoReplaces() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("jmeno", "Pepa");
		map.put("prijmeni", "Okurka");
		assertEquals("Jmeno: Pepa \n"
				+ "Prijmeni: Okurka \n", Sablonator.ryplejs(new Scanner("Jmeno: {{ jmeno }} \n"
						+ "Prijmeni: {{ prijmeni }}"), map));
		
	}
	
	@Test
	public void moreReplacesinLine() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("jmeno", "Pepa");
		map.put("otcestvo", "Pepovic");
		map.put("prijmeni", "Okurka");
		assertEquals("Jmeno: Pepa "
				+ "Otcestvo: Pepovic "
				+ "Prijmeni: Okurka \n", Sablonator.ryplejs(new Scanner("Jmeno: {{ jmeno }} "
						+ "Otcestvo: {{ otcestvo }} "
						+ "Prijmeni: {{ prijmeni }}"), map));
	}
	
	@Test
	public void moreUsesOfTheSameKey() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("jmeno", "Pepa");
		map.put("prijmeni", "Okurka");
		assertEquals("Jmeno: Pepa \n"
				+ "Druhe jmeno: Pepa \n"
				+ "Prijmeni: Okurka \n", Sablonator.ryplejs(new Scanner("Jmeno: {{ jmeno }} \n"
						+ "Druhe jmeno: {{ jmeno }} \n"
						+ "Prijmeni: {{ prijmeni }}"), map));
	}
	
	@Test
	public void moreWordsKey() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("jmeno uzivatele", "Pepa");
		assertEquals("Jmeno: Pepa \n", Sablonator.ryplejs(new Scanner("Jmeno: {{ jmeno uzivatele }}"), map));
	}

}
