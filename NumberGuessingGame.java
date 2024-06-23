import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
class GUI implements ActionListener
{
    JFrame f;
    JButton ok;
    JTextArea ta;
    JTextField tf;
    static Boolean click=false;
    GUI()
    {
        f=new JFrame("Number Guessing Game");
        ok=new JButton("Ok");
        ta=new JTextArea("Click OK for next step :)");
        tf=new JTextField();

        f.add(ok);
        f.add(ta);
        f.add(tf);

        ta.setBounds(10,10, 470,370 );
        tf.setBounds(10, 385, 235, 60);
        ok.setBounds(255, 385, 225, 60);

        ok.addActionListener(this);
        tf.addActionListener(this);

        ta.setEditable(false);
        ta.setBackground(new Color(85, 247, 73));
        f.setLayout(null);
        f.setSize(505, 500);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        click=true;
        //setta(click.toString(click)+tf.getText());
    }
    void setta(String s)
    {
        ta.setText(ta.getText()+"\n"+s);
    }
    String gettf()
    {
        String s=tf.getText();
        tf.setText("");
        return s;
    }

}
class Ngg {
    int num;
    int noa;
    Random random=new Random();
    Ngg()
    {
        num=random.nextInt(50);
        noa=6;
    }
    Ngg(int n,int a)
    {
        num=random.nextInt(n);
        noa=a;
    }
    int checker(int no)
    {
        if(no<num)
        {
            return 0;
        }
        else if(no>num)
        {
            return 1;
        }
        else 
            	return 2;
    }
    static void start()
    {
        String given;
        GUI gui=new GUI();
        String feedback[]=new String[3];
        feedback[0]="Your guessing is smaller :( ";
        feedback[1]="Your guessing is greater :( ";
        feedback[2]="Your guessing is correct :) ";
        //Scanner scan=new Scanner(System.in);
        System.out.println("Welcome to number guessing game :)");
        gui.setta("Welcome to number guessing game :)");

        System.out.println("Before loop");
        while(!GUI.click)
        {
            System.out.print("");
        }
            //gui.setta("oop");
        System.out.println("After loop");
        GUI.click=false;

        String def;
        System.out.println("Set bound value & no.of attempts(1) or default(0)");
        gui.setta("Set bound value & no.of attempts(1) or default(0)");
        

        while(!GUI.click)
        {
            System.out.print("");
        }
        GUI.click=false;
        
        given=gui.gettf();
        gui.setta(given);
        def=given;//scan.nextInt();
        
        Ngg player;
        System.out.println(def);
        if(def.equals("0"))
        {
            player=new Ngg();
        }
        else
        {
            System.out.println("Enter bound value:");
            gui.setta("Enter bound value:");
        

            while(!GUI.click)
            {
                System.out.print("");
            }
            GUI.click=false;
            
            given=gui.gettf();
            gui.setta(given);
            int n=Integer.parseInt(given);//int n=scan.nextInt();
            System.out.println("Enter no.of attempts:");
            gui.setta("Enter no.of attempts:");;
            
            while(!GUI.click)
            {
                System.out.print("");
            }
            GUI.click=false;
        
            given=gui.gettf();
            gui.setta(given);
            int a=Integer.parseInt(given);//int a=scan.nextInt();
            player=new Ngg(n, a);
        }
        for(int i=0;i<player.noa;i++)
        {
            System.out.print((i+1)+").");
            System.err.print("Guess a number:");
            gui.setta(Integer.toString(i+1)+".)Guess a number:");
            
            while(!GUI.click)
            {
                System.out.print("");
            }
            GUI.click=false;
        
            given=gui.gettf();
            gui.setta(given);
            int guess=Integer.parseInt(given);//int guess=scan.nextInt();
            int res=player.checker(guess);
            System.out.println(feedback[res]);
            gui.setta(feedback[res]);;
            if(res==2)
                break;
        }
        gui.setta("\n Thank You :) ");
    }
    
}
public class NumberGuessingGame {

    public static void main(String[] args) {
        Ngg.start();
    }
}