import java.awt.Color; //导入java.awt包中的Color类，用于设置颜色。
import java.awt.Font;  //导入了Java的 awt 库中的 Font 类。Font 类表示用于绘制文本的字体。
import java.awt.Graphics; //导入java.awt包中的Graphics类，用于绘制图形。
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// KeyEvent 类表示键盘事件，它包含有关键盘事件的详细信息，例如按下的键和释放的键。
// 通过使用 KeyEvent 类，可以在Java应用程序中处理键盘事件，例如监听用户按下或释放特定键。
// KeyListener 接口是一个监听器接口，用于处理键盘事件。通过实现 KeyListener 接口并重写其方法，可以在Java应用程序中处理键盘事件。
// 在实现 KeyListener 接口的类中，可以使用 KeyEvent 类的方法来获取有关键盘事件的详细信息，并执行相应的操作。
import javax.swing.ImageIcon; //导入javax.swing包中的ImageIcon类，用于加载图片。
import javax.swing.JPanel; //导入javax.swing包中的JPanel类，用于创建面板。
import javax.swing.Timer; 

public class Mpanel extends JPanel implements KeyListener, ActionListener{ 
// 这段代码定义了一个名为 Mpanel 的类，该类继承了 JPanel 类并实现了 KeyListener 接口。
// 继承 JPanel 类意味着 Mpanel 类可以像 JPanel 一样用于创建绘制图形的面板。
// 而实现 KeyListener 接口意味着 Mpanel 类可以监听并处理键盘事件。
// // 通过在 Mpanel 类中重写 KeyListener 接口中的方法，例如 keyPressed()、
// keyReleased() 和 keyTyped()，
// 可以在用户按下、释放或键入键盘键时执行相应的操作。因此，
// Mpanel 类可以用于创建具有交互性的用户界面，通过监听键盘事件来响应用户的输入。
    
    ImageIcon title =  new ImageIcon("title.jpg"); //创建一个ImageIcon对象，用于加载名为"title.jpg"的图片。
    ImageIcon body =  new ImageIcon("body.png");
    ImageIcon up =  new ImageIcon("up.png");
    ImageIcon down =  new ImageIcon("down.png");
    ImageIcon left =  new ImageIcon("left.png");
    ImageIcon right =  new ImageIcon("right.png");
    ImageIcon food =  new ImageIcon("food.png");
    ImageIcon poison =  new ImageIcon("poison.png");
    int foodx; //食物
    int foody;
    int poisonx; //毒物
    int poisony;
    Random rand = new Random(); //Random 类是 Java 中的一个随机数生成器类，它可以生成伪随机数序列。
    int len = 3; //定义蛇的初始长度s
    int score = 0; //定义蛇的分数
    int[] snakex = new int[750];  //用来存放蛇头及其蛇身的位置
    int[] snakey = new int[750]; 
    String dir = "R"; //蛇的初始方向，有：R , L , U ,D
    boolean isStarted = false;  //判断游戏是否开启
    boolean isFailed = false; //判断游戏是否结束
    Timer timer = new Timer(100, this);
   //  这行代码创建了一个名为 timer 的 Timer 对象，它在每 100 毫秒触发一次。
   //  Timer 构造函数的第一个参数表示计时器的间隔时间，以毫秒为单位。在这里，间隔时间被设置为 100 毫秒。
   //  构造函数的第二个参数是一个 ActionListener 对象，用于指定计时器触发时要执行的操作。
   // 这里使用 this 关键字作为第二个参数，
   // 表示该计时器将触发当前对象（通常是实现了 ActionListener 接口的对象）中的 actionPerformed() 方法。
   //  因此，当 timer 被启动时，每隔 100 毫秒就会触发一次 actionPerformed() 方法。
   // 在该方法中，可以编写需要周期性执行的代码。
   
