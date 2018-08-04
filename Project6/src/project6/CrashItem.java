
package project6;

/**
 *
 * @author kyle
 */
public class CrashItem { 
   private String iData;
   private int hashvalue;
   private int index;
//--------------------------------------------------------------
   public CrashItem(String key, int h, int i){ 
       iData = key;
       hashvalue = h;
       index = i;
   }
//--------------------------------------------------------------
   public String getKey(){ 
       return iData; 
   }
   
   public int getHash(){ 
       return hashvalue; 
   }
   
   public int getIndex(){
       return index;
   }
//--------------------------------------------------------------
}  // end class DataItem
