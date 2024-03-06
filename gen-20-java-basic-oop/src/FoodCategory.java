public class FoodCategory extends ProductCategory{

    public FoodCategory() {
        super("Makanan");
    }

    @Override
    public String getCategoryDescription() {
        return "Kategori ini berisi produk-produk makanan";
    }
}
