import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Mainframe extends JFrame {
    private JTextField Jtf = new JTextField();
   private JButton Jbtn[] = new JButton[8];
   private JPanel Jp= new JPanel(new GridLayout(3,3,3,3));
    private Container cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW = 300,frmH=400 ,ScreenW,ScreenH;
    private  Loginframe log;
private boolean b;
    private int  n=0;
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
        for(int i=0;i<9;i++)
        {
            b = true;
            while(b) {
                b = false;
                n = rand.nextInt(9);
                for(int j=0;j<Jbtn.length;j++) {
                    if(Jbtn[j].getText().equals(Integer.toString(n))){
                        b = true;
                    }
                }
            }
            Jbtn[i]=new JButton(Integer.toString(n));
            Jp.add(Jbtn[i]);
            Jbtn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton = (JButton)e.getSource();
                    Jtf.setText(Jtf.getText()+tmpButton.getText());

                }
            });
        }
//        for (int i = 0 ;i<9;i++){
//
//            int s = rand.nextInt(9);
//            while(true){
//                Jbtn[i]=new JButton(Integer.toString(s));
//
//                break;
//            }
//            Jp.add(Jbtn[i]);
//
//            Jbtn[i].addActionListener(new AbstractAction() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JButton tmpButton = (JButton)e.getSource();
//                    Jtf.setText(Jtf.getText()+tmpButton.getText());
//
//                }
//            });
//
//
//        }
        Jtf.setEditable(false);
    }
}
