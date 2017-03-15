/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadata2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Raluca
 */
public class Bazadata2 {
public static void main(String[] args)
{
 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
	           public void run()
	           {
	        	GraphicControl userInterface = new GraphicControl();
	       		userInterface.setVisible(true);
	           }
	       });
	}
  
}

