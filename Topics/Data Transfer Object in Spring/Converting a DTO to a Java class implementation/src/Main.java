
class Solution {
    Product convertProductDTOToProduct(ProductDTO dto) {
        java.time.LocalDate arrivalDate = java.time.LocalDate.of(2023, 1, 15);
        Product ans = new Product(dto.getId(), dto.getModel(), dto.getPrice(), arrivalDate, "SuperVendor");
        return ans;
    }
}