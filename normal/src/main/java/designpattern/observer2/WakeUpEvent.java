package designpattern.observer2;

/**
 * 事件对象
 * Created by JesonLee
 * on 2017/5/10.
 */
public class WakeUpEvent {
    public int voice;
    private Kid source;

    public WakeUpEvent(int voice, Kid source) {
        this.voice = voice;
        this.source = source;
    }

    //拿到事件源对象，重要
    public Kid getSource() {
        return source;
    }
}
