package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
	
	@FXML
    private Label display;
	
	private Model model = new Model();
    private Double num1 = 0.0;
    private String oper = "";
    private boolean start = true;

    @FXML
    private void num(ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }

        String input = ((Button)event.getSource()).getText();
        if (input.equals("."))
        	if (display.getText().equals(""))
        		display.setText("0" + input);
        	else 
        		display.setText(display.getText() + input);
        else if (input.equals("DEL")) {
        	display.setText("");
        	num1 = 0.0;
        	oper = "";
        }
        else
        	display.setText(display.getText() + input);
    }

    @FXML
    private void oper(ActionEvent event) {
        String input = ((Button)event.getSource()).getText();
        String result = "";

        if (!"=".equals(input)) {
            if (!oper.isEmpty())
                return;
            
            num1 = Double.parseDouble(display.getText());
            oper = input;
            display.setText("");
        }
        else {
            if (oper.isEmpty())
                return;

            result = String.valueOf(model.calculate(num1, Double.parseDouble(display.getText()), oper));
            if (result == "null")
            	display.setText("MATH ERROR");
            else {
            	display.setText(result);
            }
            oper = "";
            start = true;
        }
    }
    
    @FXML
    private void changeSign(ActionEvent event) {
    	String input = display.getText();
    	
    	display.setText(String.valueOf(model.switchSign(Double.parseDouble(input))));
    }
}
