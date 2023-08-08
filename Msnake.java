import javax.swing.JFrame;  //导入JFrame类。

public class Msnake{   //定义了一个名为Msnake的公共类。
    public static void main(String[] args){  //定义了一个名为main的公共静态方法，程序从这里开始执行。
        // 画出白色窗口


        JFrame frame = new JFrame(); //创建一个JFrame对象实例。
        frame.setBounds(10, 10, 900, 720);  //设置JFrame对象的位置和大小，分别为x轴位置、y轴位置、宽度和高度。
        frame.setResizable(false); //设置JFrame对象的大小是否可调整。
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置JFrame对象的默认关闭操作。
        //JFrame.EXIT_ON_CLOSE 是一个静态常量，表示关闭 JFrame 窗口时默认的操作，即退出程序。
        //当用户点击关闭窗口按钮时，程序会自动调用 System.exit(0) 方法，使程序退出。
        frame.add(new Mpanel()); //将一个新的Mpanel面板添加到frame中，使得Mpanel面板可以显示在frame窗口中。
        frame.setVisible(true);  //将窗口设置为可见状态。JFrame对象会自动调用Mpanel的paintComponent方法来绘制面板。
        //实参为系统自动生成的Graphics对象，用于绘制图形。
    }
}