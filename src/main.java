import com.my.mangoplatemini.dao.ReviewDAO;
import com.my.mangoplatemini.dto.ReviewDTO;

public class main {
	
	public static void main(String[] args) {
		
		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		
		dto.setBusiness_no("1234567890");
		dto.setUser_id("찬돌");
		dto.setContent("맛조타~");
		dto.setRating(4);
		
		dao.createReview(dto);
		
	} // main
	
} // end class
