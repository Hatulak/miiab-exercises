package app.lesson1.aspects;

import java.time.LocalDateTime;

public aspect Aspect3 {
    declare parents: (app.lesson1.model.*) implements WhenUsedCheckable;

    private LocalDateTime WhenUsedCheckable.lastUsedTime;

    private void WhenUsedCheckable.used() {
        lastUsedTime = LocalDateTime.now();
    }

    before(WhenUsedCheckable whenUsedCheckable):
            execution(* WhenUsedCheckable+.changeName(..)) && this(whenUsedCheckable){
        whenUsedCheckable.used();
    }

    public static LocalDateTime getLastChange(Object object){
        return ((WhenUsedCheckable) object).lastUsedTime;
    }

    public interface WhenUsedCheckable {
    }
}

