
import com.my.mangoplatemini.controller.ReviewController;

public class main {
	
	public static void main(String[] args) {
		
//		StoreController storeController = new StoreController();
//		
//		storeController.showStoreDetail("1");
		
		// 리뷰
		ReviewController rc = new ReviewController();
		
		String userId = "sh";
		String businessNo = "1234567899";
		
		rc.createReview(userId, businessNo);
		
		
		// ========================================
	} // main
	
} // end class

