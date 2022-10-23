import student.media.*;
import student.util.Random;
import java.awt.Color;
//-------------------------------------------------------------------------
/**
 *  This  class models Schelling's model of segregation
 *  to group pixels in cells that meet the 
 *  satisfaction threshold.
 *
 *  @author Nana Yaw Barimah Oteng
 *  @version (200.02.28)
 */
public class SchellingSimulation
    extends Picture


{
    //~ Fields ................................................................
    private double satisfactionThreshold;
    private int redLine;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created SchellingSimulation object.
     * 
     * satisfactionThreshold = A field holding a double value 
     * that indicates the satisfaction 
     * threshold for all agents in the simulation
     * 
     * redline = An integer value representing a 
     * horizontal dividing line (a y-coordinate) indicating 
     * a neighborhood boundary. Orange  pixels 
     * (representing O agents) are restricted 
     * to y coordinates greater than or 
     * equal to this value.
     * @param width sets the width of the picture
     * @param height sets the height of the picture
     */
    public SchellingSimulation(int width, int height)
    {
        super(width, height);
        this.satisfactionThreshold = 0.3;
        this.redLine = 0;
    }


    //~ Methods ...............................................................
    /**
     * A getter method that returns the satisfaction
     * threshold (a double).
     * @return returns the value of the satisfaction
     * threshold.
     */
    public double getSatisfactionThreshold()
    {
        return satisfactionThreshold;
    }
    
    /**
     * A setter method that takes a double
     * parameter and changes the 
     * satisfaction threshold to the specified value.
     * @param value intitializes
     * the satisfaction threshold.
     */
    public void setSatisfactionThreshold(double value)
    {
        satisfactionThreshold = value;
    }
    
    /**
     * A getter method that returns the
     * redline value (an int).
     * @return returns the value of the 
     * RedLine.
     */
    public int getRedLine()
    {
        return redLine;
    }
    
    /**
     * A setter method that takes a double
     * parameter and changes the 
     * satisfaction threshold to the specified value.
     * @param value intitializes
     * the redLine value.
     */
    public void setRedLine(int value)
    {
        redLine = value;
    }
    
    /**
     * Takes two double parameters between 0.0 - 1.0 that 
     * represent percentages. This method will "paint" 
     * the image with a randomized collection of blue and
     * orange pixels. The first parameter represents the 
     * probabilty of any pixel in the image being set to 
     * blue (representing an X agent). The second represents 
     * the probability of any pixel in the image (below the redline) 
     * being set to orange (representing an O agent). 
     * Other pixels will be left alone 
     * (empty, represented by  white ).
     * @param bluePercentage is the percentage probability of a pixel 
     * being set to blue.
     * @param orangePercentage is the percentage probability of a pixel
     * below the RedLine being set to orange.
     */
    public void populate(double bluePercentage, double orangePercentage)
    {
        Random generator = Random.generator();
        for (Pixel pix : this.getPixels())
        {
            double value = generator.nextDouble();
            System.out.println(value);
            if (value <= bluePercentage) 
            {
                pix.setColor(Color.BLUE);
            }
            else if (value <= (orangePercentage + bluePercentage)
                && pix.getY() >= this.redLine) 
            {
                pix.setColor(Color.ORANGE);
            }
            else
            {
                pix.setColor(Color.WHITE);
            } 
        }

    }
    
    /**
     * Takes two Pixel objects and returns a 
     * boolean value indicating whether 
     * the two pixels have the same color.
     * @param pixel1 is the first pixel 
     * object being compared to pixel2 to see
     * if they are the same color.
     * @param pixel2 is the second pixel 
     * object being compared to pixel1 to see
     * if they are the same color.
     * @return returns true if the pixels are the same
     * color and returns false if they are not the same 
     * color.
     */
    public boolean areSameColor(Pixel pixel1, Pixel pixel2)
    {
        Color p1 = pixel1.getColor();
        Color p2 = pixel2.getColor();
        
        return p1.equals(p2);

    }
    
    /**
     * Takes one Pixel object and returns true 
     * if its color is Color.WHITE, representing 
     * an empty location.
     * @return returns true if the color of a cell
     * is white, and returns false if the cell isn't 
     * white.
     * 
     * @param pixel1 is a pixel object that is checked
     * to see if it's white.
     */
    public boolean isEmpty(Pixel pixel1)
    {
        Color p1 = pixel1.getColor();
        
        return p1.equals(Color.WHITE);
    }
    
    /**
     * Takes one pixel object and a color value, 
     * and returns a boolean result indicating whether 
     * an agent of the specified Color would be satisfied
     * at the given Pixel location. It should return true 
     * if there are no neighboring agents, or if the 
     * proportion of neighboring agents the same color as 
     * the parameter meets or exceeds the satisfaction threshold.
     * @return returns true if a pixel is satisfied at a new location
     * and returns false if it wouldn't be satisfied.
     * @param pixel1 is the pixel being checked for satisfaction
     * @param color is the color of the pixel being checked.
     */
    public boolean isSatisfied(Pixel pixel1, Color color)
    {   
        double samecolor = 0;
        double differentcolor = 0;
        for (Pixel neighbor : pixel1.getNeighborPixels())
        {
            if (neighbor.getColor().equals(color))
            {
                samecolor++;
            }
            else if (!neighbor.getColor().equals(Color.WHITE))
            {
                differentcolor++;
            }
        }
        double proportion = samecolor / (samecolor + differentcolor);
        System.out.print(proportion);
        
        if ((samecolor + differentcolor) == 0.0)
        {
            return true;
        }
        return proportion >= this.getSatisfactionThreshold();
    }
    
    /**
     * Takes one Pixel object as a parameter and 
     * returns a boolean result. This method tries to 
     * move the corresponding agent to a new pixel location. 
     * This involves picking a new random x/y location in 
     * the image (below the redline, if the current pixel 
     * is occupied by an orange agent). If the selected location 
     * is empty, and if the current agent would be satisfied at 
     * the new location, then "move" the agent by setting 
     * the new location's color to the current pixel's color 
     * and setting the current pixel's color to Color.WHITE. 
     * Otherwise, leave the current agent in place, if it 
     * cannot be moved to the selected destination. 
     * Return true if the agent is moved, 
     * or false if the attempt to move fails.
     * @param pixel1 this is the pixel object being checked to
     * see if it's satisfied by the new location
     * @return returns true if it is satisfied by the new
     * location. Otherwise, it returns false.
     */
    public boolean maybeRelocate(Pixel pixel1)
    {
        Random generator = Random.generator(); 
        int xCoordValue = generator.nextInt(this.getWidth());
        int yCoordValue = generator.nextInt(this.getHeight());
        
        Pixel newPixel = this.getPixel(xCoordValue, yCoordValue);
        if (pixel1.getColor().equals(Color.ORANGE) &&
            yCoordValue <= this.redLine)
        {
            return false;          
        }
        if (isEmpty(newPixel) && isSatisfied(newPixel, pixel1.getColor()))
        {
            newPixel.setColor(pixel1.getColor());
            pixel1.setColor(Color.WHITE);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Takes no parameters and returns an integer result. 
     * This method uses a loop over all pixels, checking 
     * each pixel in turn. If the pixel is empty, 
     * leave it alone. If it is occupied, check to see if 
     * the agent there is satisfied--if so, leave the agent 
     * alone. Otherwise, attempt to relocate it to a new 
     * position (which could succeed or fail, as described 
     * under maybeRelocate(). The method returns the total 
     * number of successful moves after processing all pixels. 
     * @return returns the total number of succesful moves 
     * after all pixels have been ran through.
     * 
     */
    public int cycleAgents()
    {
        int movecount = 0;
        
        for (Pixel pix: this.getPixels())
        {
            if (!(isEmpty(pix) || isSatisfied(pix, pix.getColor()))
                && maybeRelocate(pix))
            {
                movecount++;
            }
        }
        return movecount;
    }
}
