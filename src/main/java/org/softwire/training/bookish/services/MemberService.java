package org.softwire.training.bookish.services;

import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.softwire.training.bookish.models.database.Loan;
import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MemberService extends DatabaseService {

    public List<Member> getAllMembers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT loan.loanId loanId, "
                        + "member.memberId memberId, memberName memberName "
                        + "FROM member LEFT JOIN loan ON member.memberId = loan.memberId ")
                        //+ "WHERE member.memberId")
                        .registerRowMapper(BeanMapper.factory(Member.class))
                        .registerRowMapper((BeanMapper.factory(Loan.class)))
                        .reduceRows(new LinkedHashMap<Integer, Member>(), (map, rowView) -> {
                            Member member = map.computeIfAbsent(
                                    rowView.getColumn("memberId", Integer.class),
                                    id -> rowView.getRow(Member.class));
                            if (rowView.getColumn("loanId", Integer.class) != null) {
                                member.addLoan(rowView.getRow(Loan.class));
                            }

                            return map;
                        }))
                .values()
                .stream()
                .collect(toList());

    }

    public Member getMemberFromId(int memberId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM member WHERE memberId = :id")
                        .bind("id", memberId)
                        .mapToBean(Member.class)
                        .list()
                        .get(0)
        );
    }
/**
    public List<Member> getAllMembers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM member")
                        .mapToBean(Member.class)
                        .list()
        );
    }**/

    public void addMember(Member member) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO member (name,id) VALUES (:name,:id)")
                        .bind("name", member.getMemberName())
                        .bind("id", member.getMemberId())
                        .execute()

        );
    }

    public void deleteMember(int memberId) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM member WHERE id = :id")
                .bind("id",memberId)
                .execute()
                );
    }
}


