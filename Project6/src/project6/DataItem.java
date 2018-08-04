
package project6;

/**
 *
 * @author kyle
 */
public class DataItem {                                // (could have more data)
   private String iData;               // data item (key)
//--------------------------------------------------------------
   public DataItem(String ii)          // constructor
      { iData = ii; }
//--------------------------------------------------------------
   public String getKey()
      { return iData; }
//--------------------------------------------------------------
}  // end class DataItem