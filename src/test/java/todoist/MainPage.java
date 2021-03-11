package todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class MainPage {

    public Button signupButton = new Button(By.xpath("//a[@class='_2q_cf' and contains(.,'Signup')]"));
    public Button signupWithEmailButton = new Button(By.xpath("//button[@class='ist_button ist_button_red spinner_btn']"));
    public TextBox emailTextBox = new TextBox(By.xpath("//input[@name='email']"));
    public TextBox nameTextBox = new TextBox(By.xpath("//input[@class='input_name']"));
    public TextBox pwdTextBox = new TextBox(By.xpath("//input[@name='pwd']"));
    public Button finalSignupWithEmailButton = new Button(By.xpath("//button[@class='ist_button ist_button_red spinner_btn' and @id='step_two_submit']"));

    public MainPage() {
    }
}
