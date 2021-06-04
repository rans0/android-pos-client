package suryapro.ustmobile.pos_clien;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MenuViewHolder> {
    private CartActivity cartActivity;
    private List<ModelPesanan> mMenu;

    public CartAdapter(CartActivity cartActivity, List<ModelPesanan> mMenu) {
        this.cartActivity = cartActivity;
        this.mMenu = mMenu;
    }

    @NonNull
    @Override
    public CartAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(cartActivity).inflate(R.layout.item_cart, parent, false);
        return new CartAdapter.MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.MenuViewHolder holder, int position) {
        holder.namaMakanan.setText(mMenu.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return mMenu.size();
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView namaMakanan, deskripsiMakanan, hargaMakanan;
        Button addCart;
        public MenuViewHolder(@NonNull View itemMenu) {
            super(itemMenu);

            namaMakanan = itemMenu.findViewById(R.id.nama_makanan);
            deskripsiMakanan = itemMenu.findViewById(R.id.deskripsi_makanan);
            hargaMakanan = itemMenu.findViewById(R.id.harga_makanan);
            addCart = itemMenu.findViewById(R.id.btnAddToCart);
        }

    }
}
