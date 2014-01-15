import java.awt.Graphics;



public class Item {
	private int x,y,dx,dy ;
	private boolean gotIt = false ;
	static int cointCount  ;

	Coins myCoins;
	public Item(int x, int y){
		this.x = x ; 
		this.y = y ;

	}

	public void update(StartingPoint sp, Ball myball){

	} 
	/**This method is one of the most important method in this class, its the method that checks if the ball has hit
	 * a platform or not, if it has then it bounces back up.It receives a Ball as its parameters and it uses the location
	 * of the Ball from the Ball class to determine if the ball has hit a platform or not  **/

	private void checkForCollision(){

	}


	/**Similar to the paint() method in the Class, this method is used to set up the platforms,
	 *it is called in paint() method in the StaringPoint class.  **/

	public void paint(Graphics pane) {


	}
}


