package org.softwire.training.bookish.models.database;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private int memberId;
    private String memberName;
    private List<Loan> memberLoans = new ArrayList<>();


    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public void addLoan(Loan loan){
        memberLoans.add(loan);
    }

    public List<Loan> getMemberLoans() {
        return memberLoans;
    }
}
