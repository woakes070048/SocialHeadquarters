package kostek.socialheadquarters.controllers;

import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import kostek.socialheadquarters.services.BrandService;
import kostek.socialheadquarters.services.FacebookAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by Michal Kostewicz on 08.04.16.
 */
@RestController
public class FacebookAccountRestController {
    @Autowired
    FacebookAccountService facebookAccountService;
    @Autowired
    BrandService brandService;


    @RequestMapping(value = "/brand/facebookaccount/", method = RequestMethod.POST)
    public ResponseEntity<Void> saveFacebookAccount(@RequestBody FacebookAccount facebookAccount, UriComponentsBuilder ucBuilder) {
        if (facebookAccountService.isEntityExist(facebookAccount)) {
            System.out.println("A Facebook with appKey " + facebookAccount.getAppId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        facebookAccountService.save(facebookAccount);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/brand/facebook/{id}").buildAndExpand(facebookAccount.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/brand/facebookaccount/{id}", method = RequestMethod.PUT)
    public ResponseEntity<FacebookAccount> updateFacebookAccount(@PathVariable("id") Long id, @RequestBody FacebookAccount facebookAccount) {
        FacebookAccount currentFacebookAccount = facebookAccountService.findById(id);

        if (currentFacebookAccount == null) {
            System.out.println("FacebookAccount with id " + id + " not found");
            return new ResponseEntity<FacebookAccount>(HttpStatus.NOT_FOUND);
        }

        currentFacebookAccount.setAppId(facebookAccount.getAppId());
        currentFacebookAccount.setSecretKey(facebookAccount.getSecretKey());

        facebookAccountService.updateEnity(currentFacebookAccount);
        return new ResponseEntity<FacebookAccount>(currentFacebookAccount, HttpStatus.OK);
    }

    @RequestMapping(value = "/brand/{id}/facebookaccount/", method = RequestMethod.GET)
    public ResponseEntity<FacebookAccount> fetchBrandFacebookAccount(@PathVariable("id") Long id) {
        Brand currentBrand = brandService.findById(id);
        if (currentBrand == null) {
            System.out.println("Brand with id " + id + " not found");
            return new ResponseEntity<FacebookAccount>(HttpStatus.NOT_FOUND);
        }
        FacebookAccount facebookAccount = brandService.findFacebookAccountByBrandId(id);
        return new ResponseEntity<FacebookAccount>(facebookAccount, HttpStatus.OK);
    }
}
