abstract class ProductCategory {
        private String categoryName;

    protected ProductCategory(String categoryName){
        this.categoryName = categoryName;
    }

        public String getCategoryName(){
        return categoryName;
    }

        public  void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }

        public abstract String getCategoryDescription();
}
