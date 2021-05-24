package com.unicamp.mc322.lab08.twittery.entity.tweet.media;

public class Image extends Media {
    private final static double MB_PER_RESOLUTION = 1;
    private final long pixelsOnVertical;
    private final long pixelsOnHorizontal;
    private final int colorDepth;

    public Image(ImageFormat format, long pixelsOnVertical, long pixelsOnHorizontal, int colorDepth) {
        super(format);

        if (pixelsOnHorizontal <= 0 || pixelsOnVertical <= 0 || colorDepth <= 0) {
            throw new IllegalArgumentException("Invalid arguments of Image!");
        }

        this.pixelsOnVertical = pixelsOnVertical;
        this.pixelsOnHorizontal = pixelsOnHorizontal;
        this.colorDepth = colorDepth;
    }

    @Override
    public void getTotalFileSizeMB() {
        long totalPixels = pixelsOnHorizontal * pixelsOnVertical;
        double totalSize = totalPixels * colorDepth;
        this.totalSizeMB = (((totalSize / 8) / 1024) / 1024) * MB_PER_RESOLUTION;
    }
}
