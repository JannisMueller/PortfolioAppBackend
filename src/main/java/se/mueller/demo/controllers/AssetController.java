package se.mueller.demo.controllers;

import org.springframework.web.bind.annotation.*;
import se.mueller.demo.entity.Asset;
import se.mueller.demo.entity.CurrentValue;
import se.mueller.demo.services.AssetService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5050/assets")

@RestController

public class AssetController {

    private AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/assets")
    List<Asset> findAll() {
        return service.getAllAssets();
    }

    @PostMapping("/assets")
    Asset addAsset(@RequestBody Asset asset) {
        return service.addAsset(asset);
    }
    @PatchMapping("/assets/{id}")
    Asset updateAsset(@RequestBody CurrentValue currentValue, @PathVariable Long id){

        return service.updateAsset(currentValue, id);
    }

    @DeleteMapping("/assets/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}

