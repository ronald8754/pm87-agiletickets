package br.com.caelum.agiletickets.acceptance.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReservasPage {

	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;

	public ReservasPage(WebDriver driver) {
		this.driver = driver;
	}

	public void abreListagem() {
		driver.get(BASE_URL + "/reservas");
	}

	public void adicioneReserva(String quantidade) {
		WebElement form = form();
		form.findElement(By.name("reserva.quantidade")).sendKeys(quantidade);
		form.submit();
	}


	private WebElement form() {
		return driver.findElement(By.id("addForm"));
	}

	
}
