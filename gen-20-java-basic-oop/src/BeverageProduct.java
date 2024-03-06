public class BeverageProduct extends Product{
    public BeverageProduct(String productName, int price) {
        super(productName, price);
    }

    @Override
    public void displayProductInfo(){
        super.displayProductInfo();
        ProductCategory category = new BeverageCategory();
        System.out.println("Kategori: "+ category.getCategoryName());
    }
}
