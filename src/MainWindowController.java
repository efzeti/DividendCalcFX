import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class MainWindowController {
    public TextField stockPrice;
    public TextField quarterlyDividend;
    public TextField monthlyInvestments;
    public TextField initialStockAmount;
    public DatePicker deadLine;
    public TextField finalStatus;


    public void clearFields(ActionEvent event) {
        stockPrice.clear();
        quarterlyDividend.clear();
        monthlyInvestments.clear();
        initialStockAmount.clear();
        deadLine.getEditor().clear();
        finalStatus.clear();
    }

    public void calculateResult(ActionEvent event) {
        
    }
}
