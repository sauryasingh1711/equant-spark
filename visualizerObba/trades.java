

/*
 * @author Saurya Singh
 *
 */

//import java.util.Date;
//import java.io.*;

public class trades{

	public static int refTradesFlag=0;
	public static tradeModel[] refTrades = new tradeModel[10];	
	public static String[] ref_tradeid = new String[10];
	public static String[] ref_wkn = new String[10];
    public static String[] ref_tradedate = new String[10];
	public static String[] ref_valutadate = new String[10];
	public static Double[] ref_nominal = new Double[10];
	public static Double[] ref_price = new Double[10];
	public static String[] ref_insttype = new String[10];
	public static String[] ref_company = new String[10];
	public static String[] ref_desk = new String[10];
	public static String[] ref_book = new String[10];
	
	
	public static int bmTradesFlag=0;
	public static tradeModel[] bmTrades = new tradeModel[10];	
	public static String[] bm_tradeid = new String[10];
	public static String[] bm_wkn = new String[10];
    public static String[] bm_tradedate = new String[10];
	public static String[] bm_valutadate = new String[10];
	public static Double[] bm_nominal = new Double[10];
	public static Double[] bm_price = new Double[10];
	public static String[] bm_insttype = new String[10];
	public static String[] bm_company = new String[10];
	public static String[] bm_desk = new String[10];
	public static String[] bm_book = new String[10];
	
	
	public static void loadRefTrades() {		
		
		refTrades[0] = new tradeModel("RF_113740_0+","113740","2013.01.02","2013.01.04",-900000000.0, 99.983,"schatz", "ref_bund","eigenbestand","bestand_fa" );		
		refTrades[1] = new tradeModel("RF_113740_1+","113740","2013.01.02","2013.01.04",3600000000.0, 99.983,"schatz", "ref_bund","emissionen",  "tender_aufst" );
		refTrades[2] = new tradeModel("RF_113740_2+","113740","2013.01.02","2013.01.04", 900000000.0, 99.983,"schatz", "ref_bund","emissionen",  "tender_aufst" );
		refTrades[3] = new tradeModel("RF_113740_3+","113549","2013.01.02","2013.01.07",-900000000.0,100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
		refTrades[4] = new tradeModel("RF_113740_4+","114164","2013.01.02","2013.01.07",-900000000.0,100.534,"bobl",   "ref_bund","eigenbestand","bestand_fa" );
		refTrades[5] = new tradeModel("RF_113740_5+","113740","2013.01.02","2013.01.07",-900000000.0, 99.954,"schatz", "ref_bund","eigenbestand","bestand_fa" );
		refTrades[6] = new tradeModel("RF_113740_6+","113549","2013.01.02","2013.01.07",-900000000.0,100.657,"bund10", "ref_bund","eigenbestand","bestand_fa" );
		refTrades[7] = new tradeModel("RF_113740_7+","114164","2013.01.02","2013.01.07",-900000000.0,100.534,"bobl",   "ref_bund","eigenbestand","bestand_fa" );
		refTrades[8] = new tradeModel("RF_113740_8+","113740","2013.01.02","2013.01.07",-900000000.0, 99.954,"schatz", "ref_bund","eigenbestand","bestand_fa" );
		refTrades[9] = new tradeModel("RF_113740_9+","113740","2013.01.02","2013.01.07",-900000000.0, 99.954,"schatz", "ref_bund","eigenbestand","bestand_fa" );			
				
		for (int i=0; i<refTrades.length; i++ ) {		
			ref_tradeid[i] = refTrades[i].getTradeid();				
			ref_wkn[i] = refTrades[i].getWkn();
			ref_tradedate[i] = refTrades[i].getTradedate();
			ref_valutadate[i] = refTrades[i].getValutadate();
			ref_nominal[i] = refTrades[i].getNominal();
			ref_price[i] = refTrades[i].getPrice();
			ref_insttype[i] = refTrades[i].getInsttype();
			ref_company[i] = refTrades[i].getCompany();
			ref_desk[i] = refTrades[i].getDesk();
			ref_book[i] = refTrades[i].getBook();			
		} 
		refTradesFlag=1;
	} //loadRefTrades

	

	public static void loadBMTrades() {		
		
		bmTrades[0] = new tradeModel("BM_113740_0+","113740","2013.01.02","2013.01.04", 5000000000.0, 99.983,"schatz", "bm_bund","emissionen","bestand_fa" );		
		bmTrades[1] = new tradeModel("BM_113740_1+","113740","2013.01.02","2013.01.04",-1000000000.0, 99.983,"schatz", "bm_bund","eigenbestand","tender_aufst" );
		bmTrades[2] = new tradeModel("BM_113740_2+","113524","2013.01.02","2013.01.07",  -56000000.0,104.277,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[3] = new tradeModel("BM_113740_3+","113526","2013.01.02","2013.01.07",  -39000000.0,107.494,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[4] = new tradeModel("BM_113740_4+","113549","2013.01.02","2013.01.07",   29000000.0,100.170,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[5] = new tradeModel("BM_113740_5+","114164","2013.01.02","2013.01.07",   43000000.0,100.691,"bobl",   "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[6] = new tradeModel("BM_113740_6+","113740","2013.01.02","2013.01.07",   71000000.0, 99.954,"schatz", "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[7] = new tradeModel("BM_113740_7+","114164","2013.01.03","2013.01.08",   42000000.0,100.570,"bobl",   "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[8] = new tradeModel("BM_113740_8+","113549","2013.01.03","2013.01.08",   28000000.0,101.030,"bund10", "bm_bund","eigenbestand","bestand_fa" );
		bmTrades[9] = new tradeModel("BM_113740_9+","114164","2013.01.03","2013.01.08",   12000000.0,100.570,"bobl",   "bm_bund","eigenbestand","bestand_fa" );
			
		for (int i=0; i<bmTrades.length; i++ ) {
			bm_tradeid[i] = bmTrades[i].getTradeid();			    
			bm_wkn[i] = bmTrades[i].getWkn();
			bm_tradedate[i] = bmTrades[i].getTradedate();
			bm_valutadate[i] = bmTrades[i].getValutadate();
			bm_nominal[i] = bmTrades[i].getNominal();
			bm_price[i] = bmTrades[i].getPrice();
			bm_insttype[i] = bmTrades[i].getInsttype();
			bm_company[i] = bmTrades[i].getCompany();
			bm_desk[i] = bmTrades[i].getDesk();
			bm_book[i] = bmTrades[i].getBook();	
			
		} 
		bmTradesFlag=1;
	} //loadBMTrades
		
} //trades//

