package munki.db.room.data.dao;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity
 * [@Entity]        - 클래스를 엔티티로 어노테이션 | 클래스 이름이 아닌 경우 테이블 이름을 제공
 * [@PrimaryKey]    - 기본 키를 식별
 * [@ColumnInfo]    - Column Name이 변수 이름과 다른 경우에는 반드시 Column Name을 제공
 * @author 나비이쁜이
 * @since 2020.01.20
 */
@Entity(tableName = "search_table")
public class Word {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "search")
    private String mSearchWord;

    /**
     * this | instance
     */
    public Word(@NonNull String mSearchWord) {
        this.mSearchWord = mSearchWord;
    }

    /**
     * getter
     */
    @NonNull
    public String getSearchWord() {
        return this.mSearchWord;
    }
}
