/** WishList Class - Written by: Jabree Ellis
  * Date Modified: 4 December 2014 
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WishListTab extends JPanel {
  
  //declare buttons and labels 
  
  private JLabel welcome; 
 
  private JLabel description; 
  
  private JLabel wishBooks; 
  
  //private JButton previous; 
  
  //private JButton next;
  
  
  public WishListTab(/*WishList wl*/) {
     setLayout (new FlowLayout());
    
   //include a basic grid format 
    welcome = new JLabel("WishList!"); 
    description = new JLabel ("View the wishlist books below.\n"); 
    
    add(welcome); 
    add(description); 
    add(new InputPanel()); 
   

  } //ends constructor
  
  private class InputPanel extends JPanel {
    
    public InputPanel(){
      setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
      
      wishBooks = new JLabel(/*wl.toString()*/); 
      
      add(wishBooks); 
      
      
    } //ends InputPanel constructor
    
  } //ends InputPanel class
  
  
   private class ButtonListener implements ActionListener {
      
      public void actionPerformed (ActionEvent event) {
       
      } //ends actionPerformed method
      
    } //ends ButtonListener class
  
} //ends WishListTab class