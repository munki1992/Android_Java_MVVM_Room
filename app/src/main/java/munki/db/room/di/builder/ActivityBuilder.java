package munki.db.room.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import munki.db.room.ui.main.MainActivity;
import munki.db.room.ui.main.MainModule;

/**
 * [Dagger] Module - 생성 공급자
 * @author 나비이쁜이
 * @since 2020.01.20
 */
@Module
public abstract class ActivityBuilder {

    /**
     * Module 지정(Component 위치 지정) -> Inject 위치 지정
     */

    // LoginActivity
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();
}
