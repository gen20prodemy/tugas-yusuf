public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price){
        this.productName = productName;
        this.price = price;
    }

    public String getProductName(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void displayProductInfo(){
        System.out.println("Nama Produk: "+ productName);
        System.out.println("Harga: "+ price);
    }
}
