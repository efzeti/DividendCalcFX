import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class MainWindowController {
    @FXML
    public TextField stockPrice;
    public TextField quarterlyDividend;
    public TextField monthlyInvestments;
    public TextField initialStockAmount;
    public DatePicker deadLine;
    public TextField finalStatus;

    @FXML
    public void initialize(){
        stockPrice.setText("49.33");
        quarterlyDividend.setText("0.41");
        monthlyInvestments.setText("100.00");
        initialStockAmount.setText("0");
        deadLine.setValue(LocalDate.of(2062,11,1));
        finalStatus.setText("Example data in, click calculate to see the result");
    }


    public void clearFields(ActionEvent event) {
        stockPrice.clear();
        quarterlyDividend.clear();
        monthlyInvestments.clear();
        initialStockAmount.clear();
        deadLine.getEditor().clear();
        finalStatus.clear();
    }

    public void calculateResult(ActionEvent event) {

        try {

            double stockPrc = Double.parseDouble(stockPrice.getText());
            double quarterlyDvd = Double.parseDouble(quarterlyDividend.getText());
            double monthlyInv = Double.parseDouble(monthlyInvestments.getText());
            double initialStkAmt = Double.parseDouble(initialStockAmount.getText());

            if (initialStkAmt % 1 != 0){
                initialStockAmount.setText(String.format("%d", (int) initialStkAmt));
            }


            finalStatus.setText(DividendCalculatorMachine.getInstance().calculate(stockPrc, quarterlyDvd, monthlyInv, (int) initialStkAmt, deadLine.getValue()));

        } catch (NumberFormatException e){

            System.out.println("Wrong input");

            finalStatus.setText("Wrong input");
        }


    }
}
