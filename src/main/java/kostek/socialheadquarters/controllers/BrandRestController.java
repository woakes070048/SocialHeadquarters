package kostek.socialheadquarters.controllers;

import kostek.socialheadquarters.models.AbstractSocialMediaAccount;
import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import kostek.socialheadquarters.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by Michal Kostewicz on 26.03.16.
 */
@RestController
public class BrandRestController {
    @Autowired
    BrandService brandService;

    @RequestMapping(value = "/brand/", method = RequestMethod.GET)
    public ResponseEntity<Set<Brand>> listAllBrands() {
        Set<Brand> brands = brandService.findAllEntities();
        if (brands.isEmpty()) {
            return new ResponseEntity<Set<Brand>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Set<Brand>>(brands, HttpStatus.OK);
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Brand> getBrand(@PathVariable("id") Long id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Brand>(brand, HttpStatus.OK);
    }

    @RequestMapping(value = "/brand/", method = RequestMethod.POST)
    public ResponseEntity<Void> saveBrand(@RequestBody Brand brand, UriComponentsBuilder ucBuilder) {
        if (brandService.isEntityExist(brand)) {
            System.out.println("A Brand with name " + brand.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        brandService.save(brand);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/brand/{id}").buildAndExpand(brand.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Long id, @RequestBody Brand brand) {
        Brand currentBrand = brandService.findById(id);

        if (currentBrand == null) {
            System.out.println("Brand with id " + id + " not found");
            return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
        }

        currentBrand.setName(brand.getName());
        currentBrand.setDescription(brand.getDescription());

        brandService.updateEnity(currentBrand);
        return new ResponseEntity<Brand>(currentBrand, HttpStatus.OK);
    }

    @RequestMapping(value = "/brand/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Brand> deleteBrand(@PathVariable("id") Long id) {
        Brand brand = brandService.findById(id);
        if (brand == null) {
            System.out.println("Unable to delete. Brand with id " + id + " not found");
            return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
        }
        brandService.deleteEntityById(id);
        return new ResponseEntity<Brand>(HttpStatus.NO_CONTENT);
    }

}


