import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**The platfrom class is where everything related to the platfroms will be, this class is where the platform 
 * is made, it is also where the collision detection takes place.
 * **/
public class Platform {
	/**This is the change in x and in this class it is used to make the platforms move **/
	int dx,dy ; 
	/** The next 4 variable x,y,width, and height are just the location and dimension of the platform**/
	int x, y, width, height ;

	/**this boolean determines if the ball has hit the platform or not **/
	boolean didItHit = false ; 

	public Platform(){

	}
	/**This method takes two int x and y as its parameter and i use it in the run() method in the StartingPoint 
	 * class to set up the first 7 platform in the game to be right after each other. **/
	public Platform(int x, int y){
		this.x = x ;
		this.y = y ;
		width = 100 ;
		height = 20 ;
		dx = -1 ;
		dy= -3 ;
	}
	/**Similar to the update() method in the Ball class, this method updates all the platforms. 
	 * It is called in the run() method in the StartingPoint class, it receives a parameter of a Ball "myball"
	 * This method is also where the code for the movement of the platform takes place. **/
	public void update(StartingPoint sp, Ball myball){

		if(myball.getY()-myball.getRadius()*2<0){  // this if statement gives the game a scrolling affect if the
			// ball goes beyond the frame of the applet
			y-=dy ;
			
		}
		x+=dx ; //increments x by dx every time this method is called in the
		//run() method in StartingPoing, which causes the window to have a moving affect. 

		checkForCollision(myball) ; // calls this method which checks if the ball is touching a platform 

		if (x< 0-width+50){   //this if statement is what makes the platforms re-appear on the other side of the applet
			Random r =new Random() ;  // the reason why i have this Random r, is so the platforms will appear at 
			// random locations every time.
			y=sp.getHeight()+40 - r.nextInt(300) ;
			x=sp.getWidth() + r.nextInt(200) ;

		}

	} 
	/**This method is one of the most important method in this class, its the method that checks if the ball has hit
	 * a platform or not, if it has then it bounces back up.It receives a Ball as its parameters and it uses the location
	 * of the Ball from the Ball class to determine if the ball has hit a platform or not  **/
	private void checkForCollision(Ball myball){
		int ballX = myball.getX() ; // the x location of the ball
		int ballY = myball.getY() ; // the y location of the ball 
		int radius = myball.getRadius() ; // the radious of the ball. 

		if(ballY+radius+10 > y && ballY+radius < y + height){  // this if stament if what determines if the ball has hit 
			// hit a platform or not.
			if(ballX+(radius*.5)>x && ballX-(radius*.5)< x+width){ 
				double newDY = myball.getGameDY() ;
				myball.setY(y-radius) ;
				myball.setDy(newDY) ;
				didItHit = true ;
			}
		}
	}

	/**Similar to the paint() method in the Class, this method is used to set up the platforms,
	 *it is called in paint() method in the StaringPoint class.  **/

	public void paint(Graphics pane) {

		pane.setColor(Color.cyan) ;
		if (didItHit) {                      // this if and else statement checks if the ball has hit 
			//the platform, and if it has, if changes the color of it. 
			pane.fill3DRect(x, y, width, height,true) ;	
			didItHit = !didItHit ;
		}
		else {
			pane.setColor(Color.blue);
			pane.fill3DRect(x, y, width, height,false) ; 
		}
	
	}


	
	
	//System.out.print(Coins.cointCount) ;
	
}

