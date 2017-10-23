import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Mainframe extends JFrame {
    private JTextField Jtf = new JTextField();
   private JButton Jbtn[] = new JButton[10];
    private int data[] = new int[10];
   private JPanel Jp= new JPanel(new GridLayout(4,3,3,3));
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH=400 ,ScreenW,ScreenH;
    private  Loginframe log;
    private boolean b;
    private int  n;
    public Mainframe(Loginframe loginframe){
       log= loginframe;
        init();

    }
    private void init(){
        Random rand = new Random();
        ScreenH=dim.height;
        ScreenW=dim.width;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Mainframe.this.setVisible(false);
                log.setVisible(true);
            }
        });

       // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(ScreenW/2-frmW/2,ScreenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(5,5));
        cp.add(Jtf,BorderLayout.NORTH);
        cp.add(Jp,BorderLayout.CENTER);
        for(int i=0;i<10;i++){
            for(int j =1;j<11;j++) {
                data[i] = j;
            }

        }
        for(int i=0;i<10;i++)
        {
            b = true;
            while(b) {
                b = false;
                n = rand.nextInt(10);
                for(int j=0;j<data.length;j++) {
                    if(n==data[j]){
                        b = true;
                    }
                }
                data[i]=n;
            }

            Jbtn[i]=new JButton(Integer.toString(data[i]));
            Jp.add(Jbtn[i]);
            Jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton)e.getSource();
                    Jtf.setText(Jtf.getText()+tmpButton.getText());

                }
            });
        }
        Jtf.setEditable(false);
    }
}
