package munki.db.room.ui.main;

import android.app.Application;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import munki.db.room.data.dao.Word;
import munki.db.room.data.repository.WordRepository;
import munki.db.room.ui.base.BaseViewModel;

/**
 * [MainActivity] View Model
 * @author 나비이쁜이
 * @since 2020.11.26
 */
public class MainViewModel extends BaseViewModel<MainNavigator> {

    /**
     * Room Repository
     */
    private final WordRepository mRepository;

    /**
     * LiveData - Room Word
     */
    private LiveData<List<Word>> mAllWords;
    LiveData<List<Word>> getAllWords() {
        if (mAllWords == null) {
            mAllWords = new MutableLiveData<List<Word>>() {};
        }
        return mAllWords;
    }

    /**
     * 생성자
     */
    MainViewModel(@NonNull Application application, WordRepository mRepository) {
        super(application);

        this.mRepository = mRepository;
        mAllWords = this.mRepository.getmAllWords();
    }

    /**
     * insert DB
     */
    private void insert(Word word) {
        this.mRepository.insert(word);
    }

    /**
     * Edittext Action done
     */
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            insert(new Word(getNavigation().getString()));
            return true;
        }

        return false;
    }
}
