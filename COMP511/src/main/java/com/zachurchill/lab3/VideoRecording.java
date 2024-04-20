package com.zachurchill.lab3;

/**
 * VideoRecording provides class for media items related to videos.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class VideoRecording extends AbstractMediaItem
{
    @Override
    public Money getOverdueFee() {
        return new Dollar(0, 50);
    }
}
