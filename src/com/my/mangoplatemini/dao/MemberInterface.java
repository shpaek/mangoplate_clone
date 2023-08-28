package com.my.mangoplatemini.dao;

import com.my.mangoplatemini.dto.MemberDTO;

public interface MemberInterface {
	
	// 회원가입 메서드
	public void createMember(MemberDTO memberDTO);
	
	// 회원 조회 메서드
	public void showMember(MemberDTO memberDTO);
	
	// 회원 수정 메서드
	public void updateMember(MemberDTO memberDTO);
	
	// 회원 삭제 메서드
	public void deleteMember(MemberDTO memberDTO);
	
//삽입 : create
//수정 : update
//삭제 : delete
//보여줌 : show
	
} // endclass
