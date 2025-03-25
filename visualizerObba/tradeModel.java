
/*
 * @author Saurya Singh
 *
 */

import java.util.Date;

public class tradeModel{
       private String tradeid;
	   private String wkn;
       private String tradedate;
	   private String valutadate;
	   private Double nominal;
	   private Double price;
	   private String insttype;
	   private String company;
	   private String desk;
	   private String book;
	   
      // constructor
      public tradeModel(String tradeid, String wkn, String tradedate, String valutadate, 
						Double nominal,Double price,String insttype, String company, String desk, String book) {
       this.tradeid = tradeid;
       this.wkn = wkn;
	   this.tradedate = tradedate;
	   this.valutadate = valutadate;
	   this.nominal = nominal;
	   this.price = price;
	   this.insttype = insttype;
	   this.company = company;
	   this.desk = desk;
	   this.book = book;	   	   
      }

       // getter
       public String getTradeid() { return this.tradeid; }
	   public String getWkn() { return this.wkn;}
	   public String getTradedate() { return this.tradedate; }
	   public String getValutadate() { return this.valutadate; }
	   public Double getNominal() { return this.nominal; }
	   public Double getPrice() { return this.price; }
	   public String getInsttype() { return this.insttype; }
	   public String getCompany() { return this.company; }
	   public String getDesk() { return this.desk; }
	   public String getBook() { return this.book; }
       
       // setter
       public void setTradeid(String tradeid) { this.tradeid = tradeid; }
      
}

