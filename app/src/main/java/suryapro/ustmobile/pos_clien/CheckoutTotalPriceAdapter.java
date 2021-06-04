package suryapro.ustmobile.pos_clien;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckoutTotalPriceAdapter extends RecyclerView.Adapter<CheckoutTotalPriceAdapter.CheckoutViewHolder> {
    private CheckoutTotalPriceActivity activity;

    public CheckoutTotalPriceAdapter(CheckoutTotalPriceActivity activity){
        this.activity = activity;
    }

    @NonNull
    @Override

    public CheckoutViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int type) {
        View v = LayoutInflater.from(activity).inflate(R.layout.item_checkout, parent, false);
        return new CheckoutViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class CheckoutViewHolder extends RecyclerView.ViewHolder{
           public CheckoutViewHolder(@NonNull View itemCheckout){
               super(itemCheckout);
           }
    }
}
