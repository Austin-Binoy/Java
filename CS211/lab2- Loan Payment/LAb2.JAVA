
public class Loan {
    public static int monthlyPay(double loanAmount, double annualInterest, double monthlyPay) {
        return MonthsToPayOffRecursive(loanAmount, annualInterest, monthlyPay, 0);
    }

    private static int MonthsToPayOffRecursive(double remainingLoan, double annualInterest, double monthlyPay,
            int monthsPassed) {
        double monthlyInterestRate = annualInterest / 12 / 100; // percentage
        double LoanAfterPayment = remainingLoan * (1 + monthlyInterestRate) - monthlyPay;

        if (LoanAfterPayment <= 0) {
            return monthsPassed + 1;
        } else {
            return MonthsToPayOffRecursive(LoanAfterPayment, annualInterest, monthlyPay,
                    monthsPassed + 1);
        }
    }

    public static void main(String[] args) {
        double loanAmount = 250000;
        double annualInterest = 3;
        double monthlyPay = 1600;

        int yearsNeeded = monthlyPay(loanAmount, annualInterest, monthlyPay) / 12;
        System.out.println("The loan will take  " + yearsNeeded + " years .");
    }
}
