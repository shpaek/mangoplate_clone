	package com.my.mangoplatemini.controller;
	import java.util.Scanner;
	
	import com.my.mangoplatemini.dao.MemberDAO;
	import com.my.mangoplatemini.dto.MemberDTO;
	
	public class MemberController {
	
		Scanner scanner = new Scanner(System.in);      
		MemberDAO memberdao = new MemberDAO();
		MemberDTO member = new MemberDTO();
	
	public void login(MemberDTO member) {
	
			while (true) {
				System.out.println("------- 안녕하세요 망고플레이트입니다. -------");
				System.out.println("1. 로그인");
				System.out.println("2. 회원가입");
	
				int input;
				try {
					input = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("잘못된 선택입니다. 1이나 2를 입력해주세요.");
					continue;
				}
	
	
				if (input == 1) {
					System.out.println("아이디를 입력하세요:");
					String loginId = scanner.nextLine();
					System.out.println("비밀번호를 입력하세요:");
					String loginPassword = scanner.nextLine();
	
					member.setId(loginId);
					member.setPassword(loginPassword);
										
					int user_status = memberdao.checkUserStatus(member);
					memberdao.login(member);
					
					 if (user_status == 1) {
		                memberdao.login(member);	                    
		                } else {
		                    System.out.println("회원 상태를 확인할 수 없습니다.");
		                }
		                break;
		                


			} else if (input == 2) {
				while (true) {
					System.out.println("1. 사용자로 가입");
					System.out.println("2. 점주로 가입");

					int user_typeInput;
					try {
						user_typeInput = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("잘못된 입력입니다. 1이나 2를 입력해주세요.");
						continue;
					}

					if (user_typeInput == 1 || user_typeInput == 2) {
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
						String user_type = (user_typeInput == 1) ? "사용자" : "점주";



						MemberDTO memberDTO = new MemberDTO();
						memberDTO.setId(newId);
						memberDTO.setPassword(newPassword);
						memberDTO.setName(newName);
						memberDTO.setEmail(newEmail);
						memberDTO.setTel(newTel);
						memberDTO.setUser_type(user_typeInput);
						memberDTO.setStatus(1);

						MemberDAO dao = new MemberDAO();
						dao.createMember(memberDTO);

						System.out.println("환영합니다. 로그인을 해주세요.");



						break;
					} else {
						System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
					}
				}
			} else {
				System.out.println("잘못된 입력입니다. 1이나 2를 입력해주세요.");
			}
		}
			
	}

}

