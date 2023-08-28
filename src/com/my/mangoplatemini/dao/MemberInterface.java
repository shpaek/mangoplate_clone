package com.my.mangoplatemini.dao;

<<<<<<< HEAD
=======

>>>>>>> b96df20a8aa98539dd13807f60ab30238e5f6fe7
import com.my.mangoplatemini.dto.MemberDTO;

public interface MemberInterface {
	
	// 회원가입 메서드
<<<<<<< HEAD
	
	void login(MemberDTO memberDTO);
	
	void createMember(MemberDTO member);
    // 회원 가입
	    
	void updateMember(MemberDTO member);
    // 회원 정보 수정		    
	
	void deleteMember(MemberDTO member);
	// 회원 삭제
}
=======
	public void createMember(MemberDTO memberDTO);
	
	// 회원 조회 메서드
	public void showMember(MemberDTO memberDTO);
	
	// 회원 수정 메서드
	public void updateMember(MemberDTO memberDTO);
	
	// 회원 삭제 메서드
	public void deleteMember(MemberDTO memberDTO);

>>>>>>> b96df20a8aa98539dd13807f60ab30238e5f6fe7
//삽입 : create
//수정 : update
//삭제 : delete
	
	
//보여줌 : show
//
<<<<<<< HEAD
=======
} // endclass
>>>>>>> b96df20a8aa98539dd13807f60ab30238e5f6fe7
