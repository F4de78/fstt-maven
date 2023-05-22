package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import POs.LoginFormPO;
import POs.LoginSuccessPO;

public class BasicLoginTest extends DriverLifeCycleSetting {
	
	private LoginFormPO login;
	private LoginSuccessPO loginSuccess;
	
	@Test
	public void testLoginOK() {
		login = new LoginFormPO(driver);
		login.with("user", "user");
		
		loginSuccess = new LoginSuccessPO(driver);
		assertTrue(loginSuccess.successBoxIsPresent());
	}
	
	@Test
	public void testLoginNoOK() {
		login = new LoginFormPO(driver);
		login.with("user", "error");
		
		assertTrue(login.invalidBoxIsPresent());
	}
}