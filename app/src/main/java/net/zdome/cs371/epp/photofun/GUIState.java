package net.zdome.cs371.epp.photofun;

/**
 * Created by eepp on 12/16/17.
 */


public class GUIState {

    private static final GUIState ourInstance = new GUIState();

    public static int ourBrightnessDelta;

    public GUIState()
    {
        ourBrightnessDelta = 0;
    }

}
