package step;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.$x;

public class AxenixStep {
    int place = 110;
    String StrMassOfComp;

    SelenideElement hhButton = $x("//img[@alt = 'top 100']");
    SelenideElement searchString = $x("//input[@placeholder = 'Поиск по названию']");
    SelenideElement axenixPlace = $x("//div[@class = 'be4_vkoAhD']//span[@class = '_22b_Irq0Rl _982_mCtCzt']");
    SelenideElement axenixCol = $x("//*[contains(text(),'Крупные компании')]");
    SelenideElement forColor = $x("//div[@class='_137_E3ZhTH f10_8QZTfq']");

    @When("Открываем HH таблицу")
    public void clickOnHHButton(){
        hhButton.click();
        WebDriver window = Selenide.switchTo().window(1);
    }

    @And("Находим Axenix, запоминаем место")
    public void getAxenixPlace() {
        searchString.setValue("Axenix");
        if (forColor.getCssValue("background-color").equals("rgba(121, 68, 193, 1)")){
            place = Integer.parseInt(axenixPlace.getText());
            //StrMassOfComp = axenixCol.getAttribute("data-tooltip-content"); - для следующего теста
        }
    }

    @Then("Фиксируем что место меньше {int}")
    public void placeInTop100(int maxValue) {
        System.out.println("Место в рейтинге " + place);
        Assert.assertTrue("Ожидаемый результат меньше " + maxValue + " ,а получился " + place, maxValue > place);
    }
}
