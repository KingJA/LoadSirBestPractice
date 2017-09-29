package sample.kingja.loadsirbestpractice.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Description：RecyclerView 通用适配器
 * Create Time：2016/8/16 10:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public abstract class BaseRvAdaper<T> extends RecyclerView.Adapter<BaseRvAdaper.ViewHolder> {
    protected String TAG = getClass().getSimpleName();

    protected OnItemClickListener onItemClickListener;
    protected OnItemLongClickListener onItemLongClickListener;
    protected Context context;
    protected List<T> list;

    public interface OnItemClickListener<T> {
        void onItemClick(T t, int position);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLongClick(T t, int position);
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {

        this.onItemLongClickListener = onItemLongClickListener;
    }

    public BaseRvAdaper(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(getItemView(), parent, false);
        return createViewHolder(v);
    }

    protected abstract ViewHolder createViewHolder(View v);

    protected abstract int getItemView();

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        bindHolder(holder, list.get(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(list.get(position), position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(list.get(position), position);
                }
                return true;
            }
        });

    }

    protected abstract void bindHolder(ViewHolder baseHolder, T t, int position);

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void setData(List<T> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    public void addData(List<T> list) {
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }

    public void reset() {
        this.list.clear();
    }

    public List<T> getData() {
        return list;
    }
}
