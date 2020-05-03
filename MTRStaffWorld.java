import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MTRStaffWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MTRStaffWorld extends GWorld
{

	static {
		GWorld.setWidth(800);
		GWorld.setHeight(600);
		GWorld.setCellSize(1);
	}

    /**
     * Constructor for objects of class MTRStaffWorld.
     * 
     */
    public MTRStaffWorld()
    {    
        
        MTRTrainee newTrainee = new MTRTrainee();        
        // initialize the fares from HangHau
        newTrainee.initalizeFareFromHangHau();
        GWorld.addOneObject( newTrainee, 271, 255 );        
        
        
        MTRManager newManager = new MTRManager();
        // initialize all the fares
        newManager.initializeAllFares();
        GWorld.addOneObject( newManager, 565, 255 );
        
        
    }
}
