/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  //Added
  public static void testKeepOnlyBlue() {
	  Picture gaul = new Picture("gaul.png");
	  gaul.explore();
	  gaul.keepOnlyBlue();
	  gaul.explore();
  }
  
  //Added
  public static void testNegate() {
	  Picture gaul = new Picture("gaul.png");
	  gaul.explore();
	  gaul.negate();
	  gaul.explore();
  }
  
  //Added
  public static void testGreyscale() {
	  Picture gaul = new Picture("gaul.png");
	  gaul.explore();
	  gaul.greyscale();
	  gaul.explore();

  }
  
  //Added
  public static void testFixUnderwater() {
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture gaul = new Picture("gaul.png");
    gaul.explore();
    gaul.mirrorVertical();
    gaul.explore();
  }
  
  //Added
  public static void testMirrorVerticalR2L()
  {
    Picture gaul = new Picture("gaul.png");
    gaul.explore();
    gaul.mirrorVerticalR2L();
    gaul.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  //Added
  public static void testMirrorArms() {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  //Added
  public static void testMirrorGull() {
	  Picture gull  = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  //Added
  public static void testMirrorHorizontal() {
	Picture gaul = new Picture("gaul.png");
	gaul.explore();
	gaul.mirrorHorizontal();
	gaul.explore();
  }
  
  //Added
  public static void testMirrorHorizontalB2T() {
	Picture gaul = new Picture("gaul.png");
	gaul.explore();
	gaul.mirrorHorizontalB2T();
	gaul.explore();
  }
  
  //Added
  public static void testMirrorDiagonal() {
	Picture gaul = new Picture("gaul.png");
    gaul.explore();
	gaul.mirrorDiagonal();
	gaul.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  //Added
  public static void testMyCollage() {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.myCollage();
	  canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  //Added
  public static void testEdgeDetection2() {
      Picture swan = new Picture("swan.jpg");
      swan.edgeDetection2(30);
      swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGreyscale();
    //testFixUnderwater();
    //testMirrorVertical();
	//testMirrorVerticalR2L();
	//testMirrorHorizontal();
	//testMirrorHorizontalB2T();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//testMyCollage();
  }
}