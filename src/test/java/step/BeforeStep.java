package step;


import io.cucumber.java.en.Given;

import static com.codeborne.selenide.Selenide.open;

public class BeforeStep {

    @Given("Отрываем сайт {string}")
    public void openWebSite(String url){
        open(url);
    }
}
