package com.example.hucegym.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hucegym.R;
import com.example.hucegym.databinding.NhacNhoRowItemBinding;
import com.example.hucegym.model.NhacNho;

import java.util.List;

public class NhacNhoAdapter extends RecyclerView.Adapter<NhacNhoAdapter.NhacNhoViewHolder> {

    private List<NhacNho> listNhacNho;
    private NhacNhoClickListener listener;

    public NhacNhoAdapter(List<NhacNho> listNhacNho, NhacNhoClickListener listener) {
        this.listNhacNho = listNhacNho;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NhacNhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NhacNhoRowItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.nhac_nho_row_item, parent, false);
        return new NhacNhoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NhacNhoViewHolder holder, int position) {
        NhacNho nhacNho = listNhacNho.get(position);
        holder.bind(nhacNho);
    }

    @Override
    public int getItemCount() {
        return listNhacNho.size();
    }

    public void submitList(List<NhacNho> nhacNhos) {
    }

    public class NhacNhoViewHolder extends RecyclerView.ViewHolder {

        private final NhacNhoRowItemBinding binding;

        public NhacNhoViewHolder(NhacNhoRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Thêm phương thức bind để thực hiện việc binding dữ liệu
        public void bind(NhacNho nhacNho) {
//            binding.setNhacNho(nhacNho);
            binding.executePendingBindings();

            // Xử lý sự kiện click ở đây
            binding.getRoot().setOnClickListener(view -> listener.onNhacNhoClick(nhacNho));
        }
    }

    public interface NhacNhoClickListener {
        void onNhacNhoClick(NhacNho nhacNho);
    }
}
