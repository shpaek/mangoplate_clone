import java.util.ArrayList;
import java.util.Scanner;

class Member {
    String id;
    String password;
    // ... (다른 멤버 변수들)
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Member> members = new ArrayList<>();

        while (true) {
            System.out.println("------- 안녕하세요 망고플레이트입니다. -------");
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");
            int input = scanner.nextInt();
            scanner.nextLine();

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
                            break; // 
                        }
                    }
                    if (!logIn) {
                        System.out.println("로그인에 실패했습니다. 아이디 또는 비밀번호를 확인하세요.");
                      
                    }
                }
            } else if (input == 2) {
            	System.out.println("아이디를 입력해주세요");
                String newId = scanner.nextLine();
                //db연결로 member m=<--"SELECT id, pw FROM member WHERE id="+newId;
                //members.indexOf(m) <-- 중복됐을때메세지 출력하기위함
                
                System.out.println("비밀번호를 입력해주세요");
                
                
                // 회원가입 기능 구현해야함..
            } else {
                System.out.println("잘못된 선택입니다. 1이나 2를 입력해주세요.");
            }
        }
    }
}