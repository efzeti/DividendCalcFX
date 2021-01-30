import java.util.Calendar;

public class DividendCalculatorMachine {

    private static DividendCalculatorMachine instance = new DividendCalculatorMachine();

    private DividendCalculatorMachine() {
    }

    public static DividendCalculatorMachine getInstance() {
        return instance;
    }

    public String calculate(double stockPrice, double dividend, double investments, int stockCount) {


        int month = 1 + Calendar.getInstance().get(Calendar.MONTH); // TODAYS DATE
        int year = Calendar.getInstance().get(Calendar.YEAR);       // TODAYS DATE

//        double stockPrice = 49.33;          // CURRENT STOCK PRICE
//        double dividend = 0.41;             // CURRENT DIVIDEND

        double stockDiff;
        double dividendDiff;

//        double investments = 100.00;        // THIS IS HOW MUCH $ YOU WANT TO INVEST INTO STOCK MONTHLY
        double balance = investments;
//        int stockCount = 0;                 // THIS IS HOW MUCH STOCKS YOU HAVE AT THE BEGINNING
        int newStock;

        boolean diffs = false;              // CHANGE TO TRUE FOR SOME SMALL CHANGES IN DIVIDENDS AND STOCK PRICES

        int endYear = 2062;
        int endMonth = 11;

        int period2 = 1 + 12 * (endYear - year) + endMonth - month;

        int period = 503;                   // THIS IS HOW MANY MONTHS YOU WANT TO INVEST
        int dividendPeriod = 3;             // THIS IS HOW OFTEN THE COMPANY PAYS DIVIDENDS (3 - QUARTERLY, 6 - HALF YEAR, 12 - YEARLY)

        System.out.println(String.format("period: %d period2: %d", period, period2));


        for (int i = 0; i < period; i++) {

            if (month % dividendPeriod == 0) {
                balance = balance + stockCount * dividend;
            }

            newStock = (int) ((int) balance / stockPrice);
            stockCount = stockCount + newStock;
            balance = balance - newStock * stockPrice;


            System.out.format("%02d.%d Stocks: %d Dividend: %.2f$ New Stocks: %d\n",month, year, stockCount, stockCount * dividend, newStock);

            month++;

            if (month > 12) {
                year++;
            }

            if (month > 12) {
                month = 1;
            }

            balance = balance + investments;


            dividendDiff = ((Math.random() - 0.50) / 100.00) + 1;
            stockDiff = ((Math.random() - 0.50) / 100.00) + 1;


            if (diffs) {
                stockPrice = stockPrice * stockDiff;
                dividend = dividend * dividendDiff;
                System.out.print(" Stock Price: ");
                System.out.format("%.2f", stockPrice);
                System.out.print(" Dividend: ");
                System.out.format("%.2f", dividend);

            }


        }


        return String.format("On %02d.%d you'll have %d stocks which will pay you a total of %.2f$ each %d months.\n",month, year, stockCount, stockCount * dividend, dividendPeriod);

    }
}
