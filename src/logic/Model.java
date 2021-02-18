package logic;

public class Model {

	public Double calculate(Double num1, Double num2, String oper) {
        switch (oper) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0.0)
                    return null;

                return num1 / num2;
            default:
            	return null;
        }
    }
	
	public Double switchSign(Double num) {
		num = num * (-1);
		
		return num;
	}
	
}
