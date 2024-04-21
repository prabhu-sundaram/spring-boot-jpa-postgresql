package com.dm.springbootjpapostgresql.example.productservice.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dm.springbootjpapostgresql.example.productservice.business.bean.ProductBean;
import com.dm.springbootjpapostgresql.example.productservice.entity.ProductEntity;
@Repository
public class ProductDAOWrapper {
    @Autowired
    private ProductDAO dao;
    
    public List<ProductBean>findAll(){
        List<ProductBean> list = new ArrayList<ProductBean>(); 
        Iterable<ProductEntity> listEn= dao.findAll();
        listEn.forEach(x->{
            ProductBean product = new ProductBean();
            BeanUtils.copyProperties(x, product);
            list.add(product);
        });
        return list;
    }
        
    public ProductBean findOne(Integer id){ 
            ProductEntity x= dao.findById(id).get();
            ProductBean product =null;
            if(x!=null){
                product = new ProductBean();        
                BeanUtils.copyProperties(x, product);
                }
            System.out.println(x);
        return product;
    }
    
    public Integer saveProduct(ProductBean product){
        ProductEntity productEntityBean = new ProductEntity();
        BeanUtils.copyProperties(product, productEntityBean);
        ProductEntity en=  dao.save(productEntityBean);
        return en.getId();  
    }
    
    public ProductBean updateProduct(ProductBean product){
        ProductEntity productEntityBean = new ProductEntity();
        BeanUtils.copyProperties(product, productEntityBean);
        ProductEntity en=  dao.save(productEntityBean);
        ProductBean product2 = new ProductBean();
        BeanUtils.copyProperties(en,product2);
        return product2;    
    }
    
    public void delete(int id){
        dao.deleteById(id);
    }
}
