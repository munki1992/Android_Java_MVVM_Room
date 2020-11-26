package munki.db.room.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import munki.db.room.R;
import munki.db.room.data.dao.Word;
import munki.db.room.databinding.RecyclerviewItemBinding;
import munki.db.room.ui.base.BaseViewHolder;

/**
 * MainAdapter
 * @author 나비이쁜이
 * @since 2020.11.26
 */
public class MainAdapter extends RecyclerView.Adapter<BaseViewHolder<Word>> {

    /**
     * Context & Word
     */
    private Context mContext;
    private List<Word> mWords;

    /**
     * 생성자
     */
    MainAdapter(Context context) {
        this.mContext = context;
    }

    /**
     * onCreateViewHolder
     */
    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false));
    }

    /**
     * onBindViewHolder
     */
    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<Word> holder, int position) {
        holder.bind(mWords.get(holder.getAdapterPosition()), position);
    }

    /**
     * Set Word
     */
    void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    /**
     * Item Count
     */
    @Override
    public int getItemCount() {
        return mWords != null ? mWords.size() : 0;
    }

    /**
     * ViewHolder
     */
    public class ViewHolder extends BaseViewHolder<Word> {

        /**
         * databinding
         */
        private RecyclerviewItemBinding mItemBinding;

        /**
         * 생성자
         */
        private ViewHolder(@NonNull View view) {
            super(view);

            // set Binding
            mItemBinding = DataBindingUtil.bind(view);
        }

        @Override
        public void bind(Word itemVo, Integer position) {
            mItemBinding.textView.setText(itemVo != null ? itemVo.getSearchWord() : "null");
        }

    }
}


