    
/*
 * @author NeerajSingh
 *
 */
    
    package extObbaPOI;
     
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    //import java.io.IOException;
    import java.io.*;
    import java.util.Iterator;
    //import java.util.ArrayList;
    import java.util.*; 
     

    /*--- Standard Utils ---*/
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
    import org.apache.poi.ss.usermodel.*;

    /*--- XSSF includes ---*/
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    /*--- XML beans includes ---*/  
    import org.apache.xmlbeans.*;
    ////////////////////////////////////////////////////////////


@WebService(serviceName = "poiGenExcelBeanXSSFService")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class poiGenExcelBeanXSSFService {

        private static String efile;
        private static int exist=0;
            private static int buildBeanFlag=0;
            private static Map<Integer, Object[]> Objrow; // = new HashMap<Integer, Object[]="">();
            //private static Map<Integer, Object[]=""> Objrow = new HashMap<Integer, Object[]="">();
            private static int restore_stream=0;
            private static int dumptrace=1;

            public poiGenExcelBeanXSSFService() {
                super();
            }
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static void persistJBean(){
                    
                    try{
                            if (dumptrace==1 || dumptrace==7) System.out.println("\n\n --- Function: persistJBean --- ");
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\devdrv\\more4\\ExtAppObba\\JBean_Persist_Portfolio.txt"));    
                            int cnt=0;
                            //Set<Integer> keyset = Objrow.keySet();
                            Set<Integer> keyset = Objrow.keySet();
                            
                            for (Integer key : keyset) {
                                    Object[] objArr = Objrow.get(key);      
                                    
                                    cnt=0;
                                    for (Object obj : objArr) {                             
                                            oos.writeObject(objArr[cnt++]);
                                    }                               
                            }
                            oos.close();
                            restore_stream=1;
                    }               
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }

            }  // object array persisted.
            ////////////////////////////////////////////////////////////
            
            
            
            ////////////////////////////////////////////////////////////
            public static Object[][] restoredExcel;
            public static String[][] restoredExcelStrArr;
            private static int I_NROW=21, I_NCOL=10;

    @WebMethod(exclude = true)
    public static Object[][] restoreJBean(){                
                    try{
                            if (dumptrace==1 || dumptrace==7) System.out.println("\n\n --- Function: restoreJBean --- ");
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\devdrv\\more4\\ExtAppObba\\JBean_Persist_Portfolio.txt"));
                                                    
                            int cnt=0;
                            restoredExcel = new Object[I_NROW][I_NCOL];
                            Set<Integer> keyset = Objrow.keySet();
                                                    
                            for (Integer key : keyset) {
                                    Object[] objArr = Objrow.get(key);      

                                    if (dumptrace==1 || dumptrace==7) {
                                            System.out.println("\n" );                                                      
                                            System.out.print( cnt + " ");                           
                                            for (Object obj : objArr) {                                     
                                                    System.out.print( ois.readObject() + " " );                                     
                                            }
                                    }
                                    restoredExcel[cnt]=objArr;              
                                    cnt++;
                            }                                               
                            ois.close();    
                            restore_stream=2;       
                    }
                    catch (ClassNotFoundException e) {
                            e.printStackTrace();
                    }
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
                    return restoredExcel;
            }
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static String[][] restoreJBeanExcel(){
                    try{
                            if (dumptrace==1 || dumptrace==7) System.out.println("\n\n --- Function: restoreJBeanExcel --- ");
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\devdrv\\more4\\ExtAppObba\\JBean_Persist_Portfolio.txt"));
                                                    
                            int cnt=0;
                            restoredExcel = new Object[I_NROW][I_NCOL];
                            Set<Integer> keyset = Objrow.keySet();
                                                    
                            for (Integer key : keyset) {
                                    Object[] objArr = Objrow.get(key);      

                                    if (dumptrace==1 || dumptrace==9) {
                                            System.out.println("\n" );                                                      
                                            System.out.print( cnt + " ");                           
                                            for (Object obj : objArr) {                                     
                                                    System.out.print( ois.readObject() + " " );                                     
                                            }
                                    }
                                    restoredExcel[cnt]=objArr;              
                                    cnt++;
                            }                                               
                            ois.close();    
                            restore_stream=2;       
                            
                            restoredExcelStrArr=new String[restoredExcel.length][restoredExcel[0].length];
                            for (int i=0; i<restoredExcel.length; i++) {                    
                                    for (int j=0; j<restoredExcel[0].length; j++) {
                                            restoredExcelStrArr[i][j] = "null";                                     
                                    }
                            }
                            
                            for (int i=0; i<restoredExcel.length; i++) {
                                    if (restoredExcel[i][0] == null) break;
                                    if (dumptrace==1 || dumptrace==7) System.out.println(" ");
                                    for (int j=0; j<restoredExcel[0].length; j++) {
                                            
                                            if (restoredExcel[i][j] != null) {
                                                    restoredExcelStrArr[i][j]= (String) ((restoredExcel[i][j]).toString());                                 
                                                    if (dumptrace==1 || dumptrace==7) System.out.print(restoredExcelStrArr[i][j] + " : ");
                                            } else break;
                                            
                                    }
                            }                       

                    }
                    catch (ClassNotFoundException e) {
                            e.printStackTrace();
                    }
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
                    return restoredExcelStrArr;
            }
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static String[][] restoreJBeanAsStrArr(){                        
                    if (restore_stream !=2 ) restoredExcel=restoreJBean();
                    if (dumptrace==11 || dumptrace==9) System.out.println("\n\n --- Function: restoreJBeanAsStrArr --- ");
                    if (dumptrace==11 || dumptrace==9) System.out.println("\n Restored Bean Dimension- Rows:" + restoredExcel.length + " / Cols:"+ restoredExcel[0].length);
                    restoredExcelStrArr=new String[restoredExcel.length][restoredExcel[0].length];  
                    for (int i=0; i<restoredExcel.length; i++) {
                            if (dumptrace==11 || dumptrace==9) System.out.println(" ");
                            for (int j=0; j<restoredExcel[0].length; j++) {
                                    if (restoredExcel[i][j] == null) restoredExcelStrArr[i][j] = "null";
                                            else restoredExcelStrArr[i][j]= (String) ((restoredExcel[i][j]).toString());                            
                                    if (dumptrace==11 || dumptrace==9) System.out.print(":Rows-"+i +":Cols-"+ j + " " +restoredExcelStrArr[i][j] + " : ");                          
                            }
                    }
                    
                    return restoredExcelStrArr;
            }
            ////////////////////////////////////////////////////////////
            
            
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static String[][] service_restoreExcel(){
                    try{
                            if (dumptrace==1 || dumptrace==7) System.out.println("\n\n --- Function: restoreJBeanExcel --- ");
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\devdrv\\more4\\ExtAppObba\\JBean_Persist_Portfolio.txt"));
                                                    
                            int cnt=0;
                            restoredExcel = new Object[I_NROW][I_NCOL];
                            Set<Integer> keyset = Objrow.keySet();
                                                    
                            for (Integer key : keyset) {
                                    Object[] objArr = Objrow.get(key);      

                                    if (dumptrace==1 || dumptrace==9) {
                                            System.out.println("\n" );                                                      
                                            System.out.print( cnt + " ");                           
                                            for (Object obj : objArr) {                                     
                                                    System.out.print( ois.readObject() + " " );                                     
                                            }
                                    }
                                    restoredExcel[cnt]=objArr;              
                                    cnt++;
                            }                                               
                            ois.close();    
                            restore_stream=2;       
                            
                            restoredExcelStrArr=new String[restoredExcel.length][restoredExcel[0].length];
                            for (int i=0; i<restoredExcel.length; i++) {                    
                                    for (int j=0; j<restoredExcel[0].length; j++) {
                                            restoredExcelStrArr[i][j] = "null";                                     
                                    }
                            }
                            
                            for (int i=0; i<restoredExcel.length; i++) {
                                    if (restoredExcel[i][0] == null) break;
                                    if (dumptrace==1 || dumptrace==7) System.out.println(" ");
                                    for (int j=0; j<restoredExcel[0].length; j++) {
                                            
                                            if (restoredExcel[i][j] != null) {
                                                    restoredExcelStrArr[i][j]= (String) ((restoredExcel[i][j]).toString());                                 
                                                    if (dumptrace==1 || dumptrace==7) System.out.print(restoredExcelStrArr[i][j] + " : ");
                                            } else break;
                                            
                                    }
                            }                       

                    }
                    catch (ClassNotFoundException e) {
                            e.printStackTrace();
                    }
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
                    return restoredExcelStrArr;
            }            
            ////////////////////////////////////////////////////////////
            
            
            
            ////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////
            //Test Objects-1
            static public Object[][] testObj = { {1,"Hello1"}, {2,"Hello2"},{3,"Hello3"},{4,"Hello4"}};

    @WebMethod(exclude = true)
    static public Object[][] objArr(){
                    return testObj;
            }
            
            static public String[][] testObjStr;

    @WebMethod(exclude = true)
    static public String[][] objArrStr(){
                    testObjStr= new String[testObj.length][testObj[0].length];
                    for (int i=0; i<testObj.length; i++) {
                            //System.out.println("\n");
                            for (int j=0; j<testObj[0].length; j++) {
                                    testObjStr[i][j]=testObj[i][j].toString();
                                    //System.out.println("testObjStr[i][j]");
                            }
                    }
                    return testObjStr;
            }
            ////////////////////////////////////////////////////////////    
            //Test Objects-2
            static public Object testObj2 = "HelloObject";

    @WebMethod(exclude = true)
    static public Object jobj(){
                    return testObj2;
            }
            ////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////
            
            
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static void genBeanExcelXSSF() {
                    
                    try {
                            String deffile="PortfolioData.xlsx";
                            String filepath="C:\\devdrv\\more4\\ExtAppObba\\";
                            if (exist>0) deffile=efile; 
                            //else filename="C:\\devdrv\\more4\\ExtAppObba\\PortfolioData.xlsx";
                            
                            String filename=filepath+deffile;

                            FileInputStream file = new FileInputStream(new File(filename));

                            //Get the workbook instance for XLS file 
                            Workbook workbook = new XSSFWorkbook(file);

                            //Get first sheet from the workbook

                            Sheet sheet = workbook.getSheetAt(0);

                            //Iterate through each rows from first sheet

                            java.util.Iterator<Row> rowIterator = sheet.iterator();
                            int nrow=0, ncol=0, numcolf=0;
                            
                            Objrow = new HashMap<Integer, Object[]>(); //="">();
                            Objrow.put(0, new Object[] {"Def1", "Def2", "Def3"}); 
                            Set<Integer> keyset = Objrow.keySet();
                                    
                                                    
                            //For each row, iterate through each columns    
                            while(rowIterator.hasNext()) {

                                    Row row = rowIterator.next();
                                    Iterator<Cell> cellIterator = row.cellIterator();
                                    
                                    if (nrow==0) {
                                            while(cellIterator.hasNext()) {
                                                    numcolf++;
                                                    cellIterator.next();
                                            }
                                    }

                                    ncol=0;
                                    Object[] objarr = new Object[numcolf];//Objrow.get(0); //= {""};                                
                                    cellIterator = row.cellIterator();
                                    
                                    while(cellIterator.hasNext()) {
                                            Cell cell = cellIterator.next();
                                            switch(cell.getCellType()) {

                                                    case Cell.CELL_TYPE_BOOLEAN:
                                                    if (dumptrace>1) System.out.print(cell.getBooleanCellValue() + "\t\t");
                                                    objarr[ncol]=cell.getBooleanCellValue();                                        
                                                    break;
                                                    
                                                    case Cell.CELL_TYPE_NUMERIC:
                                                    if (dumptrace>1) System.out.print(cell.getNumericCellValue() + "\t\t");
                                                    objarr[ncol]=cell.getNumericCellValue();                                                
                                                    break;
                                                    
                                                    case Cell.CELL_TYPE_STRING:
                                                    if (dumptrace>1) System.out.print(cell.getStringCellValue() + "\t\t");
                                                    objarr[ncol]=cell.getStringCellValue();                                         
                                                    break;
                                            }                                       
                                            ncol++;
                                            
                                    } //done for cols of each row//
                                    
                                    Objrow.put(new Integer(nrow), objarr);
                                    if (dumptrace>1) System.out.println("");
                                    nrow++;         
                            } // done for row//
                            //Set<Integer> keyset = Objrow.keySet();
                            file.close();           
                            deffile="Bean_"+deffile;
                            filename=filepath+deffile;
                            FileOutputStream out =  new FileOutputStream(new File(filename));
                            workbook.write(out);
                            out.close();
                    } 
                    catch (FileNotFoundException e) {
                            e.printStackTrace();
                    } 
                    catch (IOException e) {
                            e.printStackTrace();
                    }
            }
            ////////////////////////////////////////////////////////////
            
            ////////////////////////////////////////////////////////////
    @WebMethod
    public String[][] service_extObbaPOI(@WebParam(name = "arg0") String[] args) {
            //public static void main(String[] args) {
                    exist=0;
                                    
                    //RefTradesData.xlsx+BMTradesData.xlsx//
                    if (args.length>0) { 
                            System.out.println(args[0]);
                            efile=args[0];
                            exist=1;
                    }
                    
                    genBeanExcelXSSF();
                    persistJBean();
                    //restoreJBean(); //restoreJBeanExcel();
                    service_restoreExcel();
                    return restoredExcelStrArr;
                    
            } // void main //
            
            
            
            ////////////////////////////////////////////////////////////
    @WebMethod(exclude = true)
    public static void main_poiGenExcelXSSF(String[] args) {
            //public static void main(String[] args) {
                    exist=0;
                                    
                    //RefTradesData.xlsx+BMTradesData.xlsx//
                    if (args.length>0) { 
                            System.out.println(args[0]);
                            efile=args[0];
                            exist=1;
                    }
                    
                    genBeanExcelXSSF();
                    persistJBean();
                    //restoreJBean();       //restoreJBeanAsStrArr();
                    restoreJBeanExcel();
                    
            } // void main //


    @WebMethod(exclude = true)
    public static void main_cmd(String[] args) {
                    genBeanExcelXSSF();
                    persistJBean();
                    //restoreJBeanAsStrArr();
                    restoreJBeanExcel();
            }
            
} // class poiGenExcelXSSF  //
////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////
