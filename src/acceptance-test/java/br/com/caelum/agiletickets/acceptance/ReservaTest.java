package br.com.caelum.agiletickets.acceptance;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.acceptance.page.ReservasPage;

public class ReservaTest {

	public static String BASE_URL = "http://localhost:8080";
	private static WebDriver browser;
	private ReservasPage reservas;

	@BeforeClass
	public static void abreBrowser() {
		browser = new FirefoxDriver();
	}

	@Before
	public void setUp() throws Exception {
		reservas = new ReservasPage(browser);
	}

	@AfterClass
	public static void teardown() {
		browser.close();
	}
	
	@Test
	public void simularReserva() throws Exception {
		reservas.adicioneReserva("1");
	}

}
