

/*
 * @author NeerajSingh
 *
 */


public class portfolio{

	public static int portfolioFlag=0;
	public static portfolioModel[] portfolio = new portfolioModel[20];	
	public static String[] a_portfolioid = new String[20];
	public static String[] a_wkn = new String[20];
    public static Double[] a_nominal = new Double[20];
	public static Double[] a_price = new Double[20];
	public static String[] a_insttype = new String[20];
	public static String[] a_company = new String[20];
	public static String[] a_desk = new String[20];
	public static String[] a_book = new String[20];
	
	
	
	public static portfolioModel[] portfolioTotal = new portfolioModel[20];
	
	public static String[] d_portfolioid = new String[20];
	public static String[] d_wkn = new String[20];
    public static Double[] d_nominal = new Double[20];
	public static Double[] d_price = new Double[20];
	public static String[] d_insttype = new String[20];
	public static String[] d_company = new String[20];
	public static String[] d_desk = new String[20];
	public static String[] d_book = new String[20];
	
	public static String[] d1_portfolioid = new String[7];
	public static String[] d1_wkn = new String[7];
    public static Double[] d1_nominal = new Double[7];
	public static Double[] d1_price = new Double[7];
	public static String[] d1_insttype = new String[7];
	public static String[] d1_company = new String[7];
	public static String[] d1_desk = new String[7];
	public static String[] d1_book = new String[7];
	
	public static String[] d2_portfolioid = new String[13];
	public static String[] d2_wkn = new String[13];
    public static Double[] d2_nominal = new Double[13];
	public static Double[] d2_price = new Double[13];
	public static String[] d2_insttype = new String[13];
	public static String[] d2_company = new String[13];
	public static String[] d2_desk = new String[13];
	public static String[] d2_book = new String[13];
	
	
	
