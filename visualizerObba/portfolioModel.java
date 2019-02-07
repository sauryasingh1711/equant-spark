

/*
 * @author NeerajSingh
 *
 */


public class portfolioModel{
       private String portfolioid;
       private String wkn;
       private Double nominal;
	   private Double price;
	   private String insttype;
	   private String company;
	   private String desk;
	   private String book;
	
      
	  // constructor
      public  portfolioModel(String portfolioid, String wkn, Double nominal,Double price, 
							String insttype, String company, String desk, String book) {
       this.portfolioid = portfolioid;
       this.wkn = wkn;
	   this.nominal = nominal;
	   this.price = price;
	   this.insttype = insttype;
	   this.company = company;
	   this.desk = desk;
	   this.book = book;	   	   
      }

       // getter
       public String getPortfolioid() { return this.portfolioid; }
       public String getWkn() { return this.wkn;}
	   public Double getNominal() { return this.nominal; }
	   public Double getPrice() { return this.price; }
	   public String getInsttype() { return this.insttype; }
	   public String getCompany() { return this.company; }
	   public String getDesk() { return this.desk; }
	   public String getBook() { return this.book; }
   
       // setter
       public void setPortfolioid(String portfolioid) { this.portfolioid = portfolioid; }
      

}
