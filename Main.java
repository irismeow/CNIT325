/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 나가네 PC
 */
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Main extends JFrame {
    private JTextField textField = new JTextField(30);
    private JButton button = new JButton("Serach");
    private JPanel panel = new JPanel();
    
    private GoogleAPI googleAPI = new GoogleAPI();

    private JLabel googleMap = new JLabel();
    
    public class Event implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           setMap(textField.getText()); 
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
             
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
             
        }
        
    }
    public void setMap(String location){
        googleAPI.downloadMap(location);
        googleMap.setIcon(googleAPI.getMap(location));
        googleAPI.fileDelete(location);
        add(BorderLayout.SOUTH, googleMap);
        pack();
    }
    public Main(){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Google Maps");
        setVisible(true);
        
        panel.add(textField);
        panel.add(button);
        button.addMouseListener(new Event());
        
        
        
        add(BorderLayout.NORTH, panel);
        add(googleMap);
        
       
        pack();
    }
    
}
