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

        char originalColor = this.image[p.x][p.y];
        QueueImpl<Point> points = new QueueImpl<>();
        Point point;
        points.enqueue(p);
        while(!points.isEmpty()) {
            point = points.dequeue();
            this.image[point.x][point.y] = substitute;
            if (isLeftSameColor(point, originalColor)) {
                points.enqueue(new Point(point.x, point.y - 1));
            }
            if (isRightSameColor(point, originalColor)) {
                points.enqueue(new Point(point.x, point.y + 1));
            }
            if (isAboveSameColor(point, originalColor)) {
                points.enqueue(new Point(point.x - 1, point.y));
            }
            if (isBelowSameColor(point, originalColor)) {
                points.enqueue(new Point(point.x + 1, point.y));
            }
        }
    }

    private boolean isLeftSameColor(Point p, char color) {
        if (p.y - 1 < 0) {
            return false;
        }
        return this.image[p.x][p.y - 1] == color;
    }

    private boolean isRightSameColor(Point p, char color) {
        if (p.y + 1 >= this.image[0].length) {
            return false;
        }
        return this.image[p.x][p.y + 1] == color;
    }

    private boolean isAboveSameColor(Point p, char color) {
        if (p.x - 1 < 0) {
            return false;
        }
        return this.image[p.x - 1][p.y] == color;
    }

    private boolean isBelowSameColor(Point p, char color) {
        if (p.x + 1 >= this.image.length) {
            return false;
        }
        return this.image[p.x + 1][p.y] == color;
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
