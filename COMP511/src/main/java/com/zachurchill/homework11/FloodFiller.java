package com.zachurchill.homework11;

public class FloodFiller {
    private char [][] image;

    public FloodFiller(char [][] image) {
        this.image = image;
    }

    public char [][] getRawImage() {
        return image;
    }

    public void fill(Point p, char substitute) {
        throw new UnsupportedOperationException("Your code here.");
    }

    @Override
    // This might help you debug
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < image.length; ++i) {
            builder.append(new String(image[i]));
            builder.append("\n");
        }
        return builder.toString();
   }
}
