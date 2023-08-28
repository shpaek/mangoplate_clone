import com.my.mangoplatemini.dao.MemberDAO;
import com.my.mangoplatemini.dto.MemberDTO;

public class main {
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("1");
		memberDTO.setPassword("1123");
		memberDTO.setEmail("1123");
		memberDTO.setName("1123");
		memberDTO.setTel("1123");
		memberDAO.updateMember(memberDTO);
		}
}