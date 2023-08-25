import com.my.mangoplatemini.controller.StoreController;

public class main {
	public static void main(String[] args) {
		StoreController storeController = new StoreController();

//		System.out.println("------------환영합니다! 안내된 번호를 선택해주세요------------");
//		System.out.println("1. 회원가입      2. 로그인");
//		storeController.crateMenu();
		storeController.showMenu("1");
//		storeController.updateMenu();
//		storeController.deleteMenu();
	    }
}
