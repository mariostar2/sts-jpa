package com.example.jpa00.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "member")
public class MemberEntity {
    //db를 만들려면 @id 컬럼과
    @Id
    private String memberId;
    @Column(length =  8,nullable = false)
    private String pw;
    private String name;

    public MemberEntity(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
