package munki.db.room.di.component;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import munki.db.room.GlobalApplication;
import munki.db.room.di.builder.ActivityBuilder;
import munki.db.room.di.module.AppModule;

/**
 * Dagger를 사용하기 위한 Application 최상단 init를 위한 Component - Module을 불러오고 어디로 주입할지를 결정하는 역할
 * AndroidInjectionModule.class와 AndroidSupportInjectionModule.class 가 존재합니다.
 * Dagger2에서는 Application scope인 @Singleton @Provides를 이용하기 위해서는 @Singleton @Component를 이용해야 합니다.
 * Dagger2에서는 @Component는 interface or abstract class에만 붙일 수 있습니다.
 * @author 나비이쁜이
 * @since 2020.01.20
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<GlobalApplication> {

    /**
     * Application 단위에서 초기화하기 위한 Builder입니다.
     * 컴포넌트를 생성하기 위한 빌드용 Annotation
     */
    @Component.Builder
    interface Builder {

        /**
         * Componet에서 application을 관리하기 시작
         */
        @BindsInstance
        Builder application(GlobalApplication application);

        ApplicationComponent create();
    }

    void inject(GlobalApplication app);
}
