package com.greedy.section01.xmlconfig.dto;
//데이터를 담아 둔다
public class MenuDTO {
   private int code;
   private String name;
   private int price;
   private int categoryCode;
   private String oderableStatus;
   public MenuDTO(int code, String name, int price, int categoryCode, String oderableStatus) {
      super();
      this.code = code;
      this.name = name;
      this.price = price;
      this.categoryCode = categoryCode;
      this.oderableStatus = oderableStatus;
   }
   public MenuDTO() {
      super();
      // TODO Auto-generated constructor stub
   }
   public int getCode() {
      return code;
   }
   public void setCode(int code) {
      this.code = code;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public int getCategoryCode() {
      return categoryCode;
   }
   public void setCategoryCode(int categoryCode) {
      this.categoryCode = categoryCode;
   }
   public String getOderableStatus() {
      return oderableStatus;
   }
   public void setOderableStatus(String oderableStatus) {
      this.oderableStatus = oderableStatus;
   }
   @Override
   public String toString() {
      return "MenuDTO [code=" + code + ", name=" + name + ", price=" + price + ", categoryCode=" + categoryCode
            + ", oderableStatus=" + oderableStatus + "]";
   }
   
   

}