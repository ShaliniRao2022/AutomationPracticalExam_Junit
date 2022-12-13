package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class JunitExamPage extends BasePage {

	WebDriver driver;

	public JunitExamPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement addButtonElement;
	@FindBy(how = How.NAME, using = "data")
	WebElement addTextElement;
	@FindBy(how = How.NAME, using = "allbox")
	WebElement toggleAllCheckboxElement;
	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement removeButtonElement;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	List<WebElement> allCheckBoxes;
	
	public void createListItems(String text) {

		addTextElement.sendKeys(text);
	}

	public void clickOnAddButton() {

		clickWebElement(addButtonElement);
	}

	public boolean checkIfAllCheckBoxesAreSelected() {
		boolean allCheckBoxesAreSelected = false;
		for (int i = 0; i < allCheckBoxes.size(); i++) {

			if (allCheckBoxes.get(i).isSelected()) {
				System.out.println(i + " is selected");
				allCheckBoxesAreSelected = true;
			} 
		}
			return allCheckBoxesAreSelected;
	}

	public void clickOnToggleAllCheckbox() {

		clickWebElement(toggleAllCheckboxElement);
	}

		public void clickOnRemoveButton() {

		clickWebElement(removeButtonElement);
	}

	public void checkOneCheckbox() {

		int count = allCheckBoxes.size();
		System.out.println("Count of checkbox:"+count);
		int checkboxToClick = BasePage.generateRandomNumber(count);
		System.out.println("Checkbox chosen:"+checkboxToClick); 
		clickWebElement(allCheckBoxes.get(checkboxToClick));

	}
	public int getNumberOfCheckboxes() {

		return allCheckBoxes.size();
	}
	

}
