package com.greedy.section01.xmlconfig.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.greedy.section01.xmlconfig.common.PrintResult;
import com.greedy.section01.xmlconfig.dto.MenuDTO;
import com.greedy.section01.xmlconfig.dto.ModifyMenuDTO;
import com.greedy.section01.xmlconfig.service.MenuService;

/* <��Ʈ�ѷ� ����>
 * ������� ��û�� �����ϴ� ������ �����Ѵ�.
 * ����� �Է� ���� ��ȿ���� üũ�Ѵ�.*/
@Controller
public class MenuController {

	private final MenuService menuService;
	private final PrintResult printResult;
	
	@Autowired
	public MenuController() {
		this.menuService = new MenuService();
		this.printResult = new PrintResult();
	}

	public void findAllMenus() {
		List<MenuDTO> menuList = menuService.findAllMenus();

		if (menuList != null) {
			printResult.printMenuList(menuList);
		} else {
			printResult.printErrorMessage("findAllMenus");
		}
	}

	public void findMenuByMenuCode(Map<String, String> inputMenuCode) {
		int code = Integer.parseInt(inputMenuCode.get("code"));

		MenuDTO menu = menuService.findMenuByMenuCode(code);

		if (menu == null) {
			printResult.printErrorMessage("findMenuByMenuCode");
		} else {
			printResult.printMenuList(menu);
		}
	}

	public void registNewMenu(Map<String, String> inputMenu) {
		/* �� �������°���..? */
		String name = inputMenu.get("name");
		int price = Integer.parseInt(inputMenu.get("price"));
		int categoryCode = Integer.parseInt(inputMenu.get("categoryCode"));

		/* �޴���� �ν��Ͻ� ���� �� ���� �־���... */
		MenuDTO menu = new MenuDTO();
		menu.setName(name);
		menu.setPrice(price);
		menu.setCategoryCode(categoryCode);

		if (menuService.registNewMenu(menu)) {
			printResult.printSuccessMessage("registNewMenu");
		} else {
			printResult.printErrorMessage("registNewMenu");
		}
	}

	public void modifyMenu(Map<String, String> inputModifyMenu) {

		ModifyMenuDTO menuDTO = new ModifyMenuDTO();

		menuDTO.setCode(inputModifyMenu.get("code"));
		menuDTO.setName(inputModifyMenu.get("name"));
		menuDTO.setPrice(inputModifyMenu.get("price"));
		menuDTO.setCategoryCode(inputModifyMenu.get("categoryCode"));

		int result = menuService.modifyMenu(menuDTO);

	}

	public void removeMenu(Map<String, String> inputMenuCode) {
		
		int code = Integer.parseInt(inputMenuCode.get("code"));
		
		int result = menuService.removeMenu(code);
		
		if(result > 0 ) {
			printResult.printErrorMessage("removeMenu");
		}else {
			printResult.printErrorMessage("notremove");
		
		
	}
		
	}

}