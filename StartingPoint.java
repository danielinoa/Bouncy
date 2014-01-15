import java.applet.Applet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**This class is my starting point, my "main" class, its where most of the attributes of the game will take place. 
 * For this game i will be using a java applet, although java applets are mostly used to to carry out java programs 
 * to a web browser, i used an applet because it making  this game much easier to make.
 * This class is where the ball is created and where i create my array of platforms.
 * **/


@SuppressWarnings("serial")
public class StartingPoint extends Applet implements KeyListener,Runnable {
	Item myItem[] = new Item[1] ;
	Coins myStuff = new Coins(300,300) ;
	Ball myball ;  // creating my ball
	Platform myplatform[] = new Platform[8] ; // creates an array of platforms with a capacity of 7
	java.awt.Image myBackground ;

	/** With every applet we need an init() method and that is that gets
	 * called the first time the program is laughed,  it only gets called once.
	 * **/
	public void init() {
		setSize(800,600) ;
		addKeyListener(this);
		setFocusable(true) ; 
		myBackground = getImage(getCodeBase(),"image.png");

	}

	/**The start() method is called after the init() method and its where we set up our thread
	 * our Ball, Platform and Items.
	 *
	 * **/
	public void start() {
		myball = new Ball() ;
		for (int i=0 ; i< myplatform.length;i++){
			myplatform[i] = new Platform(i*110,400) ;
		}

		for (int i=0 ; i< myItem.length;i++){
			myItem[i] = new Coins(300,300) ;
		}
		Thread myThread = new Thread(this);
		myThread.start();

	}

	/**We used this method because our class implements runnable. Starting 
	 * the thread in the start() method causes the run() method in Runnable to 
	 * be called. This method could have been implemented inside the thread in the start()
	 * method, however i chose to make it a separate method so i don't have everything 
	 * inside the start() method.
	 * **/
	public void run() {
		while(true){
			for (int i=0 ; i<myplatform.length;i++){
				myplatform[i].update(this, myball) ;
			}
			for (int i=0 ; i< myItem.length;i++){
				myItem[i].update(this, myball) ;
			}


			myball.update(this);
			repaint();
			try {
				Thread.sleep(18); // this is what sets up the frames/rate of the applet 
				//18 fps -> Early motion picture films. "Fun Fact" 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**This method is what paints all the graphics that to the applet,
	 * including my Ball, the Platforms and all other items that is visible 
	 * in my applet.
	 * **/
	public void paint(Graphics pane) {
		super.paint(pane);
		pane.drawImage(myBackground,0,-350,this) ;
		myball.paint(pane) ;
		for (int i=0 ; i<myplatform.length;i++){
			myplatform[i].paint(pane) ;
		}
		for (int i=0 ; i< myItem.length;i++){
			myItem[i].paint(pane) ;
		}

		pane.setColor(Color.yellow) ;
		pane.fillOval(10,5, 20,20) ;
		pane.setFont(new Font("Arial", Font.BOLD,25)) ;
		pane.setColor(Color.BLACK) ;

		pane.drawString(""+Coins.cointCount,35,25) ;

	}	


	/**Because my class implements KeyListener interface, I have to use all
	 * of its method, even if they have no functionality on my program. 
	 * The only method i will use is the KeyPressed() method. This is the method that will 
	 * get the users interaction, it will detect if the user has pressed a specific key and perform 
	 * an action.
	 * **/
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case 37: myball.moveLeft();  // 37 is the ascii table value for the left arrow key. when this is 
		break ;             // pressed, we call the moveLfet() method in the Ball class and it moves
		case 39: myball.moveRight(); // the ball to the left. Same thing for case 39.
		break ;

		}	
	}
	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
