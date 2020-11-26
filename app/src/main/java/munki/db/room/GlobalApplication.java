package munki.db.room;

import android.content.Context;

import androidx.multidex.MultiDex;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.HasAndroidInjector;
import munki.db.room.di.component.DaggerApplicationComponent;

/**
 * Activity에서 공통적으로 적용되는 상위 MultiDexApplication
 * @author 나비이쁜이
 * @since 2020.11.26
 */
public class GlobalApplication extends DaggerApplication implements HasAndroidInjector {

    /**
     * ContributesAndroidInjector를 사용하기 위한 Injector
     */
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).create();
    }

    /**
     * attachBaseContext
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // MultiDex init
        MultiDex.install(this);
    }
}
