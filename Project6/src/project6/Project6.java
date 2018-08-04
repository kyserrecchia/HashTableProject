
package project6;

/**
 *
 * @author kyle
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project6 extends JFrame implements ActionListener {

private static int win_xpos=0,win_ypos=0;// place window here
private static int win_xsize=700,win_ysize=500;//  window size

// Private state variables.

private Font boldfont = new Font ("TimesRoman",Font.BOLD,18);
private Font plainfont = new Font ("TimesRoman",Font.PLAIN,12);

private JButton hashbutton,exitbutton;
private JPanel northPanel;
private MyJPanel centerPanel;
private JTextField hashsizefield;
private String thetext = "101";
private HashTable hashish;
private CrashItem[] shishes = new CrashItem[100];
private boolean tableMade;
private String[] names = {"fred" , "barney", "tom", "jerry", "larry", "moe","curly", 
            "betty" , "wilma", "bart", "homer", "marge", "maggie", "lisa", 
            "pebbles" , "bambam", "smithers", "burns", "milhouse", "george", "astro", 
            "dino" , "mickey", "minnie", "pluto", "goofy", "donald", "huey", 
            "louie" , "dewey", "snowwhite", "happy", "doc", "grumpy", "sneezy", 
            "dopey" , "sleepy", "bambi", "belle", "gaston", "tarzan", "jane", 
            "simba" , "scar", "mufasa", "ariel", "flounder", "bugs", "daffy", 
            "elmer" , "foghorn", "chickenhawk", "roger", "jessica", "hank", "bobby", 
            "peggy" , "spot", "pongo", "perdy", "buzz", "potatohead", "woody", 
            "chuckie" , "tommy", "phil", "lil", "angelica", "dill", "spike", 
            "pepe" , "speedy", "yosemite", "sam", "tweety", "sylvester", "granny", 
            "spiderman" , "batman", "superman", "supergirl", "robin", "jimmy","olsen", 
            "thing" , "flash", "silversurfer", "xmen", "pokemon", "joker", "wonderwoman"};


////////////MAIN////////////////////////

public static void main(String[] args) {
        Project6 tpo  = new Project6();

        tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
}

////////////CONSTRUCTOR/////////////////////

public Project6 ()  {
       tableMade = false;
       northPanel = new JPanel();
       northPanel.add(new Label("Enter a hashtable size: "));
       hashsizefield = new JTextField(thetext,20);
       northPanel.add(hashsizefield);
       hashbutton = new JButton("CreateHash");
       northPanel.add(hashbutton);
       hashbutton.addActionListener(this);
       exitbutton = new JButton("Exit");
       northPanel.add(exitbutton);
       exitbutton.addActionListener(this);
       getContentPane().add("North",northPanel);
       centerPanel = new MyJPanel();
       getContentPane().add("Center",centerPanel);

       // need more init stuff? try here.
       setSize(win_xsize,win_ysize);
       setLocation(win_xpos,win_ypos);
       setVisible(true);
}

////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {
         if (e.getSource()==exitbutton) {
               dispose(); System.exit(0);
         }

         if (e.getSource()==hashbutton) {
               thetext = hashsizefield.getText();
               hashish = new HashTable(Integer.parseInt(thetext));
               tableMade = true;
               loadHashTable();
               shishes = getCrashes();
               repaint();
         }
} // end actionPerformed

public void loadHashTable(){
    //loop through array and make data items therefrom 
    //  and insert them into hashtable
    for(String name : names) {
        DataItem temp = new DataItem(name);
        hashish.insert(temp);
    }
    
}

public CrashItem[] getCrashes(){
    //loop through names and get their hash value
    //  and also find the index they are stored at
    for(int i = 0; i<names.length; i++){
        int namehash = hashish.hashFunc3(names[i]);
        int nameindex = hashish.getIndex(names[i]);
        if(namehash != nameindex){
           shishes[i] = new CrashItem(names[i], namehash, nameindex);
        }
    }
    //if they are not equal, add them to crash array
    //print message of crash number
    return shishes;
    //loop through crash array and print them 
    
}

class MyJPanel extends JPanel {

 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {

        g.setFont(plainfont);
        g.drawString("I am paint, field contains " + thetext,20,30);
         
        if(tableMade == true){
            int crashCount = 0;
            for (CrashItem shish : shishes) {
                if (shish != null) {
                    crashCount++;
                }
            }
            g.drawString("Collion Count: " + crashCount, 20, 50);
            int linespot = 70;

            for(CrashItem shish : shishes){
                if(shish != null){
                    String name = shish.getKey();
                    int hashval = shish.getHash();
                    int index = shish.getIndex();
                    g.drawString("Collision: " + name, 20, linespot);
                    g.drawString("should be at " + hashval, 200, linespot);
                    g.drawString("found at " + index, 400, linespot);
                    linespot+=20;
                }
            }
        }
//         printCrashes();
  }
} // End Of MyJPanel

}     // End Of Project6