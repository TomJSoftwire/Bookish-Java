package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService extends DatabaseService {
    private MemberService memberService = new MemberService();
    public List<Loan> getAllLoans() {
        List<Loan> allLoans =  jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM loan")
                        .mapToBean(Loan.class)
                        .list()
        );
        return allLoans;
    }

    public void addLoan(Loan loan) {
        jdbi.useHandle(handle -> handle.createUpdate(
                "INSERT INTO loan (loanId, memberId, copyId, loanDate, dueDate,status)" +
                        " VALUES (:loanId, :memberId, :copyId, :loanDate, :dueDate, :status) ")
                .bind("loanId", loan.getLoanId())
                .bind("memberId", loan.getMemberId())
                .bind("copyId", loan.getCopyId())
                .bind("loanDate", loan.getLoanDate())
                .bind("dueDate", loan.getDueDate())
                .bind("status", loan.getStatus())
                .execute()
        );
    }

    public void deleteLoan(int loanId){
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM loan WHERE loanId = :loanId")
                .bind("loanId",loanId)
                .execute()
        );
    }
}
