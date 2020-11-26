package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Member;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService extends DatabaseService {
    public Member getMemberFromId(int memberId) {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM member WHERE memberId = :id")
                        .bind("id", memberId)
                        .mapToBean(Member.class)
                        .list()
                        .get(0)
        );
    }

    public List<Member> getAllMembers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM member")
                        .mapToBean(Member.class)
                        .list()
        );
    }

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


