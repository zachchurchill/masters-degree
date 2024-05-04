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
        if (p.x < 0 || p.x >= this.image.length || p.y < 0 || p.y >= this.image[0].length) {
            throw new IllegalArgumentException();
        }

        boolean keepFilling = true;
        for (int j = p.y; j < this.image[p.x].length; ++j) {
            if (this.image[p.x][j] != '.' && keepFilling) {
                this.image[p.x][j] = substitute;
            } else if (keepFilling) {
                keepFilling = false;
            }
        }

        for (int i = 0; i < p.x; ++i) {
            for (int j = 0; j < this.image[i].length; ++j) {
                if (this.image[i][j] == '.') {
                    continue;
                } else if (
                    didBelowChange(new Point(i, j), substitute) ||
                    didAboveChange(new Point(i, j), substitute) ||
                    didLeftChange(new Point(i, j), substitute) ||
                    didRightChange(new Point(i, j), substitute)
                ) {
                    this.image[i][j] = substitute;
                }
            }
            for (int j = this.image[i].length - 1; j >= 0 ; --j) {
                if (this.image[i][j] == '.') {
                    continue;
                } else if (
                    didBelowChange(new Point(i, j), substitute) ||
                    didAboveChange(new Point(i, j), substitute) ||
                    didLeftChange(new Point(i, j), substitute) ||
                    didRightChange(new Point(i, j), substitute)
                ) {
                    this.image[i][j] = substitute;
                }
            }
        }

        for (int i = p.x + 1; i < this.image.length; ++i) {
            for (int j = 0; j < this.image[i].length; ++j) {
                if (this.image[i][j] == '.') {
                    continue;
                } else if (
                    didBelowChange(new Point(i, j), substitute) ||
                    didAboveChange(new Point(i, j), substitute) ||
                    didLeftChange(new Point(i, j), substitute) ||
                    didRightChange(new Point(i, j), substitute)
                ) {
                    this.image[i][j] = substitute;
                }
            }
            for (int j = this.image[i].length - 1; j >= 0 ; --j) {
                if (this.image[i][j] == '.') {
                    continue;
                } else if (
                    didBelowChange(new Point(i, j), substitute) ||
                    didAboveChange(new Point(i, j), substitute) ||
                    didLeftChange(new Point(i, j), substitute) ||
                    didRightChange(new Point(i, j), substitute)
                ) {
                    this.image[i][j] = substitute;
                }
            }
        }
    }

    private boolean didLeftChange(Point p, char substitute) {
        if (p.y - 1 < 0) {
            return false;
        }
        return this.image[p.x][p.y - 1] == substitute;
    }

    private boolean didRightChange(Point p, char substitute) {
        if (p.y + 1 >= this.image[0].length) {
            return false;
        }
        return this.image[p.x][p.y + 1] == substitute;
    }

    private boolean didAboveChange(Point p, char substitute) {
        if (p.x - 1 < 0) {
            return false;
        }
        return this.image[p.x - 1][p.y] == substitute;
    }

    private boolean didBelowChange(Point p, char substitute) {
        if (p.x + 1 >= this.image.length) {
            return false;
        }
        return this.image[p.x + 1][p.y] == substitute;
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
