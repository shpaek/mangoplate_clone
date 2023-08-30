package com.my.mangoplatemini.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.my.mangoplatemini.dao.MemberDAO;
import com.my.mangoplatemini.dto.MemberDTO;

public class MemberController {
	StoreController storeController = StoreController.getInit();
	
	Scanner scanner = new Scanner(System.in);      
	MemberDAO memberdao = new MemberDAO();

	MemberDTO member = new MemberDTO();

	public void login() {

		System.out.println("아이디를 입력하세요:");
		String loginId = scanner.nextLine();
		System.out.println("비밀번호를 입력하세요:");
		String loginPassword = scanner.nextLine();

		MemberDTO member = new MemberDTO();
		member.setId(loginId);
		member.setPassword(loginPassword);
		int user_type = memberdao.login(member);
		member.setUser_type(user_type);
		
		try {
			try {
				storeController.endlogin(member);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // login

	public void createMember() {

		System.out.println("1. 사용자로 가입");
		System.out.println("2. 점주로 가입");

		int user_typeInput = 0;
		try {
			user_typeInput = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("잘못된 입력입니다. 1이나 2를 입력해주세요.");
		} //try-catch

		System.out.println("아이디를 입력해주세요:");
		String newId = scanner.nextLine();
		System.out.println("비밀번호를 입력해주세요:");
		String newPassword = scanner.nextLine();
		System.out.println("이름을 입력해주세요:");
		String newName = scanner.nextLine();
		System.out.println("이메일을 입력해주세요:");
		String newEmail = scanner.nextLine();
		System.out.println("전화번호를 입력해주세요:");
		String newTel = scanner.nextLine();
		Integer user_type = user_typeInput;

		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(newId);
		memberDTO.setPassword(newPassword);
		memberDTO.setName(newName);
		memberDTO.setEmail(newEmail);
		memberDTO.setTel(newTel);
		memberDTO.setUser_type(user_type);
		memberDTO.setStatus(1);

		MemberDAO dao = new MemberDAO();
		dao.createMember(memberDTO);

		login();
	
	} // createMember
	
	public void updateMember(MemberDTO memberDTO) {
	    while (true) {
	        System.out.println("수정할 사항을 입력해주세요.");
	        System.out.println("1.비밀번호, 2.이메일, 3.이름, 4.전화번호");
	        Integer input = Integer.parseInt(scanner.nextLine());

	        if (input == 1) {
	            System.out.println("수정할 비밀번호를 입력하세요");
	            String password = scanner.nextLine();
	            memberDTO.setPassword(password);
	            break;
	        } else if (input == 2) {
	            System.out.println("수정할 이메일을 입력하세요");
	            String email = scanner.nextLine();
	            memberDTO.setEmail(email);
	            break;
	        } else if (input == 3) {
	            System.out.println("수정할 이름을 입력하세요");
	            String name = scanner.nextLine();
	            memberDTO.setName(name);
	            break;
	        } else if (input == 4) {
	            System.out.println("수정할 전화번호를 입력하세요");
	            String tel = scanner.nextLine();
	            memberDTO.setTel(tel);
	            break;
	        } else {
	            System.out.println("잘못입력하셨습니다. 다시입력해주세요");
	        }
	    }
	    MemberDAO memberDAO = new MemberDAO();
	    memberDAO.updateMember(memberDTO);
	    System.out.println("수정되었습니다.");
	} // updateMember
	
	public void deleteMember(MemberDTO memberDTO) throws SQLException {
	    System.out.println("정말 탈퇴하시겠습니까? 탈퇴하시려면 숫자를 입력해주세요 (0 : 취소) ");
	    int no = Integer.parseInt(scanner.nextLine());
	    
	    if (no != 0) {  
	        MemberDAO memberDAO = new MemberDAO();
			memberDAO.deleteMember(memberDTO.getId());
			System.out.println("회원 비활성화 완료.");
	    } else {
	        System.out.println("탈퇴를 취소합니다.");
	    }
	}

	} // end class





