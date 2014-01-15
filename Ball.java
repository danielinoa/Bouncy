import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**This class is where i set up my ball and everything 
 * 
 * 
 * **/

public class Ball {
	/**the variables x and y are used for location of he ball **/
	private int x = 400;  
	private int y = 25;
	private boolean gameOver= false ;
	
	/**The variables dx and dy are used for he change in location of the ball **/
	private double dx = 0;  
	private double dy = 0; 

	/**controls how the ball bounces after it hits a platform.  **/
	private double gameDY = -90 ; 

	/**radius of the ball**/
	private int radius = 25 ; 

	/**this controls how fast the ball comes down after hitting a platform**/
	private double gravity = 15 ;   

	

	/**this is change in time, and i use it to figure out the position of the ball. in the update() method**/
	private double dt = .2 ;    
	private double xfriction = .9;


	public Ball(){

	}


	/**The next few set and get methods are the set and get methods for mostly all the variables
	 * in my class, the reason I did this is because all my variables are private in my class and this is the only way 
	 * i can use them outside my Ball class. 
	 * **/
	public double getGameDY() {
		return gameDY;
	}

	public void setGameDY(double gameDY) {
		this.gameDY = gameDY;
	}

	public int getRadius() {
		return radius;
	}

	public int getX() {

		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	//==============End of set and get methods======================//
	//==============================================================//
	//==============================================================//
	//==============================================================//
	//==============================================================//


	/**The next two moveRight(), and moveLeft() are the methods used to control the ball, 
	 * they are called in the KeyPressed() method inside the StartingPoint class. 
	 * **/
	public void moveRight() {  // moves the ball to the right
		if(dx+1 <20){
			dx +=3 ;
		}
	}

	public void moveLeft() {  // moves the ball to the left 
		if(dx-1 > -20){
			dx -=(double) 2.4 ;
		}	
	}



	/**The update method is what updates all the information of the ball, it is called in the run()
	 * method inside the StartingPoing class
	 * **/
	public void update(StartingPoint sp){
		if(x+dx > sp.getWidth()-radius){   //the following conditional statements (if, else if, else) is what keeps the ball 
			x= sp.getWidth()-radius ;      // inside our applet, when it hits the edges of the applet it bounces back
			dx= -dx ;
		} 
		else if(x+ dx <0 + radius){ 
			x = 0+radius ;
			dx = -dx ;
		}
		else{
			x+=dx ;
		}
		if(y== sp.getHeight()-radius-1)
			dx *= xfriction;
		if(Math.abs(dx)<.8){
			dx = 0 ;
		}

		if(y > sp.getHeight()-radius-1){
			y=sp.getHeight()+200 ;
			gameOver = true ;
			
		}
		else{
			dy+= gravity*dt ; //velocity   
			y += dy*dt + (1/2)*gravity*dt*dt ; //position formula, real life physics 
		}

	} 


	/**This method sets up the ball to be painted to my applet **/
	public void paint(Graphics pane) {
		pane.setColor(Color.BLUE);
		pane.fillOval(x-radius, y-radius, radius*2, radius*2) ;
		pane.setColor(Color.RED);
		
		if (gameOver){
			pane.setFont(new Font("Arial", Font.ITALIC,40)) ;
			pane.drawString("Game Over!!!", 300, 300) ;
			
		}
	}


	

}
