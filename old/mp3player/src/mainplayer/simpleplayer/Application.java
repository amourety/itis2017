package mainplayer.simpleplayer;

/**
 * Created by amour on 24.02.2017.
 */
public abstract class Application {
    protected String args[];

    public Application(String args[]) {
        this.args = args;
        this.init();
        this.start();
    }
    public abstract void init();
    public abstract void start();
}