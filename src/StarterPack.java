import javax.swing.*;

public class StarterPack {

    private JFrame window;

    public StarterPack(){
        window = new JFrame("Калькулятор");
        window.setSize(410,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.add(new Panel());
        window.setVisible(true);
    }

    public static void main(String[] args) {
        MyTread myTread = new MyTread();
        myTread.start();
    }
}

class MyTread extends Thread{
    @Override
    public void run() {
        new StarterPack();
    }
}
