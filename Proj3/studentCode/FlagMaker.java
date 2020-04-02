package studentCode;
import java.awt.Color;

import cmsc131_GridTools.Grid_3x5;


public class FlagMaker {
	private static Color AZURE = new Color(0,127,255);
	private static Color OLIVE = new Color(169, 208, 70);

	//You should read and get comfortable with these provided methodS
	//  as your first step - understand what they do and why.

	//Think about how you can write your "draw" methods and some other 
	//  helper methods as you work on the remaining flags.




	private static void helperField(Grid_3x5 grid, Color theColor) {
		//We want to paint the whole flag this one color.  To do
		//  this we can iterate through each row, and within that
		//  row iterate through each column.  At each position, 
		//  we'll set the color there to the one passed in.
		//The background color of a flag is known as the field 
		//  in the world of vexillology.
		for (int row=0; row<grid.getHt(); row++) {
			for (int col=0; col<grid.getWd(); col++) {
				grid.setColor(row, col, theColor);
			}
		}
	}

	private static void drawSillyExample(Grid_3x5 grid) {
		grid.setColor(3, 3, Color.RED);
		grid.setColor(0, 2, Color.BLUE);

		grid.setColor(grid.getHt()-1, grid.getWd()-1, Color.CYAN);
		grid.setColor(grid.getHt()-2, grid.getWd()-2, Color.CYAN);
		grid.setColor(grid.getHt()-3, grid.getWd()-3, Color.CYAN);
		grid.setColor(grid.getHt()-4, grid.getWd()-4, Color.CYAN);
		//HINT: Think about how these last four instructions 
		//      could have been done utilizing a for loop.
	}

	private static void drawSultanateOfMuscat(Grid_3x5 grid) {
		//Since this is just a solid red flag, we'll call the
		//  helper we have to do the work.
		helperField(grid, Color.RED);
		helperCenterDiamond(grid,Color.WHITE);
	}





	//This is a more complex helper method that we provide
	//  it draws a diamond in the center of a grid that is 
	//  sent to it, using the specified color.
	//You might find it interesting to read the code, but
	//  you can use this helper without doing that since 
	//  you do know what it does at the abstract level.
	private static void helperCenterDiamond(Grid_3x5 grid, Color theColor) {
		//The diamond will be 2/3rds the height of the flag and centered.

		int anchorRow = grid.getHt()/3 * 3/2;
		int anchorCol = grid.getWd()/2;

		int totalRadius=grid.getHt()/3;

		for (int currRadius=0; currRadius<totalRadius; currRadius++) {
			int sizeOfSegment = totalRadius-currRadius;
			for (int distFromAnchor=0; distFromAnchor<sizeOfSegment; distFromAnchor++) {
				grid.setColor(anchorRow-currRadius, anchorCol-distFromAnchor, theColor);
				grid.setColor(anchorRow-currRadius, anchorCol+distFromAnchor, theColor);
				grid.setColor(anchorRow+currRadius, anchorCol-distFromAnchor, theColor);
				grid.setColor(anchorRow+currRadius, anchorCol+distFromAnchor, theColor);
			}
		}
	}




	/* Draws a single flag as indicated by the second parameter
	 * into the grid passed as the first parameter.  We provide 
	 * the starter code here that will correctly call the helper
	 * to draw the silly example flag and the flag of the Sultanate 
	 * Of Muscat.  
	 * 
	 * As you work on the flag for each task, you'll need to 
	 * (a) modify this method to add the option, and 
	 * (b) write the helper method(s) that it calls.
	 */
	public static void drawFlag(Grid_3x5 grid, int flagCode) {
		//Our silly example flag just needs to have flagCode as 0
		if (flagCode==0) {
			drawSillyExample(grid);


		}

		
		else if (flagCode==1   &&   grid.getHt()%2==1   &&   grid.getHt()>=7) {
			drawSultanateOfMuscat(grid);
		}


		else if (flagCode ==2 && grid.getHt()%2!=0 ) 
		{
			drawRif(grid);
		}

		else if (flagCode == 3 && grid.getHt()%2==0) 
		{
			drawCanton(grid);

		}
		else if (flagCode == 4 && grid.getHt()%2==0) 
		{
			drawPargue(grid);
		}
		else if (flagCode ==5 && grid.getHt()%2 !=0 ) 
		{
			drawSanta(grid);
			helperCenterDiamond(grid, OLIVE);
		}
		else if(flagCode ==6 && grid.getWd()%10==0)  
		{
			drawNorfolk(grid);
		}
		else if(flagCode ==7 && grid.getWd()%10==0)  
		{
			drawVincent(grid);
		}
		else if (flagCode == 8 && grid.getHt()%2!=0 ) 
		{
			drawGlassville(grid);
		}



		else{
			drawError(grid);
		}
	}



	
	private static void drawError(Grid_3x5 grid){
		
		helperField(grid,Color.WHITE);
		grid.setColor(0, 0, Color.RED);
		grid.setColor(0, grid.getWd()-1, Color.GREEN);
		grid.setColor(grid.getHt()-1, grid.getWd()-1, Color.ORANGE);
		grid.setColor(grid.getHt()-1, 0, Color.BLUE);


	}





