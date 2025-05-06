import javax.swing.*;
import java.awt.event.*;

class MySwingUI  implements ActionListener {

    public MySwingUI() {
        JFrame f = new JFrame();
        JButton b1 = new JButton("Click Me");

        b1.setBounds(150, 150, 250, 50);
        b1.addActionListener(this);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(b1);
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
    }

}