import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class game extends JFrame{
    private JButton button1;
    private JTextField textField1;
    private JButton hintButton;

    private JPanel name;
    private JLabel Robot;
    private JLabel mainLine;
    private JButton button2;
    private JLabel Score;
    int a = 100;
    int k=0;
    int score=0;
    public void generate() {

        Random r1 = new Random();
        k = r1.nextInt(a);
        mainLine.setText("I am thinking a number between 1 to "+a);
        System.out.println(k);
    }
    public void music(String s){
        try{
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Tonay Sadhukhan\\Documents\\"+s+".wav").getAbsoluteFile());
            Clip clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public game() {

        generate();
        mainLine.setText("I am thinking a number between 1 to "+a);
        textField1.setFont(new Font("cooper",Font.BOLD,30));


        add(name);

        hintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                music("clicking");
                if(k%2==0)
                    JOptionPane.showMessageDialog(hintButton,"The number is even");
                else
                    JOptionPane.showMessageDialog(hintButton,"The number is odd");

            }
        });

        button1.addActionListener(new ActionListener() {
            int i=1;

            @Override
            public void actionPerformed(ActionEvent e) {
                music("clicking");
                System.out.println(i);

                if(i==4){
                    JOptionPane.showMessageDialog(hintButton, "Time out");
                    generate();
                    i=0;
                }
                   else if (k == Integer.parseInt(textField1.getText())) {

                        JOptionPane.showMessageDialog(hintButton, "Right");
                        generate();
                        music("win");
                        if(i==1)
                        score=score+10;
                        else if (i==2) {
                            score=score+7;

                        }
                        else
                            score=score+5;
                        Score.setText("Score:"+score);

                        i=0;

                    } else if (k > Integer.parseInt(textField1.getText())) {

                        mainLine.setText("No the number is grater than your's");

                    }

                    else {

                        mainLine.setText("No the number is lesser than your's");

                    }
                i++;
            }

        }
        );
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        game g=new game();

        g.setSize(460,460);
        //g.pack();
        g.setVisible(true);
        g.setResizable(false);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