    public Mpanel(){ //Mpanel类的构造函数，用于创建Mpanel对象。
        initSnake();  //初始化蛇
        this.setFocusable(true); //使当前组件可以获得焦点，即可以接收用户的输入事件。
        this.addKeyListener(this);//通过这种方式，程序就可以响应用户的键盘输入，实现一些交互功能。
        timer.start(); // 是一个方法调用，它用于启动一个计时器对象。
    }

    public void initSnake(){  //蛇的初始化
        len = 3;  //蛇的初始长度
        dir = "R"; 
        score = 0; 
        snakex[0] = 100;   //蛇头的位置
        snakey[0] = 100;

        snakex[1] = 75;   //蛇身的第一个位置
        snakey[1] = 100;

        snakex[2] = 50;   //蛇身的第二个位置
        snakey[2] = 100;
        
        foodx = 25 + 25 * rand.nextInt(34);//  rand.nextInt(34) 生成0-33之间的随机整数
        foody = 75 + 25 * rand.nextInt(24);

        poisonx = 25 + 25 * rand.nextInt(34);//  rand.nextInt(34) 生成0-33之间的随机整数
        poisony = 75 + 25 * rand.nextInt(24);

    }
    public void paintComponent(Graphics g){ // 重写JPanel类中的paintComponent方法，用于绘制面板。

         super.paintComponent(g); //调用JPanel类的paintComponent方法，清除面板并准备绘制新的内容。
         this.setBackground(Color.WHITE);//设置面板的背景颜色为绿色。
         title.paintIcon(this, g, 25, 11);//在面板上绘制名为"title.jpg"的图片，位置为(25,11)。
         //其中，this表示当前的Mpanel对象,为要绘制图标的组件。g表示系统自动生成的Graphics对象，(25, 11)表示图标的左上角在Mpanel中的坐标。
         g.fillRect(25, 75, 850, 600);//在Mpanel面板上绘制一个实心矩形，起始点坐标为(25, 75)，宽度为850，高度为600。
         g.setColor(Color.ORANGE);
         g.setFont(new Font("arial", Font.BOLD, 15));
         g.drawString("Len:" + len, 750, 35); //显示蛇的长度
         g.drawString("Score:" + score, 750, 50); //显示蛇的分数
         if( dir == "R" ){  //控制蛇头方向
            right.paintIcon(this, g, snakex[0], snakey[0]);
         }else if( dir == "L" ){
            left.paintIcon(this, g, snakex[0], snakey[0]);
         }else if( dir == "U" ){
            up.paintIcon(this, g, snakex[0], snakey[0]);
         }else
            down.paintIcon(this, g, snakex[0], snakey[0]);
         //  body.paintIcon(this, g, 75, 100);
         //  body.paintIcon(this, g, 50, 100);

         for( int i = 1; i < len; i++){  //绘制蛇身
            body.paintIcon(this, g, snakex[i], snakey[i]);
         }
         
         food.paintIcon(this, g, foodx, foody);
         poison.paintIcon(this, g, poisonx, poisony);

         if(isStarted == false){  //如果游戏未开始
            g.setColor(Color.WHITE);//设置画笔的颜色为白色（Color.WHITE）。在绘制图形或文字时，使用该画笔绘制的图形或文字颜色就会变成白色。
            g.setFont(new Font("arial", Font.BOLD, 60));//设置字体的样式和大小。具体来说，它创建了一个名为 "arial"、加粗（Font.BOLD）且大小为 60 的字体，并将该字体设置为画笔 g 的当前字体。
            //这意味着在接下来的绘图操作中，使用该画笔绘制的文字将会采用这种字体的样式和大小。
            g.drawString("Press Space to Start", 200, 300); //在屏幕上显示一段文字，文字内容为“Press Space to Start”，并且该文字的起始位置在屏幕的 (200, 300) 坐标处。
         }

         if(isFailed)  //如果游戏失败
         {
            g.setColor(Color.RED);
            g.setFont(new Font("arial", Font.BOLD, 40));
            g.drawString("Failed: Press Space to Restart", 200, 300);
         }
     }

