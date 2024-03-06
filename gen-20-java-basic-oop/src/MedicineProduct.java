public class MedicineProduct extends Product{
    public MedicineProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public void displayProductInfo(){
        super.displayProductInfo();
        ProductCategory category = new MedicineCategory();
        System.out.println("Kategori: "+ category.getCategoryName());
    }
}
