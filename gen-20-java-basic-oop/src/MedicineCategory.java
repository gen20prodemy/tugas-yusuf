public class MedicineCategory extends ProductCategory{
    public MedicineCategory() {
        super("Obat");
    }

    @Override
    public String getCategoryDescription() {
        return "Kategori ini berisi produk-produk obat-obatan";
    }
}
