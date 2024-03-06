public class Main {
    public static void main(String[] args) {
        FoodCategory foodCategory = new FoodCategory();
        BeverageCategory beverageCategory = new BeverageCategory();
        MedicineCategory medicineCategory = new MedicineCategory();

        FoodProduct miInstan = new FoodProduct("Mi Instan", 3500);
        FoodProduct kue = new FoodProduct("Kue", 5000);
        BeverageProduct airMineral = new BeverageProduct("Air Mineral", 3000);
        BeverageProduct tehHijau = new BeverageProduct("Teh Hijau", 7000);
        MedicineProduct obatPusing = new MedicineProduct("Obat Pusing", 12000);
        MedicineProduct obatMual = new MedicineProduct("Obat Mual", 8500);

        System.out.println(foodCategory.getCategoryDescription());
        miInstan.displayProductInfo();
        System.out.println();
        kue.displayProductInfo();
        System.out.println();

        System.out.println(beverageCategory.getCategoryDescription());
        airMineral.displayProductInfo();
        System.out.println();
        tehHijau.displayProductInfo();
        System.out.println();

        System.out.println(medicineCategory.getCategoryDescription());
        obatPusing.displayProductInfo();
        System.out.println();
        obatMual.displayProductInfo();
    }
}