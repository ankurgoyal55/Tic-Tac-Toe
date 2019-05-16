package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class GameMenuFrame extends JFrame  implements ActionListener{
   
    JButton playJb, instructionJb, winPercentJb, exitJb;
    
    
  GameMenuFrame(){
      super("GameMenu");
      playJb=new JButton("Play");
      instructionJb=new JButton("View Instruction");
      winPercentJb=new JButton ("View the Win Percentage");
      exitJb=new JButton("Exit");
      
      
      setLayout(null);
      
      playJb.setBounds(80,30,180,40);
      instructionJb.setBounds(80, 80, 180, 40);
      winPercentJb.setBounds(80,130,180,40);         
      exitJb.setBounds(80,180,180,40 );
      
      
      add(playJb);
      add(instructionJb);
      add(winPercentJb);
      add(exitJb);
      
      setSize(380,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      playJb.addActionListener(this);
      
      instructionJb.addActionListener(this);
      
      winPercentJb.addActionListener(this);
      
      exitJb.addActionListener(this);
      
     
  }  
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==playJb){
           InputFrame iframe=new InputFrame();
      }
      else if(ae.getSource()==instructionJb){
          JOptionPane.showMessageDialog(this, "Your goal is to be the first player to get 3 X's or O's in a row. (horizontally, diagonally, or vertically)");
      }
      else if(ae.getSource()==winPercentJb){
          GetScoreFrame gcf=new GetScoreFrame();
          
      }
      else{
           System.exit(0);
      }
  }
}


class InputFrame extends JFrame implements ActionListener{
    
    JLabel player1Jl, player2Jl;
    JTextField player1Jtf,player2Jtf;
    JButton startJb;
    
    InputFrame(){
     super("Inputs Frame");
      
      player1Jl=new JLabel("Enter First Player Name");
      player2Jl=new JLabel("Enter Second Player Name");
      
      player1Jtf=new JTextField();
      player2Jtf=new JTextField();
      
      startJb=new JButton("Start the Game");
      
      
      setLayout(null);
      
      player1Jl.setBounds(10, 30,160,30);
      player1Jtf.setBounds(170,30, 160,30);
      
      player2Jl.setBounds(10, 80,160,30);
       player2Jtf.setBounds(170,80, 160,30);
       
       startJb.setBounds(50,150,150,30);
       
      
      add(player1Jl);
      add(player1Jtf);
      
      add(player2Jl);
      add(player2Jtf);
      
      add(startJb);
      
      
      startJb.addActionListener(this);
      
      
      setSize(380,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
      
    }
    public void actionPerformed(ActionEvent ae){
        
            String player1=player1Jtf.getText();
            String player2=player2Jtf.getText();
            
            TicTacToeFrame ttf=new TicTacToeFrame(player1,player2);
        
    }
}



 class GetScoreFrame extends JFrame{
    JLabel playerNameJl;
    JTextField playerNameJtf;
    JButton scoreJb;
    FileOperation fo;
    GetScoreFrame(){
        super("Win Percent");
        setLayout(null);
        
        
        playerNameJl=new JLabel("     Enter Name   ");
        playerNameJtf=new JTextField();
        scoreJb=new JButton("Get the Win Percent");
        
        playerNameJl.setBounds(10,50,100,30);
        playerNameJtf.setBounds(120,50,120,30);
        scoreJb.setBounds(50,120,150,30);
        
        add(playerNameJl);
        add(playerNameJtf);
        add(scoreJb);
        
        setSize(300,300);
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fo=new FileOperation();
        scoreJb.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            String playerName=playerNameJtf.getText();
            String scorePercent=fo.getData(playerName);
            JOptionPane.showMessageDialog(null, "Win Percentage of "+playerName+":"+scorePercent);
        }
        });
              
    }
   
    
}


