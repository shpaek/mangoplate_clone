import com.my.mangoplatemini.controller.ReviewController;
import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dto.ReviewDTO;

public class main {
	
	public static void main(String[] args) {
		
		ReviewController rc = new ReviewController();
		
		String userId = "찬돌";
		String businessNo = "1234567890";
		
		rc.createReview(userId, businessNo);
		
		
		// ========================================
		
//		MemberDTO mdto = new MemberDTO();
//		MemberDAO mdao = new MemberDAO();
//		
//		mdto.setId("찬도리");
//		mdto.setPassword("찬도리1");
//		mdto.setEmail("cc@nn.naver");
//		mdto.setName("찬도리");
//		mdto.setTel("00011112222");
//		mdto.setUser_type(0);
//		mdto.setUser_status(0);
//		
//		mdao.createMember(mdto);
//		
		
	} // main
	
} // end class