	//public void portfolioModel(String portfolioid, String wkn, Double nominal,Double price, 
		//					String insttype, String company, String desk, String book) 
    
		
	public static void loadPortfolio() {	
		portfolioFlag=0;		
		
		portfolio[0] = new portfolioModel("PFID_150","113740", 900000000d, 99.983, "schatz", "bm_bund","eigenbestand","bestand_fa" );
		
		portfolio[1] = new portfolioModel("PFID_151","113740",2600000000d, 99.983, "schatz", "bm_bund","emissionen",  "tender_aufst" );
		portfolio[2] = new portfolioModel("PFID_152","113740",2900000000d, 99.983, "schatz", "bm_bund","emissionen",  "tender_aufst" );
		portfolio[3] = new portfolioModel("PFID_153","113549",1900000000d, 100.657,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		portfolio[4] = new portfolioModel("PFID_154","114164",2900000000d, 100.534,"bobl",   "bm_bund","eigenbestand","bestand_fa" );
		portfolio[5] = new portfolioModel("PFID_155","113740",3900000000d, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );
		portfolio[6] = new portfolioModel("PFID_156","113549",1900000000d, 100.657,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		portfolio[7] = new portfolioModel("PFID_157","114164", 900000000d, 100.534,"bobl",   "bm_bund","eigenbestand","bestand_fa" );
		portfolio[8] = new portfolioModel("PFID_158","113740",2900000000d, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );
		portfolio[9] = new portfolioModel("PFID_159","113740",1900000000d, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );			
		portfolio[10] = new portfolioModel("PFID_160","113740",1900000000d, 99.983, "schatz", "ref_bund","eigenbestand","bestand_fa" );
		portfolio[11] = new portfolioModel("PFID_161","113740",3600000000d, 99.983, "schatz", "ref_bund","emissionen",  "tender_aufst" );
		portfolio[12] = new portfolioModel("PFID_162","113740",3900000000d, 99.983, "schatz", "ref_bund","emissionen",  "tender_aufst" );
		portfolio[13] = new portfolioModel("PFID_163","113549",2900000000d, 100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
		portfolio[14] = new portfolioModel("PFID_164","114164",3900000000d, 100.534,"bobl",   "ref_bund","eigenbestand","bestand_fa" );
		portfolio[15] = new portfolioModel("PFID_165","113740",4900000000d, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );
		portfolio[16] = new portfolioModel("PFID_166","113549",2900000000d, 100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
		portfolio[17] = new portfolioModel("PFID_167","114164",1900000000d, 100.534,"bobl",   "ref_bund","eigenbestand","bestand_fa" );
		portfolio[18] = new portfolioModel("PFID_168","113740",3900000000d, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );
		portfolio[19] = new portfolioModel("PFID_169","113740",2900000000d, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );	
			
		portfolioFlag=1;
		
		for (int i=0; i<portfolio.length; i++ ) {		
			a_portfolioid[i] = portfolio[i].getPortfolioid();				
			a_wkn[i] = portfolio[i].getWkn();			
			a_nominal[i] = portfolio[i].getNominal();
			a_price[i] = portfolio[i].getPrice();
			a_insttype[i] = portfolio[i].getInsttype();
			a_company[i] = portfolio[i].getCompany();
			a_desk[i] = portfolio[i].getDesk();
			a_book[i] = portfolio[i].getBook();			
		} 
		
	} //loadRefTrades


	
	public static void loadFltPort(){
	{					
			portfolioTotal[0] = new portfolioModel("PFID_50","113740", 35900000000.0, 3589389700000.0, "schatz", "bm_bund+ref_bund","eigenbestand+emissionen","bestand_fa+tender_aufst" );			
			portfolioTotal[1]= new portfolioModel("TD_150","113740",  900000000.0, 99.983, "schatz", "bm_bund","eigenbestand","bestand_fa" );
			portfolioTotal[2]= new portfolioModel("TD_151","113740", 2600000000.0, 99.983, "schatz", "bm_bund","emissionen",  "tender_aufst" );
			portfolioTotal[3]= new portfolioModel("TD_152","113740", 2900000000.0, 99.983, "schatz", "bm_bund","emissionen",  "tender_aufst" );
			portfolioTotal[4]= new portfolioModel("TD_155","113740", 3900000000.0, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );		
			portfolioTotal[5]= new portfolioModel("TD_158","113740", 2900000000.0, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );
			portfolioTotal[6]= new portfolioModel("TD_159","113740", 1900000000.0, 99.954, "schatz", "bm_bund","eigenbestand","bestand_fa" );			
			portfolioTotal[7]= new portfolioModel("TD_160","113740",1900000000.0, 99.983, "schatz", "ref_bund","eigenbestand","bestand_fa" );
			portfolioTotal[8]= new portfolioModel("TD_161","113740",3600000000.0, 99.983, "schatz", "ref_bund","emissionen",  "tender_aufst" );
			portfolioTotal[9]= new portfolioModel("TD_162","113740",3900000000.0, 99.983, "schatz", "ref_bund","emissionen",  "tender_aufst" );
			portfolioTotal[10]= new portfolioModel("TD_165","113740",4900000000.0, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );
			portfolioTotal[11]= new portfolioModel("TD_168","113740",3900000000.0, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );
			portfolioTotal[12]= new portfolioModel("TD_169","113740",2900000000.0, 99.954, "schatz", "ref_bund","eigenbestand","bestand_fa" );	
			
			portfolioTotal[13]= new portfolioModel("PFID_71","113549",6700000000.0,1337789000000.0, "bund10", "bm_bund+ref_bund","eigenbestand","bestand_fa");
			portfolioTotal[14]= new portfolioModel("TD57_153","113549", 1900000000.0, 100.657,"bund10", "bm_bund","eigenbestand","bestand_fa" );	
			portfolioTotal[15]= new portfolioModel("TD_163","113549",2900000000.0, 100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
			portfolioTotal[16]= new portfolioModel("TD_166","113549",2900000000.0, 100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
			
			portfolioTotal[17]= new portfolioModel("PFID_82","114164",6700000000.0,673577800000.0, "bobl","bm_bund+ref_bund","eigenbestand","bestand_fa");
			portfolioTotal[18]= new portfolioModel("TD_157","114164",  900000000.0, 100.534,"bobl", "bm_bund","eigenbestand","bestand_fa" );
			portfolioTotal[19]= new portfolioModel("TD_164","114164",3900000000.0, 100.534,"bobl", "ref_bund","eigenbestand","bestand_fa" );
			//portfolioTotal[20]= new portfolioModel("TD_167","114164",1900000000.0, 100.534,"bobl",   "ref_bund","eigenbestand","bestand_fa" );
			
		} 
		return;
	}
	
	
	public static void accessPortfolio() {		
	
		if (portfolioFlag==0) loadPortfolio();				
		loadFltPort();
		
		for (int i=0; i<portfolioTotal.length; i++ ) {		
			d_portfolioid[i] = portfolioTotal[i].getPortfolioid();				
			d_wkn[i] = portfolioTotal[i].getWkn();			
			d_nominal[i] = portfolioTotal[i].getNominal();
			d_price[i] = portfolioTotal[i].getPrice();
			d_insttype[i] = portfolioTotal[i].getInsttype();
			d_company[i] = portfolioTotal[i].getCompany();
			d_desk[i] = portfolioTotal[i].getDesk();
			d_book[i] = portfolioTotal[i].getBook();			
		} 
				
		accessPortfolio_d1();
		accessPortfolio_d2();
		return;
	} // - done accessPortfolio --
	
	
	// portfolio_d1//
	public static void accessPortfolio_d1() {		
		loadFltPort();		
		for (int i=0, j=0; j<7; j++) {
			i=j+13;			 
			d1_portfolioid[j] = portfolioTotal[i].getPortfolioid();							
			d1_wkn[j] = portfolioTotal[i].getWkn();			
			d1_nominal[j] = portfolioTotal[i].getNominal();
			d1_price[j] = portfolioTotal[i].getPrice();
			d1_insttype[j] = portfolioTotal[i].getInsttype();
			d1_company[j] = portfolioTotal[i].getCompany();
			d1_desk[j] = portfolioTotal[i].getDesk();
			d1_book[j] = portfolioTotal[i].getBook();									
		}
		return;
	} // portfolio_d1//
	
	
	// portfolio_d2//
	public static void accessPortfolio_d2() {		
		loadFltPort();
		for (int i=0, j=0; j<13; i++, j++ ) {		
			d2_portfolioid[j] = portfolioTotal[i].getPortfolioid();				
			d2_wkn[j] = portfolioTotal[i].getWkn();			
			d2_nominal[j] = portfolioTotal[i].getNominal();
			d2_price[j] = portfolioTotal[i].getPrice();
			d2_insttype[j] = portfolioTotal[i].getInsttype();
			d2_company[j] = portfolioTotal[i].getCompany();
			d2_desk[j] = portfolioTotal[i].getDesk();
			d2_book[j] = portfolioTotal[i].getBook();			
		}
		return;
	}	// portfolio_d2//
	
	
	public static void main_off(String[] args) {
		
		//loadPortfolio();
		
		//accessPortfolio();	
				
		accessPortfolio_d1();
		for (int i=0; i<7; i++)
			System.out.println(d1_portfolioid[i]);
		
		accessPortfolio_d2();
		for (int i=0; i<13; i++)
			System.out.println(d2_portfolioid[i]);
		
		
	}
	
			
} // done - class portfolio //



