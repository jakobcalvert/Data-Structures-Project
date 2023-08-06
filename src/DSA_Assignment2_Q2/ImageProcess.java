/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSA_Assignment2_Q2;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xhu
 */
public class ImageProcess {

    BufferedImage buffered_image = null;

    public ImageProcess(String image) {
        try {
            buffered_image = ImageIO.read(new File(image));
        } catch (IOException ex) {
            Logger.getLogger(ImageProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reverseColour() {
        int width = buffered_image.getWidth();
        int hight = buffered_image.getHeight();
        WritableRaster writeable_raster = buffered_image.getRaster();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                int colour = buffered_image.getRGB(j, i);

                int[] pixel = new int[3];
                pixel[2] = colour & 0xff;               //blue
                pixel[1] = (colour & 0xff00) >> 8;      //green
                pixel[0] = (colour & 0xff0000) >> 16;   //red

                pixel[0] = 255 - pixel[0];
                pixel[1] = 255 - pixel[1];
                pixel[2] = 255 - pixel[2];

                writeable_raster.setPixel(j, i, pixel);
            }
        }

    }

    public void save(String imageName) {
        int i = imageName.indexOf(".");
        String type = imageName.substring(i + 1);
        try {
            ImageIO.write(buffered_image, type, new File(imageName));
        } catch (IOException e) {
            System.err.println("image not saved.");
        }
    }

    public void addNoise(float density) {
        int width = buffered_image.getWidth();
        int hight = buffered_image.getHeight();
        WritableRaster writeable_raster = buffered_image.getRaster();
        for (int i = 0; i < hight; i++) {
            for (int j = 0; j < width; j++) {
                int colour = buffered_image.getRGB(j, i);

                int[] pixel = new int[3];
                pixel[2] = colour & 0xff;               //blue
                pixel[1] = (colour & 0xff00) >> 8;      //green
                pixel[0] = (colour & 0xff0000) >> 16;   //red

                if (Math.random() < density) {
                    int noise = (int) (255 * Math.round(Math.random()));
                    pixel[0] = noise;
                    pixel[1] = noise;
                    pixel[2] = noise;
                }

                writeable_raster.setPixel(j, i, pixel);
            }
        }
    }

    public void cleanNoise() {
        int width = buffered_image.getWidth();
        int hight = buffered_image.getHeight();
        WritableRaster writeable_raster = buffered_image.getRaster();
        for (int i = 1; i < hight - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                //central pixel + 8 surrounding  pixels = 9 pixels
                //each pixel has 3 channels: Red, Green and Blue（Ignore alpha channel) 
                Integer[] intensity_r = new Integer[9];
                Integer[] intensity_g = new Integer[9];
                Integer[] intensity_b = new Integer[9];
                int index = 0;
                int[] pixel = new int[3];

                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        // get pixel colour
                        int colour = buffered_image.getRGB(j + k, i + l);

                        //get different colour channels(Red, Green and Blue)
                        pixel[2] = colour & 0xff;               //blue
                        pixel[1] = (colour & 0xff00) >> 8;      //green
                        pixel[0] = (colour & 0xff0000) >> 16;   //red

                        //pass the channels' colour to different intensity array
                        intensity_b[index] = pixel[2];
                        intensity_g[index] = pixel[1];
                        intensity_r[index] = pixel[0];
                        index++;

                    }
                }

                // Sort 9 pixels' for each channel 
                // please add your code here
                // start of your code (take as many lines as you need)
                // 1. create SortableArray object                              
                // 2. pass intensity_r[] to the SortableArray object                
                // 3. call quickSort() from SortableArray object
                // 4. do steps 2 and 3 for intensity_g and intensity_b
                
                //Sorts each of the arrays and then sets the pixel to be equal to the median
                SortableArray<Integer> array = new SortableArray<>();
                array.setArray(intensity_r);
                array.quickSort();
                pixel[0] = (int) array.sortedArray.get(4);

                array.setArray(intensity_b);
                array.quickSort();
                pixel[2] = (int) array.sortedArray.get(4);

                array.setArray(intensity_g);
                array.quickSort();
                pixel[1] = (int) array.sortedArray.get(4);               
                
                // end of your code

                // index 4 always points to medain after sorting
                // replace the pixel's each channel value by the median
                // save the pixel to an image
                writeable_raster.setPixel(j, i, pixel);
            }
        }
    }
}
