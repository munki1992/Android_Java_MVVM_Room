package munki.db.room.ui.main;

import dagger.Module;
import dagger.Provides;
import munki.db.room.GlobalApplication;
import munki.db.room.data.repository.WordRepository;

/**
 * [Dagger] - Inject with ViewModel
 * @author 나비이쁜이
 * @since 2020.11.26
 */
@Module
public class MainModule {

    @Provides
    MainViewModel createViewModel(GlobalApplication application) {
        return new MainViewModel(application, new WordRepository(application));
    }
}
