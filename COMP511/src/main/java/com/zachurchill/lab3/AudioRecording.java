package com.zachurchill.lab3;

/**
 * AudioRecording provides media item related to audio recordings.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class AudioRecording extends AbstractMediaItem
{
    private String artist;
    
    /**
     * Returns the name of the recording artist.
     * 
     * @return  the name of the recording artist.
     */
    public String getArtist()
    {
        return this.artist;
    }    
    
    /**
     * Sets the name of the recording artist.
     * 
     * @param   name    the name of the recording artist.
     */
    public void setArtist(String name)
    {
        if (name == null || name.trim() == "") {
            throw new IllegalArgumentException("non-empty string expected");
        }
        this.artist = name;
    }    

    @Override
    public Money getOverdueFee() {
        return new Dollar(0, 50);
    }
}
