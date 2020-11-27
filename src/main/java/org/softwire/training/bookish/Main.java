package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Member;
import org.softwire.training.bookish.services.LoanService;
import org.softwire.training.bookish.services.MemberService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost:3306";
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASS");
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";


        jdbiMethod(connectionString);
        MemberService memberService = new MemberService();
        List<Member> allMembers = memberService.getAllMembers();
        System.out.println(allMembers.get(0).getMemberLoans());
    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // TODO: print out the details of all the books (using JDBI)
        // See this page for details: http://jdbi.org
        // Use the "Book" class that we've created for you (in the models.database folder)

        Jdbi jdbi = Jdbi.create(connectionString);
        List<String> test = jdbi.withHandle(handle -> {
                return handle.createQuery("SELECT title FROM library.book")
                        .mapTo(String.class)
                        .list();
        });
        System.out.println(test);


    }
}
