package munki.db.room.ui.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * BaseViewHolder
 * @author 나비이쁜이
 * @since 2020.01.20
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    /**
     * 생성자
     */
    public BaseViewHolder(@NonNull View view) {
        super(view);

        // 아이템 재활용 여부
        this.setIsRecyclable(false);
    }

    /**
     * Item Bind
     */
    public abstract void bind(T itemVo, Integer position);
}
