package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.JunitExamPage;
import util.BrowserFactory;

public class JunitExamTest {

	WebDriver driver;

	@Before
	public void launchBrowser() {
		driver = BrowserFactory.init();
	}

	/*
	 * TC1: Validate when the toggle all check box is CHECKED, all check boxes for
	 * list items are also CHECKED ON.
	 */

	@Test
	// public void userShouldBeAbleToClickOnToggleAllCheckboxAndValidate() {
	public void TC1() {
		JunitExamPage junitExamPage = PageFactory.initElements(driver, JunitExamPage.class);
		junitExamPage.createListItems("checkbox1");
		junitExamPage.clickOnAddButton();
		junitExamPage.createListItems("checkbox2");
		junitExamPage.clickOnAddButton();
		junitExamPage.createListItems("checkbox3");
		junitExamPage.clickOnAddButton();
		junitExamPage.clickOnToggleAllCheckbox();
		Assert.assertTrue("Not all are selected!", junitExamPage.checkIfAllCheckBoxesAreSelected());
	}

	/*
	 * TC2: Validate that a single list item could be removed using the remove
	 * button when a single checkbox is selected.
	 */

	@Test
	// public void userShouldBeAbleToRemoveSingleListItemAndValidate() {
	public void TC2() {
		JunitExamPage junitExamPage = PageFactory.initElements(driver, JunitExamPage.class);
		Integer i = junitExamPage.getNumberOfCheckboxes();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		junitExamPage.checkOneCheckbox();
		junitExamPage.clickOnRemoveButton();
		Integer j = junitExamPage.getNumberOfCheckboxes();
		Assert.assertNotSame(i, j);
	}

	/*
	 * TC3: Validate that all list item could be removed using the remove button and
	 * when "Toggle All" functionality is on.
	 */
	@Test
	public void TC3() {
		JunitExamPage junitExamPage = PageFactory.initElements(driver, JunitExamPage.class);
		junitExamPage.clickOnToggleAllCheckbox();
		junitExamPage.clickOnRemoveButton();
		Assert.assertEquals(1, junitExamPage.getNumberOfCheckboxes());
		

	}
	@After
	public void tearDown() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BrowserFactory.tearDown();
	}
	
}
