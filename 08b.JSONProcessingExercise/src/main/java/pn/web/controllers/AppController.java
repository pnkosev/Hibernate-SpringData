package pn.web.controllers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import pn.services.api.PartService;
import pn.services.api.SupplierService;

@Controller
public class AppController implements CommandLineRunner {
    private final static String SUPPLIERS_SEED_PATH = "src/main/resources/json/suppliers.json";
    private final static String PARTS_SEED_PATH = "src/main/resources/json/parts.json";

    private final SupplierService supplierService;
    private final PartService partService;

    public AppController(SupplierService supplierService, PartService partService) {
        this.supplierService = supplierService;
        this.partService = partService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedDatabase();

        System.out.println("yoyo");
    }

    private void seedDatabase() {
        this.seedSuppliers();
        this.seedParts();
    }

    private void seedSuppliers() {
        this.supplierService.seedMultipleSuppliersFromJSON(SUPPLIERS_SEED_PATH);
    }

    private void seedParts() {
        this.partService.seedMultipleParts(PARTS_SEED_PATH);
    }
}