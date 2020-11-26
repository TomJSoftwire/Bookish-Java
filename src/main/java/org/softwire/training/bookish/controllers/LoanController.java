package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.models.page.LoanPageModel;
import org.softwire.training.bookish.services.LoanService;
import org.softwire.training.bookish.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;
    private final MemberService memberService;

    @Autowired
    public LoanController(LoanService loanService, MemberService memberService) {
        this.loanService = loanService;
        this.memberService = memberService;
    }

    @RequestMapping("")
    ModelAndView loans() {

        List<Loan> allLoans = loanService.getAllLoans();
        allLoans.stream().forEach(i -> i.setMember(memberService.getMemberFromId(i.getMemberId())));

        LoanPageModel loanPageModel = new LoanPageModel();

        loanPageModel.setLoans(allLoans);
        loanPageModel.setMemberService(memberService);

        return new ModelAndView("loans", "model", loanPageModel);
    }
/**
    @RequestMapping("/add-technology")
    RedirectView addTechnology(@ModelAttribute Loan loan) {

        loanService.addLoan(loan);

        return new RedirectView("/loans");
    }

    @RequestMapping("/delete-technology")
    RedirectView deleteTechnology(@RequestParam int loanId) {

        loanService.deleteLoan(loanId);

        return new RedirectView("/loans");
    }
    **/
}
