package warehouse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private WarehouseRepository repository;

    @GetMapping("/allproducts")
    public List<ProductData> getallproducts (){
        return repository.findAll();
    }

    @GetMapping("/{productid}")
    public ProductData getproductbyid (@PathVariable String  productid){
        return repository.findByProductID(productid);
    }

    @PostMapping("/addproduct")
    public ProductData addproduct (@RequestBody ProductData productData) {
        return repository.save(productData);
    }

    @DeleteMapping("delete/{productid}")
    public void deleteproductbyid (String productid){
        ProductData exist = repository.findByProductID(productid);
        if(exist != null){
            repository.deleteById(productid);
        }
    }
}
