package com.my.mangoplatemini.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.my.mangoplatemini.dao.MemberDAO;
import com.my.mangoplatemini.dto.MemberDTO;

class Member {
    String id;
    String password;
    private String name;
    private String email;
    private String tel;
    private String user_type;

    public Member(String id, String password, String name, String email, String tel, String user_type) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.user_type = user_type;
    }
}

//처음 회원가입시 사용자(1), 점주(2) 인지, 값을 입력하고 입력한 값을 DB에 저장함
//
//저장 후에 ID PW name email tel을 입력하는 회원가입, 이 5가지의 값도 DB에 저장
//
//ex) 2(점주) -> id pw name ... 가입
//
//5개의 정보를 기입하고 회원가입하는 순간 모든 회원에게 user status 값 1 (활성) 할당
//
//(유저 삭제시 deletemember가 아니라, user_status 가 1->0으로 update되는 코드)


public class MemberController {
	
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);        
        MemberDAO memberdao = new MemberDAO();
//        ArrayList<Member> members = new ArrayList<>();

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
                
                MemberDTO member = new MemberDTO();
                member.setId(loginId);
                member.setPassword(loginPassword);
                memberdao.login(member);
              
                
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





