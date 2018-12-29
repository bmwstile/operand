import org.junit.*;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import java.util.List;

@Title("Тестовое задание")
public class operandTest {
    public String operand1;
    public String operand2;
    public String operation ;
    public String result;
    public String[] strings;

    @Test
    public void start() {
        final List<String[]> data = fileRead.readFile("src/main/resources/datafile");
        for (int i = 0; i < data.size(); i++) {
            strings = data.get(i);
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
                if(j==0)
                    operand1 = strings[j];
                if(j==1)
                    operand2 = strings[j];
                if(j==2)
                    operation = strings[j];
                if(j==3)
                    result = strings[j];
            }

            if (operation.equals("+")) {
                System.out.println("Сложение");
                additionTest(operand1,operand2,result);

            } else if (operation.equals("-")) {
                System.out.println("Вычитание");
                subtractTest(operand1,operand2,result);

            } else if (operation.equals("*")) {
                System.out.println("Умножение");
                multiplyingTest(operand1,operand2,result);

            } else if (operation.equals("/")) {
                System.out.println("Деление");
                divisionTest(operand1,operand2,result);

            } else {
                System.out.println("Не верная операция");
            }

            System.out.println();
        }
    }

    @Step
    public void additionTest(String operand1, String operand2, String result) {
        System.out.println("Первое число: " + operand1+ " Второе число: " + operand2 + ", Результат: " + result + " ");
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) + Integer.parseInt(operand2);
        System.out.println("Актуальный результат: "+actualResult+"");
        System.out.println("Результат в файле: "+result+"");
        try {
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError error){
            System.out.println("неверно");
        }
    }

    @Step
    public void subtractTest(String operand1, String operand2, String result) {
        System.out.println("Первое число: " + operand1+ " Второе число: " + operand2 + ", Результат: " + result + " ");
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) - Integer.parseInt(operand2);
        System.out.println("Актуальный результат: "+actualResult+"");
        System.out.println("Результат в файле: "+result+"");
        try {
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError error){
            System.out.println("неверно");
        }
    }

    @Step
    public void multiplyingTest(String operand1, String operand2, String result) {
        System.out.println("Первое число: " + operand1+ " Второе число: " + operand2 + ", Результат: " + result + " ");
        int expectedResult = Integer.parseInt(result);
        int actualResult = Integer.parseInt(operand1) * Integer.parseInt(operand2);
        System.out.println("Актуальный результат: "+actualResult+"");
        System.out.println("Результат в файле: "+result+"");
        try {
            Assert.assertEquals(expectedResult, actualResult);
        }
        catch (AssertionError error){
            System.out.println("неверно");
        }
    }

    @Step
    public void divisionTest(String operand1, String operand2, String result) {
        System.out.println("Первое число: " + operand1+ " Второе число: " + operand2 + ", Результат: " + result + " ");
        int expectedResult = Integer.parseInt(result);
        int actualResult;
        try {
            actualResult = Integer.parseInt(operand1) / Integer.parseInt(operand2);
            System.out.println("Актуальный результат: "+actualResult+"");
            System.out.println("Результат в файле: "+result+"");
            Assert.assertEquals(expectedResult, actualResult);
        } catch (ArithmeticException ex) {
            System.out.println("Деление на 0");
        }
    }




}
