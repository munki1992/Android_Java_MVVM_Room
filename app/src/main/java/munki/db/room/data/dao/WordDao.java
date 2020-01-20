package munki.db.room.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * DAO
 * @author 나비이쁜이
 * @since 2020.01.20
 */
@Dao
public interface WordDao {

    /**
     * select
     */
    @Query("SELECT * from search_table ORDER BY search ASC")
    LiveData<List<Word>> getAlphabetizedWords();

    /**
     * insert
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    /**
     * delete All
     */
    @Query("DELETE FROM search_table")
    void deleteAll();
}
