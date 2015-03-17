import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.*;  
import javax.swing.plaf.FontUIResource;
      
public class Stick  extends JFrame{
       
 // FileOperation fileHandler;
        JTextArea area;  
        JFrame f; 
        String str,str1="";
        File file;
       FileWriter fw;
        public static void setUIFont(FontUIResource f) {
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
        void deskStick() throws IOException{  
        f=new JFrame();  
              f.setBackground(Color.green);
        area=new JTextArea(100,100);  
        area.setBounds(0,0,500,500);  
          
       f.getContentPane().setBackground(Color.BLUE);   
        area.setForeground(Color.GREEN);  
               area.setBackground(Color.BLUE);
        f.add(area);
       //  file = new File("E:/javaproj/Sticky.txt");
         BufferedReader br = new BufferedReader(new FileReader("E:/javaproj/Sticky.txt"));
         
			while ((str = br.readLine()) != null) {
				
                              str1+=str+"\n";
			}
         WindowListener frameClose;
            frameClose = new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we) 
                {
                    file = new File("E:/javaproj/Sticky.txt");
                    try {
                        fw = new FileWriter(file.getAbsoluteFile());
                   
                BufferedWriter bw = new BufferedWriter(fw);
		
                bw.write(area.getText());
                    bw.close();
                   
                     } catch (IOException ex) {
                       
                    }
                    System.exit(0);
                }
            };
         area.setText(str1);
          str=area.getText();
       
       
        f.addWindowListener(frameClose);  
       f.setSize(225,200);  
        f.setLayout(null);  
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }  

        public static void main(String[] args) throws IOException
	 { 
            setUIFont(new FontUIResource(new Font("ARIAL BLACK", 0, 15)));
            new Stick().deskStick();  
         }  
    }  

