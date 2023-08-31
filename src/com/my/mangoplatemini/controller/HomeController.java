package com.my.mangoplatemini.controller;

import java.util.Scanner;

public class HomeController {
    MemberController memberController = new MemberController();

    public void init() {
        String asciiArt =
                "    //    //                                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠶⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "   //___ //      ___       //     //      ___       ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⣀⣤⣶⣶⣿⣷⣶⣶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "  / ___  /     //___) )   //     //     //   ) )   ⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                " //    //     //         //     //     //   / /⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "//    //     ((____     //     //     ((___/ /  ⠀⠀⠀⠀⠀⠀ ⠀⠀⠀  ⣿⣿⣿⣿⣿ ⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                "                                                  ⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                " ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀	⣤⣤⡀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀	⠈⠻⣄⠈⣿⣿⣿ ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀	⠈⠉⣿⣿⣿⣿           ⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                   ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                   ⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠍⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                   ⠈⠛⠿⢿⣿⣿⡿⠿⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                                    ⠐⠿⠗⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n";

        System.out.println(asciiArt);

        Scanner sc = new Scanner(System.in);
        int input;

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ안녕하세요! 망고플레이트입니다!ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");

        while (true) {
            System.out.println("1. 로그인\n");
            System.out.println("2. 회원 가입");

            try {
                input = Integer.parseInt(sc.nextLine());

                if (input == 1) {
                    memberController.login();
                    break;
                } else if (input == 2) {
                    memberController.createMember();
                    break;
                } else {
                    System.out.println("※ 올바른 숫자를 입력해주세요.※\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("※ 숫자를 입력해주세요.※\n");
            }
        }
    }

}
