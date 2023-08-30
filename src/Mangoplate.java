
import java.util.Scanner;

import com.my.mangoplatemini.controller.HomeController;
import com.my.mangoplatemini.controller.MemberController;
import com.my.mangoplatemini.dto.MemberDTO;

import com.my.mangoplatemini.controller.ReviewController;
import com.my.mangoplatemini.controller.StoreController;

public class Mangoplate {
	
	public static void main(String[] args) {
		HomeController homeController = new HomeController();
		homeController.init();
	} // main
	
} // end class

