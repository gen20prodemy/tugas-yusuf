public class BeverageCategory extends ProductCategory{

    public BeverageCategory() {
        super("Minuman");
    }

    @Override
    public String getCategoryDescription() {
        return "Kategori ini berisi produk-produk Minuman";
    }
}
