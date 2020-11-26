package munki.db.room.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import munki.db.room.data.WordRoomDatabase;
import munki.db.room.data.dao.Word;
import munki.db.room.data.dao.WordDao;

/**
 * Model - Repository
 * @author 나비이쁜이
 * @since 2020.11.26
 */
public class WordRepository {

    /**
     * DAO
     */
    private final WordDao wordDao;

    /**
     * Word List
     */
    private final LiveData<List<Word>> mAllWords;

    /**
     * 생성자
     */
    public WordRepository(Application application) {
        // get RoomDatabase
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);

        // getDAO
        wordDao = db.wordDao();

        // get All DAO List
        mAllWords = wordDao.getAlphabetizedWords();
    }

    /**
     * get All DAO List - Room은 별도의 스레드에서 모든 쿼리를 실행
     * LiveData는 데이터가 변경되면 Observer에게 확인함
     */
    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    /**
     * insert - UI 스레드 사용하지마시오
     */
    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> wordDao.insert(word));
    }
}
