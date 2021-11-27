package sk.fri.uniza.sporthealthsystem.module.location.m_adresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.fri.uniza.sporthealthsystem.core.CrudController;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.entity.Address;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.service.AddressService;

@RestController
@RequestMapping("/api/locations/addresses")
public class AddressController extends CrudController<Address, String, AddressService> {

    @Autowired
    public AddressController(AddressService addressService) {
        super(addressService);
    }
}
