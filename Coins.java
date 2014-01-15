import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;


public class Coins extends Item{

	private int x,y,dx,radius ;
	private boolean gotIt = false ;
	static int cointCount= 0 ;

	public Coins(int x, int y) {
		super(x, y);
		dx = -1 ;
		radius = 20 ;

	}


	public void update(StartingPoint sp, Ball myball){
		checkForCollision(myball) ; // calls this method which checks if the ball is touching a platform 
		x+=dx ;

		if (x< 0){   //this if statement is what makes the platforms re-appear on the other side of the applet
			Random r =new Random() ;  // the reason why i have this Random r, is so the platforms will appear at 
			// random locations every time.
			y=sp.getHeight()-40 - r.nextInt(400) ;
			x=sp.getWidth() + r.nextInt(300) ;

		}

	}

	protected void checkForCollision(Ball myball){
		int ballX = myball.getX() ; // the x location of the ball
		int ballY = myball.getY() ; // the y location of the ball 
		int Ballradius = myball.getRadius() ; // the radius of the ball. 

		if(ballY >y-(2*radius) && ballY-(Ballradius*2) < y ){  // this if statement if what determines if the ball has hit 
			// hit a platform or not.

			if(ballX+(Ballradius*2)>x && ballX< x+(2*radius)){ 
				gotIt=true ;   // makes the bolean true whenever it enters this if statememt, and the cointCount is increased 
				cointCount++ ; 


			}
		}

	}



	public void paint(Graphics pane) {
		pane.setColor(Color.yellow) ;
		pane.fillOval(x,y, radius,radius) ; 
		if (gotIt){        //it the player gets the coin the coin is again repainted at some random x value in the future
			pane.fillOval(x,y, radius,radius) ;
			gotIt= !gotIt ; //resets gotIt 
			Random r = new Random() ;
			x+= r.nextInt(500)+200 ;
		}



	}


}






