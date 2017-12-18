package net.zdome.cs371.epp.photofun;

/**
 *  class GUIState maintains the state of GUI control values.
 *
 *  @author Edward C. Epp
 *  @version December 2017
 *   https://github.com/edcepp/PhotoFunPattern
 */


public class GUIState {

    private static final GUIState ourInstance = new GUIState();

    public static int ourBrightnessDelta;

    public GUIState()
    {
        ourBrightnessDelta = 0;
    }

}
