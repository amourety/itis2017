package mainplayer.simpleplayer;

/**
 * Created by amour on 24.02.2017.
 */
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class OutputDevice {
    private AudioInputStream ais;
    private Clip clip;
    private int framePosition;
    private static OutputDevice instance = null;

    private OutputDevice(File soundFile) {
        try {
            ais = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
        } catch (IOException ex) {
            getErrorInfo(ex, "Ошибка: ");
        }  catch (UnsupportedAudioFileException ex) {
            getErrorInfo(ex, "Невозможно воспроизвести файл (поддерживаются лишь форматы WAV, AU, AIF): ");
        }  catch (LineUnavailableException ex) {
            getErrorInfo(ex, "Возможно, этот файл используется другим приложением: ");
        }
    }

    public void play() {
        try {
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
        } catch (IOException ex) {
            getErrorInfo(ex, "Ошибка: ");
        } catch (LineUnavailableException ex) {
            getErrorInfo(ex, "Возможно, этот файл используется другим приложением: ");
        }
    }

    public void stop() {
        framePosition = clip.getFramePosition();
        clip.stop();
    }

    public void resume() {
        clip.setFramePosition(framePosition);
        clip.start();
    }

    public void close() {
        clip.close();
    }

    public static OutputDevice getInstance(File soundFile) {
        if (instance == null)
            instance = new OutputDevice(soundFile);
        return instance;
    }

    private void getErrorInfo(Exception ex, String msg) {
        System.out.print(msg);
        System.err.println(ex.getMessage());
        System.exit(1);
    }
}
