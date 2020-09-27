package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {


        int month = 8;
        int year = 2020;

        double stockPrice = 48.72;
        double dividend = 0.41;

        double stockDiff;
        double dividendDiff;

        double investments = 180.00;
        double balance = investments;
        int stockCount = 0;
        int newStock;

        boolean diffs = false;


        for(int i = 0; i<504; i++){

            if (month % 3 == 0){
                balance = balance + stockCount * dividend;
            }

            newStock = (int) ((int) balance / stockPrice);
            stockCount = stockCount + newStock;
            balance = balance - newStock * stockPrice;




            System.out.println(String.format("%02d",month) + "." + year + " Stocks: " + String.format("%03d",stockCount) + " Dividend: " + String.format("%.2f",stockCount*dividend) + " New stocks: " + newStock);


            month++;

            if(month>12){
                year++;
            }

            if (month > 12){
                month = 1;
            }

            balance = balance + investments;

            dividendDiff = ((Math.random() - 0.50) / 10.00) + 1;
            stockDiff = ((Math.random() - 0.50) / 10.00) + 1;

            if (diffs){
                stockPrice = stockPrice*stockDiff;
                dividend = dividend*dividendDiff;
                System.out.print(" Stock Price: ");
                System.out.format("%.2f",stockPrice);
                System.out.print(" Dividend: ");
                System.out.format("%.2f",dividend);

            }


        }

    }
}
