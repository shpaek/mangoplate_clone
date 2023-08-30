package com.my.mangoplatemini.controller;

import java.util.Scanner;

public class HomeController {
	MemberController memberController = new MemberController();
	
	public void init() {
		Scanner sc = new Scanner(System.in);
		int input = 0;

		System.out.println("------- 안녕하세요 망고플레이트입니다. -------");
		System.out.println("1. 로그인\n");
		System.out.println("2. 회원가입");

		try {
			input = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("※올바른 숫자를 입력해주세요.※");
		}

		if (input == 1) {
			memberController.login();
		} else if (input == 2) {
			memberController.createMember();
		}
	}

}
