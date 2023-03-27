package com.roky.thunderspi.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roky.thunderspi.entities.CategoryProduct;
import com.roky.thunderspi.entities.MultiPicture;
import com.roky.thunderspi.entities.Product;
import com.roky.thunderspi.repositories.MultiPictureRepo;
import com.roky.thunderspi.services.IProductCategoryService;
import com.roky.thunderspi.services.IProductService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController  implements ServletContextAware {
    private IProductService iProductService;
    private IProductCategoryService iProductCategoryService;
    private MultiPictureRepo multiPictureRepo;
    ServletContext context;


    @GetMapping("/getAll")
    public List<Product> findAllProducts() {
        return iProductService.findAllProducts();
    }

    private String saveImage(MultipartFile multipartFile) {
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(context.getRealPath("/Imagess/" + multipartFile.getOriginalFilename()));
            Files.write(path, bytes);
            return multipartFile.getOriginalFilename();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
    @GetMapping("get/{id}")
    public Product findProdById(@PathVariable Long id) {
        return iProductService.findProdById(id);
    }

    @PostMapping("/add")
    public Product addProduct(@RequestParam("files") MultipartFile[] files,
                           @RequestParam("product") String product,
                           @RequestParam("file") MultipartFile image) throws JsonParseException, JsonMappingException, Exception {
        Product arti = new ObjectMapper().readValue(product, Product.class);
        boolean isExit = new File(context.getRealPath("/Imagess/")).exists();
        if (!isExit) {
            new File(context.getRealPath("/Imagess/")).mkdir();
            //System.out.println("mk dir Imagess.............");
        }
        //System.out.println("Save Article  22222.............");
        Set<MultiPicture> photos = new HashSet<>();
        for (MultipartFile file : files) {
            MultiPicture fileinfo = new MultiPicture();
            String filename = file.getOriginalFilename();
            String newFileName = FilenameUtils.getBaseName(filename) + "." + FilenameUtils.getExtension(filename);
            File serverFile = new File(context.getRealPath("/Imagess/" + File.separator + newFileName));
            try {
                System.out.println("Image");
                FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

            } catch (Exception e) {
                e.printStackTrace();
            }
            fileinfo.setName(newFileName);
            fileinfo.setImage(arti);
            multiPictureRepo.save(fileinfo);
            photos.add(fileinfo);
        }
        String fileName = image.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(fileName) + "." + FilenameUtils.getExtension(fileName);
        File serverFile = new File(context.getRealPath("/Imagess/" + File.separator + newFileName));
        try {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile, image.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Save Article 333333.............");
        arti.setPicture(newFileName);

        System.out.println("Save Article 333333.............");
        // arti.setProducts(photos);
        return iProductService.addProduct(arti);
    }


    @PutMapping("update")
    public Product editProduct(@RequestBody Product product) {
        return iProductService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        iProductService.deleteProduct(id);
    }

    @GetMapping(path = "/Imgarticles/{id}")
    public List<byte[]> getPhoto(@PathVariable("id") Long id) throws Exception {
        ArrayList<MultiPicture> files = new ArrayList<MultiPicture>();
        Product product = iProductService.findProdById(id);
        List<byte[]> fi = new ArrayList<>();
        files = multiPictureRepo.findByImage(product);
        System.out.println(files);

        for (MultiPicture file : files) {
            // fi.add(Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/")+file.getImage())));
            fi.add(Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/") + file.getName())));
        }

        return fi;
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<List<MultiPicture>> getImagesByProduct(@PathVariable("id") Long id) throws Exception {
        ArrayList<MultiPicture> files = new ArrayList<MultiPicture>();
        Product product = iProductService.findProdById(id);
        files = multiPictureRepo.findByImage(product);
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @GetMapping(path = "/getimage/{id}")
    public byte[] getPhotoProduct(@PathVariable("id") Long id) throws Exception {
        MultiPicture Article = multiPictureRepo.findById(id).orElseThrow(() -> new Exception("File by id " + id + " was not found"));
        ;
        return Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/") + Article.getName()));
    }

    @GetMapping("/catproducts/{id}")
    public ResponseEntity<List<Product>> getAllProductByCategory(@PathVariable("id") Long id) throws Exception {
        CategoryProduct category = iProductCategoryService.findProdById(id);
        List<Product> products = iProductService.getAllProductByCategory(category);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping(path = "/Imgarticle/{id}")
    public byte[] getProductImage(@PathVariable("id") Long id) throws Exception {
        Product Article = iProductService.findProdById(id);
        return Files.readAllBytes(Paths.get(context.getRealPath("/Imagess/") + Article.getPicture()));
    }

    @GetMapping("/add-etoile/{produit-id}/{client-id}/{rev}")
    @ResponseBody
    public void moyEtoile(@PathVariable("produit-id") Long produitId, @PathVariable("client-id") Long clientId, @PathVariable("rev") Double rev) throws Exception {
        iProductService.calculeEtoile(rev, produitId, clientId);
    }
}
