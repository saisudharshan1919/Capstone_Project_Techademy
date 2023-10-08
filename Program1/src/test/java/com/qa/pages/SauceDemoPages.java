package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPages {

	WebDriver driver;
	public SauceDemoPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(id = "user-name")
	WebElement UserNameField;
	public WebElement getUserName() {
		return UserNameField;
	}
	@FindBy(id = "password")
	WebElement PasswordFiled;
	public WebElement getPassword() {
		return PasswordFiled;
	}
	
	@FindBy(id = "login-button")
	WebElement LoginBtn;
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	@FindBy(xpath = "//*[@class=\"app_logo\"]")
	WebElement TitleField;
	public WebElement getTitleField() {
		return TitleField;
	}
	
	@FindBy(xpath = "//*[@class=\"footer_copy\"]")
	WebElement FooterField;
	public WebElement getFooterField() {
		return FooterField;
	}
	
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
	WebElement invalidTexterror;
	public WebElement getInvalidTextError() {
		return invalidTexterror;
	}
}
