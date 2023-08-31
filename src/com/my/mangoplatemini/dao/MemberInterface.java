package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.MemberDTO;

public interface MemberInterface {
	
	// 회원가입 메서드
	
	Integer login(MemberDTO member);
	
	void createMember(MemberDTO member);
    // 회원 가입
	
	void deleteMember(String id);
	// 회원 삭제
}
//삽입 : create
//수정 : update
//삭제 : delete
	
	
//보여줌 : show
//
