package com.my.mangoplatemini.controller;

import java.util.ArrayList;
import java.util.Scanner;

class Member {
    String id;
    String password;
    private String name;
    private String email;
    private String tel;

    public Member(String id, String password, String name, String email, String tel) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.tel = tel;
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

            int input = Integer.parseInt(scanner.nextLine());

            if (input == 1) {
                boolean logIn = false;
                while (!logIn) {
                    System.out.println("아이디를 입력하세요:");
                    String loginId = scanner.nextLine();
                    System.out.println("비밀번호를 입력하세요:");
                    String loginPassword = scanner.nextLine();

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
                }
             
                break;
            } else if (input == 2) {
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

                // 새 회원 생성 및 목록에 추가
                Member newMember = new Member(newId, newPassword, newName, newEmail, newTel);
                members.add(newMember);

                System.out.println("회원가입이 완료되었습니다. 로그인해주세요.");
            } else {
                System.out.println("잘못된 선택입니다. 1이나 2를 입력해주세요.");
            }
        }
// db 랑 연동되게, 로그인시 디비 연동된거 뽑아와야하고, 회원가입하면 디비에 정보 누적되어야함
// 로그인에 성공했을 때, 사용자의 경우 리뷰쓰기페이지가, 점주의 경우 상점등록수정등이 나오도록 클래스연결        
    
    }
}