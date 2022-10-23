import student.micro.*;
import student.media.*;
import student.util.Random;
import java.awt.Color;
import static org.assertj.core.api.Assertions.*;

// -------------------------------------------------------------------------
/**
 *  Tests ll the methods in the SchelingSimulation
 *  Class to ensure they fulfill all requirements.
 *
 *  @author Nana Yaw Barimah Oteng 
 *  @version (200.02.28)
 */
public class SchellingSimulationTest
    extends TestCase
{
    //~ Fields ................................................................
    
    private TestImage2x2 image;
    private Test3x3 image1;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SchellingSimulationTest test object.
     */
    public SchellingSimulationTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        image = new TestImage2x2();
        image1 = new Test3x3();
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    /**
     * An example test case that tests to see if the 
     * Satisfaction threshold is the preferred value
     */
    public void testGetSatisfactionThreshold()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        double x = image.getSatisfactionThreshold();
        
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        assertThat(x).isEqualTo(0.3, within(0.0001));

    }
    
    /**
     * An example test case that tests to see if the 
     * Satisfaction threshold is set 
     * to the preferred value
     */
    public void testSetSatisfactionThreshold()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        double value = 0.7;
        image.setSatisfactionThreshold(value);
        double x = image.getSatisfactionThreshold();
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        assertThat(x).isEqualTo(0.7, within(0.0001));

    }
    
    /**
     * An example test case that tests to see if the 
     * RedLine is the preferred value
     */
    public void testGetRedLine()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        int x = image.getRedLine();
        
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        assertThat(x).isEqualTo(0);
    }
    
    /**
     * An example test case that tests to see if the 
     * RedLine is set to the preferred value
     */
    public void testSetRedLine()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        
        // 2. Call the method to test
        int value = 1;
        image.setRedLine(value);
        int x = image.getRedLine();
        // 3. Check expected behavior
        
        // The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);

        assertThat(x).isEqualTo(1);

    }
    
    /**
     * An example test case that tests to see if 
     * populate method sets all pixels to blue or orange
     * if all y values are greater than Redline.
     */
    public void testPopulate()
    {
        // 1. initial conditions are already provided in setUp(),
        //so there's nothing to do here.
        
        
               
        //Random generator = Random.generator();
        
        Random.setNextDoubles(0.15, 0.25, 0.5, 0.8);
        
        // 2. Call the method to test
        // 3. Check expected behavior
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        image.populate(0.3, 0.4);
        
        /*double x = generator.nextDouble();
        double y = generator.nextDouble();
        double z = generator.nextDouble();
        double a = generator.nextDouble();*/
        
        
        
        
        
        
        //The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getColor()).isEqualTo(Color.BLUE);
        assertThat(image.getPixel(1, 0).getColor()).isEqualTo(Color.BLUE);
        assertThat(image.getPixel(0, 1).getColor()).isEqualTo(Color.ORANGE);
        //assertThat(image.getPixel(1, 1).getColor()).isEqualTo(Color.WHITE);
        
    }
    
    /**
     * An example test case that tests to see if 
     * populate method does not set pixels to orange 
     * when they are above the redline.
     */
    public void testPopulateAboveRedline()
    {
        // 1. initial conditions are already provided in setUp(),
        //so there's nothing to do here.
        
        
               
        //Random generator = Random.generator();
        
        Random.setNextDoubles(0.5, 0.25, 0.5, 0.8);
        
        // 2. Call the method to test
        // 3. Check expected behavior
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        
        image.setRedLine(1);
        image.populate(0.3, 0.4);
        
        /*double x = generator.nextDouble();
        double y = generator.nextDouble();
        double z = generator.nextDouble();
        double a = generator.nextDouble();*/
        
        
        
        
        
        
        //The test image is so small, we can check individual pixels
        //assertThat(image.getPixel(0, 0).getRed()).isEqualTo(255);
        //assertThat(image.getPixel(0, 0).getGreen()).isEqualTo(100);
        //assertThat(image.getPixel(0, 0).getBlue()).isEqualTo(100);
        assertThat(image.getPixel(0, 0).getColor()).isEqualTo(Color.WHITE);
        assertThat(image.getPixel(1, 0).getColor()).isEqualTo(Color.BLUE);
        assertThat(image.getPixel(0, 1).getColor()).isEqualTo(Color.ORANGE);
        assertThat(image.getPixel(1, 1).getColor()).isEqualTo(Color.WHITE);
        
    }
    
    /**
     * An example test case that tests to see if 
     * two pixels are the same color.
     */
    public void testAreSameColor()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 0);
        Pixel p2 = image.getPixel(0, 1);
        p1.setColor(Color.BLUE);
        p2.setColor(Color.BLUE);
         
        
        image.areSameColor(p1, p2);
        
    
        assertThat(image.areSameColor(p1, p2)).isEqualTo(true);
    }
    
    /**
     * An example test case that tests to see if
     * the method returns "false" if two pixels
     * two pixels are not the same color.
     */
    public void testAreSameColorFalse()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 0);
        Pixel p2 = image.getPixel(0, 1);
        p1.setColor(Color.BLUE);
        p2.setColor(Color.WHITE);
         
        
        image.areSameColor(p1, p2);
        
    
        assertThat(image.areSameColor(p1, p2)).isEqualTo(false);
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is white.
     */
    public void testIsEmpty()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        p1.setColor(Color.WHITE);

         
        image.isEmpty(p1);
        
    
        assertThat(image.isEmpty(p1)).isEqualTo(true);
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is white.
     */
    public void testIsEmptyFalse()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        p1.setColor(Color.ORANGE);

         
        image.isEmpty(p1);
        
    
        assertThat(image.isEmpty(p1)).isEqualTo(false);
    }
    
    /**
     * An example test case that tests to see if 
     * the method returns false when a orange cell 
     * is not surrounded by a number of 
     * cells like it, that meets the threshold.
     */
    public void testIsSatisfiedOrangeUnsatisfied()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        Color color = Color.ORANGE;
        p1.setColor(color);
        
        Pixel p2 = image.getPixel(0, 0);
        Color color1 = Color.BLUE;
        p2.setColor(color1);
        
        Pixel p3 = image.getPixel(1, 0);
        Color color2 = Color.BLUE;
        p3.setColor(color2);
        
        Pixel p4 = image.getPixel(1, 1);
        Color color3 = Color.BLUE;
        p4.setColor(color3);
        
        boolean b2 = image.isSatisfied(p1, color);
        
        
        assertThat(b2).isEqualTo(false);
    }
    
    /**
     * An example test case that tests to see if 
     * the method returns false when a blue cell 
     * is not surrounded by a number of 
     * cells like it, that meets the threshold.
     */
    public void testIsSatisfiedBlueUnsatisfied()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        Color color = Color.BLUE;
        p1.setColor(color);
        
        Pixel p2 = image.getPixel(0, 0);
        Color color1 = Color.ORANGE;
        p2.setColor(color1);
        
        Pixel p3 = image.getPixel(1, 0);
        Color color2 = Color.ORANGE;
        p3.setColor(color2);
        
        Pixel p4 = image.getPixel(1, 1);
        Color color3 = Color.ORANGE;
        p4.setColor(color3);
        
        boolean b2 = image.isSatisfied(p1, color);
        
        
        assertThat(b2).isEqualTo(false);
    }
    
    /**
     * An example test case that tests to see if 
     * the method returns true when an orange cell 
     * is surrounded by a number of 
     * cells like it, that meets the threshold.
     */
    public void testIsSatisfiedOrangeSatisfied()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        Color color = Color.ORANGE;
        p1.setColor(color);
        
        Pixel p2 = image.getPixel(0, 0);
        Color color1 = Color.ORANGE;
        p2.setColor(color1);
        
        Pixel p3 = image.getPixel(1, 0);
        Color color2 = Color.ORANGE;
        p3.setColor(color2);
        
        Pixel p4 = image.getPixel(1, 1);
        Color color3 = Color.BLUE;
        p4.setColor(color3);
        
        boolean b2 = image.isSatisfied(p1, color);
        
        
        assertThat(b2).isEqualTo(true);
 
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is satisfield when there are no agents
     * around it.
     */
    public void testIsSatisfiedNoAgents()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
            
        Pixel p1 = image.getPixel(0, 1);
        Color color = Color.ORANGE;
        p1.setColor(color);
        
        Pixel p2 = image.getPixel(0, 0);
        Color color1 = Color.WHITE;
        p2.setColor(color1);
        
        Pixel p3 = image.getPixel(1, 0);
        Color color2 = Color.WHITE;
        p3.setColor(color2);
        
        Pixel p4 = image.getPixel(1, 1);
        Color color3 = Color.WHITE;
        p4.setColor(color3);
        
        boolean b2 = image.isSatisfied(p1, color);
        
        
        assertThat(b2).isEqualTo(true);
 
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is moved to an empty cell, if it's
     * satisfies the threshold.
     */
    public void testMaybeRelocate()
    {
        // Initial setup creates a 2x2 simulation

        Pixel p1 = image1.getPixel(0, 0);
        Color color = Color.BLUE;
        p1.setColor(color);
        
        Pixel p2 = image1.getPixel(1, 2);
        Color color1 = Color.ORANGE;
        p2.setColor(color1);
        
        Pixel p3 = image1.getPixel(1, 1);
        Color color2 = Color.ORANGE;
        p3.setColor(color2);
        
        Pixel p4 = image1.getPixel(2, 1);
        Color color3 = Color.BLUE;
        p4.setColor(color3);

        Pixel p5 = image1.getPixel(2, 2);
        Color color4 = Color.WHITE;
        p5.setColor(color4);
        
        
        
        Random.setNextInts(2, 2);
        
        boolean didMove = image1.maybeRelocate(p1); 
        
        // I want maybeRelocate() to choose (1, 1) as the destination
        

        // Assume (1, 1) is what it really selected, and write expectations
        // for that
        assertThat(didMove).isTrue();
        assertThat(p1.getColor()).isEqualTo(Color.WHITE);
        assertThat(p5.getColor()).isEqualTo(Color.BLUE);
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is not moved to an empty cell, if it's
     * does not satisfy the threshold.
     */
    public void testMaybeRelocateBelowThreshold()
    {
        // Initial setup creates a 2x2 simulation
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.BLUE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.ORANGE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.ORANGE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.ORANGE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
         
        Random.setNextInts(2, 2);
        
        System.out.println(image1.getWidth());
        System.out.println(image1.getHeight());

        

        boolean didMove = image1.maybeRelocate(p1); 

        
        //assertThat(x).isEqualTo(2);
        //assertThat(y).isEqualTo(2);
        assertThat(didMove).isFalse();
        assertThat(p1.getColor()).isEqualTo(Color.BLUE);
        assertThat(p5.getColor()).isEqualTo(Color.WHITE);
    }
    
    /**
     * An example test case that tests to see if 
     * an orange cell is not moved to an empty cell
     * above the Redline.
     */
    public void testMaybeRelocateOrangeAboveRedline()
    {
        // Initial setup creates a 2x2 simulation
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.ORANGE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.BLUE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.BLUE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.BLUE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
         
        Random.setNextInts(2, 2);
        
        image1.setRedLine(3);
        boolean didMove = image1.maybeRelocate(p1); 

        
        //assertThat(x).isEqualTo(2);
        //assertThat(y).isEqualTo(2);
        assertThat(didMove).isFalse();
        assertThat(p1.getColor()).isEqualTo(Color.ORANGE);
        assertThat(p5.getColor()).isEqualTo(Color.WHITE);
    }
    
    /**
     * An example test case that tests to see if 
     * an orange cell is moved to an empty cell, if it's
     * satisfies the threshold and is below the Redline.
     */
    public void testMaybeRelocateOrangebelowRedline()
    {
        // Initial setup creates a 2x2 simulation
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.ORANGE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.ORANGE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.BLUE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.BLUE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
         
        Random.setNextInts(2, 2);
        
        boolean didMove = image1.maybeRelocate(p1); 

        
        //assertThat(x).isEqualTo(2);
        //assertThat(y).isEqualTo(2);
        assertThat(didMove).isTrue();
        assertThat(p1.getColor()).isEqualTo(Color.WHITE);
        assertThat(p5.getColor()).isEqualTo(Color.ORANGE);
    }
    
    /**
     * An example test case that tests to see if 
     * a cell is moved if the new location is empty 
     * and meets the satisfaction threshold.
     * 
     * 
     */
    public void testCycleAgents()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.BLUE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.BLUE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.ORANGE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.ORANGE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
        
        Random.setNextInts(2, 2);
        
        
        
        int x = image1.cycleAgents();
        
    
        assertThat(x).isEqualTo(1);
        

    }
    
    /**
     * An example test case that tests to see if 
     * a cell is not moved if the satisfaction
     * threshold is not met by the new cell.
     */
    public void testCycleAgentsBelowThreshold()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.BLUE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.ORANGE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.ORANGE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.ORANGE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
         
        Random.setNextInts(2, 2);
        
        
        
        int x = image1.cycleAgents();
        
    
        assertThat(x).isEqualTo(0);
        

    }
    
    /**
     * An example test case that tests to see if 
     * a cell is not moved if the new cell is not 
     * empty.
     */
    public void testCycleAgentsNotEmpty()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.BLUE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.ORANGE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.ORANGE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.ORANGE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.ORANGE);
         
        Random.setNextInts(2, 2);
        
        
        
        int x = image1.cycleAgents();
        
    
        assertThat(x).isEqualTo(0);
        

    }
    
    /**
     * An example test case that tests to see if 
     * a cell is not moved if the maybeRelocate function
     * returns false..
     */
    public void testCycleAgentsNotRelocate()
    {
        // 1. initial conditions are already provided in setUp(),
        //    so there's nothing to do here.
        Pixel p1 = image1.getPixel(0, 0);
        p1.setColor(Color.ORANGE);
        
        Pixel p2 = image1.getPixel(2, 1);
        p2.setColor(Color.BLUE);
        
        Pixel p3 = image1.getPixel(1, 1);
        p3.setColor(Color.BLUE);
        
        Pixel p4 = image1.getPixel(1, 2);
        p4.setColor(Color.BLUE);
        
        Pixel p5 = image1.getPixel(2, 2);
        p5.setColor(Color.WHITE);
         
        Random.setNextInts(2, 2);
        
        
        
        int x = image1.cycleAgents();
        
    
        assertThat(x).isEqualTo(0);

    }
}
