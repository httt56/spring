package com.greedy.section01.xmlconfig.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greedy.section01.xmlconfig.dto.MenuDTO;

@Repository("PrintResult")
public class PrintResult {
   

   public void printMenuList(List<MenuDTO> menuList) {
      for(MenuDTO menu : menuList) {
         System.out.println(menu);
      }
   }

   public void printErrorMessage(String string) {
      if(string.contentEquals("findAllMenus")) {
         System.out.println("�޴� ��ȸ�� �����Ͽ����ϴ�...");
      } else if(string.contentEquals("findMenuByMenuCode")) {
         System.out.println("�ش� �ڵ�� �����ϴ� �޴��� �����ϴ�...");
      } else if(string.contentEquals("registNewMenu")) {
         System.out.println("�޴� ��Ͽ� �����Ͽ����ϴ�...");
      }else if(string.equals("modifyMenu")) {
    	  System.out.println("�޴������� ����");
      }
   }

   public void printMenuList(MenuDTO menu) {
      System.out.println(menu);  //tostring �ڵ����� ����...
   }

   public void printSuccessMessage(String string) {
      switch(string) {
         case "registNewMenu" :
            System.out.println("��Ͽ� �����Ͽ����ϴ�...");
            break;
         case "modifyMenu" :
        	 System.out.println("��Ͽ� ����");
         
         default:
            break;
      }
   }

}