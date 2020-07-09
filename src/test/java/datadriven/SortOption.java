package datadriven;

public enum SortOption {
    OptionPriceLowToHigh("Price: Low to High"),
    OptionPriceHighToLow("Price: High to Low"),
    OptionAvgCustomerReview("Avg. Customer Review");
    private String sortOption;
    SortOption(String sortOption) {
        this.sortOption = sortOption;
    }
    public String getSortOption(){
        return this.sortOption;
    }
}
