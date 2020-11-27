package org.softwire.training.bookish.models.page;

import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.services.MemberService;

import java.util.List;

public class LoanPageModel {
    private List<Loan> loans;

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
}
