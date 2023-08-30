package com.my.mangoplatemini.controller;
import java.util.Scanner;

import com.my.mangoplatemini.dao.MemberDAO;
import com.my.mangoplatemini.dto.MemberDTO;

public class MemberController {
	StoreController storeController = StoreController.getInit();
	Scanner scanner = new Scanner(System.in);      
	MemberDAO memberdao = new MemberDAO();

	//로그인
	public void login() {
		while (true) {
			System.out.println("아이디를 입력해주세요.");
			String loginId = scanner.nextLine();

			System.out.println("비밀번호를 입력해주세요.");
			String loginPassword = scanner.nextLine();

			if (loginId.isEmpty() || loginPassword.isEmpty()) {
				System.out.println("※잘못된 입력입니다. 다시 입력해 주세요.※\n");
			} else {
				MemberDTO member = new MemberDTO();
				member.setId(loginId);
				member.setPassword(loginPassword);
				int user_type = memberdao.login(member);
				member.setUser_type(user_type);
				storeController.endlogin(member);
				break;
			}
		}
	} // login

	//회원가입
	public void createMember() {

		int user_typeInput = 0;

		while (true) {
			System.out.println("1. 사용자 가입\n");
			System.out.println("2. 점주 가입");

			try {
				user_typeInput = Integer.parseInt(scanner.nextLine());
				if (user_typeInput == 1 || user_typeInput == 2) {
					break;
				} else {
					System.out.println("※올바른 숫자를 입력해주세요.※\n");
				}
			} catch (NumberFormatException e) {
				System.out.println("※잘못된 입력입니다. 다시 입력해 주세요.※\n");
			}
		}
		System.out.println("아이디를 입력해주세요.");
		String newId = scanner.nextLine();
		System.out.println("비밀번호를 입력해주세요.");
		String newPassword = scanner.nextLine();
		System.out.println("이름을 입력해주세요.");
		String newName = scanner.nextLine();
		System.out.println("이메일을 입력해주세요.");
		String newEmail = scanner.nextLine();
		System.out.println("전화번호를 입력해주세요.");
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
