package com.my.mangoplatemini.controller;
import java.util.Scanner;

import com.my.mangoplatemini.dao.MemberDAO;
import com.my.mangoplatemini.dto.MemberDTO;

public class MemberController {

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
		memberdao.login(member);
		StoreController storeController = new StoreController();
		storeController.endlogin(member);

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

} // end class
