import com.my.mangoplatemini.controller.ReviewController;

public class main {
	
	public static void main(String[] args) {
		
		ReviewController rc = new ReviewController();
		
		String userId = "찬돌";
		String businessNo = "1234567890";
		
		rc.createReview(userId, businessNo);
		
		
		// ========================================
		
	} // main
	
} // end class
