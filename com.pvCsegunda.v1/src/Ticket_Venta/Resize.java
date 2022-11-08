package Ticket_Venta;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resize {

	
	
	
	public static void main(String[] args) {
		Resize  setpath = new Resize();
 
setpath.setUrl("E:/arrowResized.png");
	}

	
	public void setUrl(String path) {
	    try {

	        BufferedImage originalImage = ImageIO.read(new File(path));//change path to where file is located
	        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

	        BufferedImage resizeImageJpg = resizeImage(originalImage, type, 120, 120);
	        ImageIO.write(resizeImageJpg, "png", new File("E:/arrowResizeds.png")); //change path where you want it saved

	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
		
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
	    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	    Graphics2D g = resizedImage.createGraphics();
	    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	    g.dispose();




	    return resizedImage;
	}

}