      @Override
      public void keyPressed(KeyEvent e) {
          int keyCode = e.getKeyCode();//KeyEvent 类的 getKeyCode() 方法返回被按下的键的键码。
          if(keyCode == KeyEvent.VK_SPACE){  //KeyEvent 类的 VK_SPACE 常量表示空格键的键码
                if(isFailed){
                    isFailed = false;
                    initSnake();  
                }else {
                  isStarted = !isStarted;
                }

                repaint();//按下空格键时重新绘制应用程序的界面。
          }else if(keyCode == KeyEvent.VK_LEFT){  //设置蛇移动方向
                dir = "L";
          }else if(keyCode == KeyEvent.VK_RIGHT){
                dir = "R";
          }else if(keyCode == KeyEvent.VK_UP){
                dir = "U";
          }else if(keyCode == KeyEvent.VK_DOWN){
                dir = "D";
          }
      }
      // @Override 是一个 Java 注解，用于指示被注解的方法是覆盖（重写）了父类中的同名方法。
      

      @Override
      public void keyReleased(KeyEvent e) {
       
      }

      @Override
      public void keyTyped(KeyEvent e) {
        
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         if(isStarted && !isFailed){
            //控制蛇头移动
            if(dir == "R") {               
               if(snakex[0] == 850) { // 检查蛇头是否超出了面板的右边界。超出结束游戏
                  isFailed = true; 
               }else{
                  for(int i = len - 1; i > 0 ; i--){ //将蛇的身体向前移动一格。
                     snakex[i] = snakex[i - 1];
                     snakey[i] = snakey[i - 1];
                  }
                  snakex[0] = snakex[0] + 25;
               }
            }else if(dir == "L") {
               if(snakex[0] == 25){
                  isFailed = true; 
               }else{
                  for(int i = len - 1; i > 0 ; i--){ //将蛇的身体向前移动一格。
                     snakex[i] = snakex[i - 1];
                     snakey[i] = snakey[i - 1];
                  }
                  snakex[0] = snakex[0] - 25;
               }
            }else if(dir == "U") {
               if(snakey[0] == 75){
                  isFailed = true; 
               }else{
                  for(int i = len - 1; i > 0 ; i--){ //将蛇的身体向前移动一格。
                     snakex[i] = snakex[i - 1];
                     snakey[i] = snakey[i - 1];
                  }
                  snakey[0] = snakey[0] - 25;
               }
            }else if(dir == "D") {  
               if(snakey[0] == 650){
                   isFailed = true;
               }else{
                  for(int i = len - 1; i > 0 ; i--){ //将蛇的身体向前移动一格。
                     snakex[i] = snakex[i - 1];
                     snakey[i] = snakey[i - 1];
                  }
                  snakey[0] = snakey[0] + 25;
               }
            } 
            if(snakex[0] == foodx && snakey[0] == foody){  //如果蛇吃了食物
               len++;
               score++;
               foodx = 25 + 25 * rand.nextInt(34);
               foody = 75 + 25 * rand.nextInt(24);
               timer.setDelay(timer.getDelay() - 10); //将计时器的间隔时间减少 10 毫秒。
            }
            if(snakex[0] ==  poisonx && snakey[0] ==  poisony){  //如果蛇吃了毒物
               len--;
               score--;
               poisonx = 25 + 25 * rand.nextInt(34);
               poisony = 75 + 25 * rand.nextInt(24);
               timer.setDelay(timer.getDelay() + 10); 
            }
            for(int i = 1; i < len; i++){
                if(snakex[i] == snakex[0] && snakey[i] == snakey[0]){
                     isFailed = true;
                }
            }
            if(len == 1){
                isFailed = true;
            }
            repaint(); //调用 repaint() 方法，以便在蛇的位置更新后重新绘制应用程序的界面。
         }
         timer.start(); 
         //调用 timer.start() 方法，以便在处理完当前事件后继续触发计时器对象。
         //此时，计时器将按照指定的时间间隔再次触发 actionPerformed() 方法，从而实现连续的蛇移动效果。
      }
}