class TicTacToeFrame implements ActionListener {

private JFrame window;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
private JButton button5;
private JButton button6;
private JButton button7;
private JButton button8;
private JButton button9;
private String letter = "";
private int count = 0;
private boolean win = false;
String player1,player2;

FileOperation fo;

TicTacToeFrame(String player1,String player2){

fo=new FileOperation();
    
this.player1=player1;    
this.player2=player2;

window = new JFrame("Tic-Tac-Toe");
button1 = new JButton("");
button2 = new JButton("");
button3 = new JButton("");
button4 = new JButton("");
button5 = new JButton("");
button6 = new JButton("");
button7 = new JButton("");
button8 = new JButton("");
button9 = new JButton("");
window.setSize(380,300);
window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
window.setLayout(new GridLayout(3,3));


window.add(button1);
window.add(button2);
window.add(button3);
window.add(button4);
window.add(button5);
window.add(button6);
window.add(button7);
window.add(button8);
window.add(button9);


button1.addActionListener(this);
button2.addActionListener(this);
button3.addActionListener(this);
button4.addActionListener(this);
button5.addActionListener(this);
button6.addActionListener(this);
button7.addActionListener(this);
button8.addActionListener(this);
button9.addActionListener(this);


window.setVisible(true);
}

public void actionPerformed(ActionEvent a) {
count++;


if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9){
letter = "X";
} else if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10){
letter = "O";
}


if(a.getSource() == button1){
button1.setText(letter);
button1.setEnabled(false);
} else if(a.getSource() == button2){
button2.setText(letter);
button2.setEnabled(false);
} else if(a.getSource() == button3){
button3.setText(letter);
button3.setEnabled(false);
} else if(a.getSource() == button4){
button4.setText(letter);
button4.setEnabled(false);
} else if(a.getSource() == button5){
button5.setText(letter);
button5.setEnabled(false);
} else if(a.getSource() == button6){
button6.setText(letter);
button6.setEnabled(false);
} else if(a.getSource() == button7){
button7.setText(letter);
button7.setEnabled(false);
} else if(a.getSource() == button8){
button8.setText(letter);
button8.setEnabled(false);
} else if(a.getSource() == button9){
button9.setText(letter);
button9.setEnabled(false);
}


if( button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != ""){
win = true;
}
else if(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != ""){
win = true;
}
else if(button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != ""){
win = true;
}


else if(button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != ""){
win = true;
}
else if(button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != ""){
win = true;
}
else if(button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != ""){
win = true;
}


else if(button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != ""){
win = true;
}
else if(button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != ""){
win = true;
}
else {
win = false;
}


if(win == true){
   System.out.println(letter);
   switch(letter) 
   {
       case "X":JOptionPane.showMessageDialog(null, player1.toUpperCase() + " WINS!");
                
                fo.player1(player1);
                fo.player2(player2);
                fo.writeData(player1);
                break;
       case "O":JOptionPane.showMessageDialog(null, player2.toUpperCase() + " WINS!");
                fo.player1(player1);
                fo.player2(player2);
                fo.writeData(player2);
               
                break;
   }
   
} else if(count == 9 && win == false){
JOptionPane.showMessageDialog(null, "Tie Game!");
}
}

}


 class FileOperation {
    String player1,player2, playerName;
    int winScore=1,lostScore=0;
    
    void player1(String player){
     this.player1=player;       
    }
    void player2(String player){
     this.player2=player;       
    }
    String getData(String player){
       
        playerName=player.toLowerCase();
        String finalScore="";
        //Reading Data      
        try (BufferedReader bf = new BufferedReader(new FileReader("Score.txt"))) {
            String stringSearch=playerName;
            int linecount1 = 0;
            String line;
            String line1;             
            
            int linecount = 0;
            double temp=0.0;
            double sum=0.0;
            while ((line = bf.readLine()) != null) {
                String txt[] = line.split(" ");
                for (int i = 0; i < txt.length; i++) {
                    if (txt[i].equals(stringSearch)) {
                        
                         temp = Double.parseDouble(txt[i+1]);
                         linecount++;
                         sum+=temp;
                    }                            
                }
            }                 
            
            
            Double winpercentage=(sum/linecount)*100;                 
             finalScore=winpercentage.toString();               
     }

         catch (IOException e) {
           
        }  
    return finalScore;
    }
    void writeData(String playerName){
        //Writing Data
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Score.txt", true))) {
            if(playerName.equals(player1)){
                
                bw.append("\n" + player1.toLowerCase() + " " + winScore);
                bw.append("\n" + player2.toLowerCase() + " " + lostScore);
                bw.append("\n--------------------------");
            }
            else{
               
                bw.append("\n" + player2.toLowerCase() + " " + winScore);
                bw.append("\n" + player1.toLowerCase() + " " + lostScore);
                bw.append("\n--------------------------");
            }
        }

        catch(Exception e){
            
        }
        }
    }




public class Main {

    public static void main(String[] args) {
      GameMenuFrame gmf=new GameMenuFrame();  
    }
    
}