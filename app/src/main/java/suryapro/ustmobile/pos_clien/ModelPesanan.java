package suryapro.ustmobile.pos_clien;

public class ModelPesanan {
    String id, nama, total, status_pembayaran;

    public ModelPesanan(){}

    public ModelPesanan(String id, String nama, String total, String status_pembayaran) {
        this.id = id;
        this.nama = nama;
        this.total = total;
        this.status_pembayaran = status_pembayaran;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getNama(){return nama;}

    public void setNama(String nama){this.nama = nama;}

    public String getTotal(){return total;}

    public void setTotal(String total){this.total = nama;}

    public String getStatus_pembayaran(){return status_pembayaran;}

    public void setStatus_pembayaran(String status_pembayaran){this.status_pembayaran = status_pembayaran;}


}
