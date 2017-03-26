import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.io.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  //Added
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels) {
	      for (Pixel pixelObj : rowArray) {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  
  //Added
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels) {
	      for (Pixel pixelObj : rowArray) {
	        pixelObj.setRed(255 - pixelObj.getRed());
	        pixelObj.setGreen(255 - pixelObj.getGreen());
	        pixelObj.setBlue(255 - pixelObj.getBlue());
	      }
	    }
  }
  
  
  //Added
  public void greyscale() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels) {
	      for (Pixel pixelObj : rowArray) {
	    	int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
	        pixelObj.setRed(average);
	        pixelObj.setGreen(average);
	        pixelObj.setBlue(average);
	      }
	    }
  }
  
  //Added
  public void fixUnderwater() {
    Pixel[][] pixels = this.getPixels2D();
    
    int redAverage = 0;
    int greenAverage = 0;
    int blueAverage = 0;
    int totalPixels = 0;
    
    int maxRed = 0;
    int minRed = 255;
    int maxGreen = 0;
    int minGreen = 255;
    int maxBlue = 0;
    int minBlue = 255;
    
    for (int row = 26; row < 36; row++) {
        for (int col = 178; col < 198; col++) {
            totalPixels++;
            
            Pixel myPixel = pixels[row][col];
            
            redAverage += myPixel.getRed();
            greenAverage += myPixel.getGreen();
            blueAverage += myPixel.getBlue();
            
            if (myPixel.getRed() > maxRed) {
            	maxRed = myPixel.getRed();
            }
            if (myPixel.getRed() < minRed) {
            	minRed = myPixel.getRed();
            }
            if (myPixel.getGreen() > maxGreen) {
            	maxGreen = myPixel.getGreen();
            }
            if (myPixel.getGreen() < minGreen) {
            	minGreen = myPixel.getGreen();
            }
            if (myPixel.getBlue() > maxBlue) {
            	maxBlue = myPixel.getBlue();
            }
            if (myPixel.getGreen() < minBlue) {
            	minBlue = myPixel.getBlue();
            }
            
        }
    }
    
    redAverage = redAverage / totalPixels;
    greenAverage = greenAverage / totalPixels;
    blueAverage = blueAverage / totalPixels;
    
    Color averageColor = new Color(redAverage, greenAverage, blueAverage);
    
    int redRange = (maxRed - minRed);
    int greenRange = (maxGreen - minGreen);
    int blueRange = (maxBlue - minBlue);
    
    int redDistance = redRange;
    int greenDistance = greenRange;
    int blueDistance = blueRange;
    
    double maxDistance = Math.sqrt(redDistance * redDistance +
                                   greenDistance * greenDistance +
                                   blueDistance * blueDistance);
    
    double tolerance = 1.7;
    
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
          Pixel myPixel = pixels[row][col]; 
          
          boolean closeEnough = myPixel.colorDistance(averageColor) < maxDistance * tolerance;
          if (closeEnough) {
              myPixel.setBlue(myPixel.getBlue() + 50);
          }
          else {
              myPixel.setBlue(myPixel.getBlue() - 50);
          }
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  //Added
  public void mirrorVerticalR2L() {
	Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
	Pixel rightPixel = null;
	int width = pixels[0].length;
	for (int row = 0; row < pixels.length; row++) {
	  for (int col = 0; col < width / 2; col++) {
	    leftPixel = pixels[row][width - 1 - col];
	    rightPixel = pixels[row][col];
	    rightPixel.setColor(leftPixel.getColor());
	  }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms() {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  //R155C105 -> R191C169 dupe to R224C99 -> R270C163
	  //Rdiff = 36 : Cdiff = 64
	  Pixel one = null;
	  Pixel two = null;
	  for (int i = 0; i < 36; i++) {
		  for (int j = 0; j < 64; j++) {
			  one = pixels[155 + i][105 + j];
			  two = pixels[224 + i][99 + j];
			  two.setColor(one.getColor());
		  }
	  }
	  
	  //R172C239 -> R195C294 dupe to R245C245 -> R268C300
	  //Rdiff = 23 : Cdiff = 55
	  for (int i = 0; i < 23; i++) {
		  for (int j = 0; j < 55; j++) {
			  one = pixels[172 + i][239 + j];
			  two = pixels[245 + i][245 + j];
			  two.setColor(one.getColor());
		  }
	  }
  }
  
  //Added
  public void mirrorGull() {
	  Pixel[][] pixels = this.getPixels2D();
	  
	  //R235C235 -> R325C350 dupe to R235C355 -> R325C470
	  //Rdiff = 90 : Cdiff = 115
	  Pixel one = null;
	  Pixel two = null;
	  for (int i = 0; i < 90; i++) {
		  for (int j = 0; j < 115; j++) {
			  one = pixels[235 + i][235 + j];
			  two = pixels[235 + i][355 + j];
			  two.setColor(one.getColor());
		  }
	  }
  }
  
  //Added
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int i = 0; i < height / 2; i++) {
		  for (int j = 0; j < pixels[i].length; j++) {
			  topPixel = pixels[i][j];
			  bottomPixel = pixels[height - 1 - i][j];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
//Added
  public void mirrorHorizontalB2T() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int i = 0; i < height / 2; i++) {
		  for (int j = 0; j < pixels[i].length; j++) {
			  topPixel = pixels[height - 1 - i][j];
			  bottomPixel = pixels[i][j];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  public void mirrorDiagonal() {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topRightPixel = null;
      Pixel bottomLeftPixel = null;
      int maxLength;
      if (pixels.length < pixels[0].length) {
    	  maxLength = pixels.length;
      }
      else {
    	  maxLength = pixels[0].length;
      }
      
      for (int row = 0; row < maxLength; row++) {
          for (int col = row; col < maxLength; col++) {
              topRightPixel = pixels[row][col];
              bottomLeftPixel = pixels[col][row];
              bottomLeftPixel.setColor(topRightPixel.getColor());
          }
      }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol) {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < endRow; fromRow++, toRow++) {
      for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < endCol; fromCol++, toCol++) {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    } 
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  //Added
  public void myCollage() {
      Picture flower1 = new Picture("flower1.jpg");
      this.copy2(flower1,10,20, 0, 100);
      Picture gaul = new Picture("gaul.png");
      gaul.mirrorDiagonal();
      this.copy(gaul, 50, 25);
      Picture cate = new Picture("caterpillar.jpg");
      cate.greyscale();
      this.copy(cate, 250, 480);
      this.write("mycollage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
	  Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel topPixel = null;
	    Pixel bottomPixel = null;
	    
	    Pixel[][] pixels = this.getPixels2D();
	    for (int row = 0; row < pixels.length - 1; row++) {
	      for (int col = 0;  col < pixels[0].length - 1; col++) {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col + 1];
	        topPixel = pixels[row][col];
	        bottomPixel = pixels[row + 1][col];
	        if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist || topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
	          leftPixel.setColor(Color.BLACK);
	        else
	          leftPixel.setColor(Color.WHITE);
	      }
	    }
  }
  
  //Added
  public void edgeDetection2(int edgeDist) {
      Pixel currentPixel = null, testPixel = null;
      
      int testWidth = 3;
      int testHeight = 3;
      
      Pixel[][] pixels = this.getPixels2D();
      double[][] edgeAngle = new double[Math.round(pixels.length / testHeight)][Math.round(pixels[0].length / testWidth)];
      
      for (int row = 0; row < pixels.length - testHeight; row += testHeight) {
          for (int col = 0; col < pixels[0].length - testWidth; col += testWidth) {
              Pixel[][] currentPixels = this.getPixelCluster(pixels, row, col, testWidth, testHeight);
              
              double greatestDistance = -10;
              double greatestAngle = -1;
              for (double angle = 0; angle < Math.PI + 0.1; angle += Math.PI / 8) {
                  ArrayList<Pixel> group1 = this.getPartialArray(currentPixels, angle, 0);
                  Color group1Color = this.getAverageColor(this.getPixelColors(group1));
                  ArrayList<Pixel> group2 = this.getPartialArray(currentPixels, angle, 1);
                  Color group2Color = this.getAverageColor(this.getPixelColors(group2));
                  
                  double currentColorDistance = this.colorDistance(group1Color, group2Color);
                  
                  if (currentColorDistance > greatestDistance) {
                      greatestDistance = currentColorDistance;
                      greatestAngle = angle;
                  }
                  
              }
              
              greatestAngle = Math.round(greatestAngle * 100.0) / 100.0;
              edgeAngle[row / testHeight][col / testWidth] = greatestAngle;
              
              
              if (greatestDistance > edgeDist) {
                  ArrayList<Pixel> group1 = this.getPartialArray(currentPixels, greatestAngle, 0);
                  ArrayList<Pixel> group2 = this.getPartialArray(currentPixels, greatestAngle, 1);
                  
                  for (Pixel pixel : group1) {
                      pixel.setColor(Color.BLACK);
                  }
                  
                  for (Pixel pixel : group2) {
                      pixel.setColor(Color.WHITE);
                  }
              }
              else {
                  for (Pixel[] pixelArray : currentPixels) {
                      for (Pixel pixel : pixelArray) {
                          pixel.setColor(Color.WHITE);
                      }
                  }
              }
          }
      }
      
      File file = new File("outputAngles.txt");
      try {
	      PrintWriter writer = new PrintWriter(file, "UTF-8");
	      
	      
	      for (int row = 0; row < edgeAngle.length; row++) {
	          for (int col = 0; col < edgeAngle[0].length; col++) {
	              writer.print(edgeAngle[row][col]);
	              writer.print(" ");
	          }
	          writer.print("\n");
	      }
	      writer.close();
      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
  }
  
  //Added
  public double colorDistance(Color testColor1, Color testColor2) {
      double redDistance = testColor2.getRed() - testColor1.getRed();
      double greenDistance = testColor2.getGreen() - testColor1.getGreen();
      double blueDistance = testColor2.getBlue() - testColor1.getBlue();
      double distance = Math.sqrt(redDistance * redDistance + 
                                  greenDistance * greenDistance +
                                  blueDistance * blueDistance);
      return distance;
  }
  
  //Added
  public Color getAverageColor(Color[] myColors) {
      int totalRed = 0;
      int totalGreen = 0;
      int totalBlue = 0;
      
      int total = 0;
      
      for (Color currentColor : myColors) {
          totalRed += currentColor.getRed();
          totalGreen += currentColor.getGreen();
          totalBlue += currentColor.getBlue();
          total++;
      }
      
      return new Color(totalRed / total, totalGreen / total, totalBlue / total);
      
  }
  
  //Added
  public Color[] getPixelColors(ArrayList<Pixel> pixels) {
      Color[] myColors = new Color[pixels.size()];
      int count = 0;
      for (Pixel currentPixel : pixels) {
          myColors[count] = currentPixel.getColor();
          count++;
      }
      
      return myColors;
  }
  
  //Added
  public Pixel[][] getPixelCluster(Pixel[][] pixels, int startRow, int startCol, int width, int height) {
      Pixel[][] pixelCluster = new Pixel[height][width];
      
      if (pixels.length < startRow + height || pixels[0].length < startCol + width) {
          return pixelCluster;
      }
      
      for (int row = startRow; row < startRow + height; row++) {
          for (int col = startCol; col < startCol + width; col++) {
              pixelCluster[row - startRow][col - startCol] = pixels[row][col];
          }
      }
      
      return pixelCluster;
  }
  
  //Added
  public ArrayList<Pixel> getPartialArrayLine(Pixel[][] fullArray, double angle, int typeOf) {
      int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Pixel> tempList = new ArrayList<Pixel>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++) {
              int currentRow = i / cols, currentCol = i % cols;
              if (currentCol == (newSlope * (currentRow - centerRow) + centerCol)) {
                  if (typeOf == 1) {
                      tempList.add(fullArray[currentRow][currentCol]);
                  }
              }
              else {
                  if (typeOf == 0) {
                      tempList.add(fullArray[currentRow][currentCol]);
                  }
              }
          }
          
          return tempList;
  }
  
  //Added
  public ArrayList<Pixel> getPartialArray(Pixel[][] fullArray, double angle, int typeOf) {
      int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Pixel> tempList = new ArrayList<Pixel>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++) {
              int currentRow = i / cols, currentCol = i % cols;
              if (currentCol < (newSlope * (currentRow - centerRow) + centerCol)) {
                  if (typeOf == 1) {
                      tempList.add(fullArray[currentRow][currentCol]);
                  }
              }
              else {
                  if (typeOf == 0) {
                      tempList.add(fullArray[currentRow][currentCol]);
                  }
              }
          }
          
          return tempList;
  }
  
  //Added
  public static ArrayList<Integer> getPartialArray(int[][] fullArray, double angle, int typeOf) {
          int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Integer> tempList = new ArrayList<Integer>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++) {
              int currentRow = i / cols, currentCol = i % cols;
              System.out.println(i + "\t" + currentRow + " " + currentCol);
              if (currentCol < (newSlope * (currentRow - centerRow) + centerCol)) {
                  if (typeOf == 1) {
                      tempList.add(fullArray[currentRow][currentCol]);
                      System.out.println("added " + i);
                  }
              }
              else {
                  if (typeOf == 0) {
                      
                      tempList.add(fullArray[currentRow][currentCol]);
                      System.out.println("added " + i);
                  }
              }
          }
          
          return tempList;
      }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
