package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;


@RestController
public class CaculateController {
    Scanner scanner = new Scanner(System.in);

    @GetMapping("/add")
    public int add(){
        System.out.println("첫번째 숫자(정수) 입력");
        int num = scanner.nextInt();

        System.out.println("두번째 숫자(정수) 입력");
        int num2 = scanner.nextInt();

        return num+num2 ;


    }


}
