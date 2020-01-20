package munki.db.room.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import munki.db.room.data.dao.Word;
import munki.db.room.data.dao.WordDao;

/**
 * Room Database Backend
 * @author 나비이쁜이
 * @since 2020.01.20
 */
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    /**
     * DAO
     */
    public abstract WordDao wordDao();

    /**
     * instance
     */
    private static volatile WordRoomDatabase INSTANCE;

    /**
     * ExecutorService
     */
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    /**
     * getDatabase
     */
    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordRoomDatabase.class, "word_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * callback - execute
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            /**
             * 앱 재시작을 통해 데이터를 유지할 것인가?
             * 아래 코드 주석을 풀면 앱 종료후 재실행마다 저장한 DB를 모두 삭제함
             */
            databaseWriteExecutor.execute(() -> {
//                WordDao dao = INSTANCE.wordDao();
//                dao.deleteAll();
            });
        }
    };
}
