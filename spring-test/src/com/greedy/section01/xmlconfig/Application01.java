package com.greedy.section01.xmlconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.xmlconfig.controller.MenuController;
import com.greedy.section01.xmlconfig.service.MenuService;

public class Application01 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      ApplicationContext context =
    		  new AnnotationConfigApplicationContext("com.greedy.section01");
      
      MenuController menuController = context.getBean(MenuController.class);
      
      do {
         System.out.println("====== 메뉴 관리 =====");
         System.out.println("1. 메뉴 전체 조회");
         System.out.println("2. 메뉴 코드로 조회");
         System.out.println("3. 신규 메뉴 추가");
         System.out.println("4. 메뉴 수정");
         System.out.println("5. 메뉴 삭제");
         System.out.println("메뉴 관리 번호를 입력해주세요 : ");
         int no = sc.nextInt();
         
         switch (no) {
         case 1: menuController.findAllMenus();
               break;
         case 2: menuController.findMenuByMenuCode(inputMenuCode());
         break;
         
         case 3: menuController.registNewMenu(inputMenu());
         break;
         
         case 4: menuController.modifyMenu(inputModifyMenu());
         break;
         
         case 5: menuController.removeMenu(inputMenuCode());
         break;
         
         default:
            System.out.println("잘못된 메뉴를 선택하였습니다.");
               break;
         }
         
      }while(true);
   }
   
   private static Map<String, String> inputMenuCode(){
      Scanner sc = new Scanner(System.in);
      System.out.println("메뉴 코드 입력 : ");
      String code = sc.nextLine();
      
      Map<String, String> parameter = new HashMap<String, String>();
      parameter.put("code", code);
      
      return parameter;
   }
   private static Map<String, String> inputMenu(){
      Scanner sc = new Scanner(System.in);
      System.out.println("메뉴 이름 입력 : ");
      String name = sc.nextLine();
      
      
      System.out.println("메뉴의 가격을 입력 : ");
      String price = sc.nextLine();
      
      System.out.println("카테고리 코드를 입력 : ");
      String categoryCode = sc.nextLine();
      

      Map<String, String> parameter = new HashMap<>();
      parameter.put("name", name);
      parameter.put("price", price);
      parameter.put("categoryCode", categoryCode);
      
      return parameter;

   }
   
   private static Map<String, String> inputModifyMenu(){
      Scanner sc = new Scanner(System.in);
      System.out.println("수정 할 메뉴 코드 입력 : ");
      String code = sc.nextLine();
      
      System.out.println("수정 할 메뉴 이름 입력 : ");
      String name = sc.nextLine();
      
      System.out.println("수정 할 메뉴의 가격을 입력 : ");
      String price = sc.nextLine();
      
      System.out.println("수정 할 카테고리 코드를 입력 : ");
      String categoryCode = sc.nextLine();
      

      Map<String, String> parameter = new HashMap<>();
      parameter.put("code", code);
      parameter.put("name", name);
      parameter.put("price", price);
      parameter.put("categoryCode", categoryCode);
      
      return parameter;
   }
   
}