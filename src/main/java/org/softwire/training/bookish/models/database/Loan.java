package org.softwire.training.bookish.models.database;

import org.softwire.training.bookish.models.LoanStatus;

import java.util.Date;

public class Loan {
    private int loanId;
    private int memberId;
    private Member member;
    private int copyId;
    private Date loanDate;
    private Date dueDate;
    private String status;

    public int getLoanId() {
        return loanId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getCopyId() {
        return copyId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }
}
