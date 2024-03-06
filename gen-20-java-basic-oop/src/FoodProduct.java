public class FoodProduct extends Product{
    public FoodProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public void displayProductInfo(){
        super.displayProductInfo();
        ProductCategory category = new FoodCategory();
        System.out.println("Kategori: "+ category.getCategoryName());
    }
}