	private static void drawRif(Grid_3x5 grid) {



		helperField(grid, Color.RED);
		helperCenterDiamond(grid, Color.WHITE);

	}


	private static void drawCanton(Grid_3x5 grid) {

		int half=(grid.getHt())/2;

		for (int row=0; row<grid.getHt(); row++) {
			if( row < half )
			{
				for (int col=0; col<grid.getWd(); col++) {
					grid.setColor(row, col, Color.PINK);
				}
			}
			else  
			{
				for (int col=0; col<grid.getWd(); col++) {	
					grid.setColor(row, col, Color.CYAN);
				}
			}	
		}

	}


	private static void drawPargue(Grid_3x5 grid) {

		int half=(grid.getHt())/2;
		helperField(grid,Color.RED);
		for (int row=0; row<half; row++) {
			for (int col=0; col<grid.getWd(); col++) 
				grid.setColor(row, col, Color.YELLOW);
		}

	}


	private static void drawSanta(Grid_3x5 grid) {
		int three=(grid.getHt())/3;
		int oneF=three*2;

		helperField(grid,Color.RED);
		for (int row=three; row<oneF; row++) {
			for (int col=0; col<grid.getWd(); col++) 
				grid.setColor(row, col, Color.WHITE);
		}
		helperCenterDiamond(grid, OLIVE);

	}


	private static void  drawNorfolk(Grid_3x5 grid) {
		helperField(grid,Color.WHITE);
		int wid=3*(grid.getWd())/10;
		
		for (int row=0; row<grid.getHt(); row++) {
			for (int col=0; col<wid; col++) 
				grid.setColor(row, col, Color.GREEN);
		}
		grid.setColor(row, col, Color.GREEN);

		for (int row=0; row<grid.getHt(); row++) {
			for(int col=grid.getWd()-wid;col<grid.getWd();col++) {
				grid.setColor(row, col, Color.GREEN);
			}
		}

	}

	private static void drawVincent(Grid_3x5 grid) {
		helperField(grid,Color.YELLOW);
		int wid=3*(grid.getWd())/10;
		int wid1 = (4*(grid.getWd()-1)/10);
		int newWid = wid+wid1;
		for (int row=0; row<grid.getHt(); row++) {
			for (int col=0; col<wid; col++) 
				grid.setColor(row, col, Color.BLUE);
		}
		for (int row=0; row<grid.getHt(); row++) {
			for (int col=grid.getWd()-1; col>newWid; col--) 
				grid.setColor(row, col, Color.GREEN);
		}

	}

	private static void drawGlassville(Grid_3x5 grid) {

		helperField(grid,Color.GREEN);

		int h=(grid.getHt())-1;
		int half=(grid.getHt())/2;
		int wid=(grid.getWd()-1)/3;
		int c=0;
		int mo=(grid.getHt())%2;

		// left top triangle
		for(int row=0;row<=half;row++)
		{
			for(int col=0;col<=row;col++)
				grid.setColor(row, col, Color.BLACK);
			c++;
		}
		//left bottom triangle
		int u=0;
		for(int row=half;row<grid.getHt();row++)
		{
			for(int col2=half-u;col2>=0;col2--)
			{
				grid.setColor(row, col2, Color.BLACK);
			}
			u++;
		}
	
		
		
		//right triangle

		int wide=grid.getWd()-1;
		int wid1=grid.getWd();
		int eq=((grid.getHt()/2) +1);


		for(int row=wide;row >= wid1-eq;row--)
		{
			for(int col=(wide-row); col <= grid.getHt() - (wide-row)-1 ; col++)
				grid.setColor(col, row, Color.BLACK);

		}
	}












}
