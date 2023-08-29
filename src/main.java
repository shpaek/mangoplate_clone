import java.util.Scanner;

import com.my.mangoplatemini.controller.MemberController;
import com.my.mangoplatemini.dto.MemberDTO;

public class main {
	
	public static void main(String[] args) {
		
//		StoreController storeController = new StoreController();
//		
//		storeController.showStoreDetail("1");
		
		// 리뷰
//		ReviewController rc = new ReviewController();
//		
//		String userId = "찬돌";
//		String businessNo = "1234567890";
//		
//		rc.createReview(userId, businessNo);
		

		MemberDTO mdto = new MemberDTO();
		MemberController memberController = new MemberController();
		
		Scanner sc = new Scanner(System.in);
		int input = 0;
	
		System.out.println("------- 안녕하세요 망고플레이트입니다. -------");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		
		try {
			input = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("잘못된 선택입니다. 1이나 2를 입력해주세요.");
		}
		
		if(input == 1) {
			memberController.login();			
		} else if (input == 2) {
			memberController.createMember();
		}
		
		// ========================================
	} // main
	
} // end class

