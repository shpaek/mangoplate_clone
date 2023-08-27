package com.my.mangoplatemini.controller;

import java.util.ArrayList;
import java.util.Scanner;

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

public class MemberController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Member> members = new ArrayList<>();

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

                boolean logIn = false;
                for (Member member : members) {
                    if (member.id.equals(loginId) && member.password.equals(loginPassword)) {
                        logIn = true;
                        System.out.println("로그인에 성공했습니다. 환영합니다!");
                        break;
                    }
                }

                if (!logIn) {
                    System.out.println("로그인에 실패했습니다. 아이디 또는 비밀번호를 확인하세요.");
                }
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

                  
                    Member newMember = new Member(newId, newPassword, newName, newEmail, newTel, user_type);
                    members.add(newMember);

                    
                    System.out.println("환영합니다 " + (user_type.equals("사용자") ? "사용자님" : "점주님") + "! 로그인을 해주세요.");
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
